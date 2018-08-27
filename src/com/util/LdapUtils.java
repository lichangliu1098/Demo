package com.util;


import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.*;
import java.util.*;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Created by ccl on 2018/6/20.
 */
public class LdapUtils {
    public static Map<String,String> organizaCNName = new Hashtable<>();//组织机构中文名称

    public static Map<String,String> organizaDN_UID = new Hashtable<>();//组织机构路径_uid
    //protected final static Logger logger = LoggerFactory.getLogger(LdapUtils.class);
    private static InitialLdapContext dc = null;
    private static final String LDAP_URL = "ldap://118.31.249.161:389";//Configs.getString("ldap.url"); // LDAP访问地址
    private static final String root = "dc=jiagouyun,dc=com";//Configs.getString("ldap.root"); // LDAP的根节点的DC
    private static final String ADMINUSERNAME = "uid=zhuyunadmin,ou=Mgr,ou=SYSTEM,dc=jiagouyun,dc=com";//Configs.getString("ldap.adminusername"); // 用户名
    private static final String ADMINPASSWORD = "orPssIUsCerNrJMOpXz6";//Configs.getString("ldap.adminpassword"); // 密码

    //base   ：根节点(在这里是"dc=jiagouyun,dc=com")
    //scope  ：搜索范围,分为"base"(本节点),"one"(单层),""(遍历)
    //filter ：指定子节点(格式为"(objectclass=*)",*是指全部，你也可以指定某一特定类型的树节点)
    //查询用户信息
    private static final String SEARCH_USER_BASE = "ou=ZHUYUN,dc=jiagouyun,dc=com";//Configs.getString("ldap.userbase");
    private static String SEARCH_USER_SCOPE = "";//Configs.getString("ldap.userscope");
    private static final String SEARCH_USER_FILTER = "(|(objectClass=posixAccount)(objectClass=account))";//Configs.getString("ldap.userfilter");
    //查询组织信息
    private static final String SEARCH_ORGANIZA_BASE = "ou=ZHUYUN,dc=jiagouyun,dc=com";//Configs.getString("ldap.organizabase");
    private static String SEARCH_ORGANIZA_SCOPE = "";//Configs.getString("ldap.organizascope");
    private static final String SEARCH_ORGANIZA_FILTER = "(objectClass=organizationalUnit)";//Configs.getString("ldap.organizafilter");

    //要返回的属性
    private static final String[] RETURN_USER_ATTRS = {"cn","sn","uid","displayName","mail","uidNumber","entryUUID","entryDN"};
    private static final String[] RETURN_ORGANIZED_ATTRS = {"ou","description","entryUUID","entryDN"};

    public static boolean checkLdapUser(String userDom, String password) {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, userDom);
        env.put(Context.SECURITY_CREDENTIALS, password);
        try {
            dc = new InitialLdapContext(env, null);// 初始化上下文
            //logger.info("LDAP认证成功!");// 这里可以改成异常抛出。
            return true;
        } catch (javax.naming.AuthenticationException e) {
            //logger.error("LDAP认证失败:\n" + e.getMessage());
        } catch (Exception e) {
            //logger.error("LDAP认证出错:\n" + e.getMessage());
        }finally {
            if (dc != null) {
                try {
                    dc.close();
                } catch (NamingException e) {
                    //logger.error("NamingException in close():" + e);
                }
            }
        }
        return false;
    }

    /**
     * 初始化连接
     */
    public static void init() {
        Hashtable env = new Hashtable();

        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, ADMINUSERNAME);
        env.put(Context.SECURITY_CREDENTIALS, ADMINPASSWORD);
        try {
            dc = new InitialLdapContext(env,null);// 初始化上下文
            //logger.info("认证成功");
        } catch (javax.naming.AuthenticationException e) {
            /*logger.error("认证失败:"+e.getMessage());
            throw new LocaleBizServiceException("User.Ldap.AuthenticationException");*/
        } catch (Exception e) {
            /*logger.error("认证出错:"+e.getMessage());*/
        }
    }

    /**
     * 关闭Ldap连接
     */
    public static void close() {
        if (dc != null) {
            try {
                dc.close();
            } catch (NamingException e) {
                /*logger.error("Ldap服务关闭异常:"+e.getMessage());
                throw new LocaleBizServiceException("User.Ldap.closeException");*/
            }
        }
    }


    /**
     *查询ldat服务器获取所有用户数据
     */
    public static List<LdaptUserResult> searchInformation(String base,String scope) {

        SearchControls sc = new SearchControls();
        sc.setReturningAttributes(RETURN_USER_ATTRS);
        if (scope.equals("base")) {
            sc.setSearchScope(SearchControls.OBJECT_SCOPE);
        } else if (scope.equals("one")) {
            sc.setSearchScope(SearchControls.ONELEVEL_SCOPE);
        } else {
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
        }
        NamingEnumeration ne = null;
        LdaptUserResult ldaptUserResult = null;
        List<LdaptUserResult> list = new ArrayList<LdaptUserResult>();
        try {
            ne = dc.search(new LdapName(base), SEARCH_USER_FILTER, sc);

            // Use the NamingEnumeration object to cycle through
            // the result set.
            while (ne.hasMore()) {
                ldaptUserResult = new LdaptUserResult();
                SearchResult sr = (SearchResult) ne.next();

                String name = sr.getNameInNamespace();
                //System.out.println("=================name=======:"+name);

                ldaptUserResult.setPassword("123456");//默认密码
                ldaptUserResult.setUserType("portal");//用户类型
                ldaptUserResult.setFullName(name);
                ldaptUserResult.setSourceType("LDAP");
                if(nonNull(name)&&!name.isEmpty()){
                    String[] nameStr = name.split(",");
                    if(nonNull(nameStr[1])&&nameStr[1].contains("ou=")){
                        String dn = nameStr[1];
                        for(int i=2;i<nameStr.length;i++){
                            dn = dn+","+nameStr[i];
                        }
                        if(SEARCH_ORGANIZA_BASE.equals(dn)){//当前为根节点
                            ldaptUserResult.setRoleName("系统管理员");
                        }else{
                            ldaptUserResult.setRoleName("普通用户");
                        }
                        ldaptUserResult.setOrganizationId(dn);
                    }
                }else{
                    continue;
                }
                Attributes at = sr.getAttributes();
                NamingEnumeration ane = at.getAll();
                while (ane.hasMore()) {
                    Attribute attr = (Attribute) ane.next();
                    String attrType = attr.getID();
                    NamingEnumeration values = attr.getAll();

                    // Another NamingEnumeration object, this time
                    // to iterate through attribute values.
                    while (values.hasMore()) {
                        Object oneVal = values.nextElement();
                        //组装成对象
                        combinationUser(ldaptUserResult,attrType,oneVal);

                        //System.out.println(attrType+"=="+oneVal);
                    }
                }
                if(isNull(ldaptUserResult.getName())){
                    ldaptUserResult.setName(ldaptUserResult.getUsername());
                }
                list.add(ldaptUserResult);
            }
        } catch (Exception nex) {
            /*logger.error("查询ldpat用户数据错误:"+nex.getMessage());
            throw new LocaleBizServiceException("User.Ldap.QueryUserException");*/
        }

        return list;
    }

    /**
     * 查询组织机构层级
     * @param base
     * @param scope
     * @return
     */
    public static List<String> searchOrgBase(String base,String scope){
        List<String> baseList = new ArrayList<>();
        List<String> rootList = new ArrayList<>();
        rootList.add(base);
        searchForEach(rootList,scope,baseList);
        return baseList;
    }

    //递归遍历
    public static List<String> searchForEach(List<String> rootList,String scope,List<String> baseList){
        List<String> returnList = new ArrayList<>();
        if(rootList != null && rootList.size()>0){
            for(String base : rootList){
                try{
                    SearchControls sc = new SearchControls();
                    sc.setReturningAttributes(RETURN_ORGANIZED_ATTRS);
                    if (scope.equals("base")) {
                        sc.setSearchScope(SearchControls.OBJECT_SCOPE);
                    } else if (scope.equals("one")) {
                        sc.setSearchScope(SearchControls.ONELEVEL_SCOPE);
                    } else {
                        sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
                    }
                    NamingEnumeration ne = dc.search(new LdapName(base), SEARCH_ORGANIZA_FILTER, sc);
                    while (ne.hasMore()) {
                        SearchResult sr = (SearchResult) ne.next();
                        String name = sr.getNameInNamespace();
                        returnList.add(name);
                        baseList.add(name);

                        String uid = "";
                        Attributes at = sr.getAttributes();
                        NamingEnumeration ane = at.getAll();
                        while (ane.hasMore()) {
                            Attribute attr = (Attribute) ane.next();
                            String attrType = attr.getID();
                            NamingEnumeration values = attr.getAll();
                            while (values.hasMore()) {
                                Object oneVal = values.nextElement();

                                if(attrType.equals("entryUUID")){
                                    uid = (String) oneVal;
                                }
                            }
                        }
                        organizaDN_UID.put(name,uid);//name为组织的全路径
                    }
                }catch(Exception nex){
                   /* logger.error("查询ldpat组织机构层级关系错误:"+nex.getMessage());
                    throw new LocaleBizServiceException("User.Ldap.QueryOrganizaException");*/
                }
            }
        }else{
            return baseList;
        }
        return searchForEach(returnList,"one",baseList);
    }

    /**
     * 获取ldapt组织机构dn和uid对应关系
     * @return
     */
    public static Map<String,String> searchOrgDN_UID(){
        SearchControls sc = new SearchControls();
        sc.setReturningAttributes(RETURN_ORGANIZED_ATTRS);
        if(SEARCH_ORGANIZA_SCOPE.equals("one")) {
            sc.setSearchScope (SearchControls.ONELEVEL_SCOPE);
        }else if(SEARCH_ORGANIZA_SCOPE.equals("base")) {
            sc.setSearchScope(SearchControls.OBJECT_SCOPE);
        }else {
            sc.setSearchScope (SearchControls.SUBTREE_SCOPE);
        }
        NamingEnumeration ne = null;
        Map<String,String> map = new HashMap<>();
        try {
            ne = dc.search(new LdapName(SEARCH_ORGANIZA_BASE), SEARCH_ORGANIZA_FILTER, sc);
            while (ne.hasMore()) {
                SearchResult sr = (SearchResult) ne.next();
                String name = sr.getNameInNamespace();

                String uid = "";
                Attributes at = sr.getAttributes();
                NamingEnumeration ane = at.getAll();
                while (ane.hasMore()) {
                    Attribute attr = (Attribute) ane.next();
                    String attrType = attr.getID();
                    NamingEnumeration values = attr.getAll();
                    while (values.hasMore()) {
                        Object oneVal = values.nextElement();

                        if(attrType.equals("entryUUID")){
                            uid = (String) oneVal;
                        }
                    }
                }
                map.put(name,uid);//name为组织的全路径
            }
        } catch (Exception nex) {
            nex.printStackTrace();
            /*logger.error("查询ldpat组织机构dn和uid对应关系错误:"+nex.getMessage());
            throw new LocaleBizServiceException("USER.Ldap.SyncOrg.Dn.Uid.Exception");*/
        }

        return map;
    }

    /**
     * 获取ldapt组织机构信息
     * @return
     */
    public static Map<String,String[]> searchOrganization(String base,String scope){
        SearchControls sc = new SearchControls();
        sc.setReturningAttributes(RETURN_ORGANIZED_ATTRS);
        if(scope.equals("one")) {
            sc.setSearchScope (SearchControls.ONELEVEL_SCOPE);
        }else if(scope.equals("base")) {
            sc.setSearchScope(SearchControls.OBJECT_SCOPE);
        }else {
            sc.setSearchScope (SearchControls.SUBTREE_SCOPE);
        }
        NamingEnumeration ne = null;
        Map<String,String[]> map = new HashMap<>();
        try {
            ne = dc.search(new LdapName(base), SEARCH_ORGANIZA_FILTER, sc);

            while (ne.hasMore()) {
                SearchResult sr = (SearchResult) ne.next();
                String name = sr.getNameInNamespace();

                String ou = "";
                String organizaName="";
                String uid = "";
                Attributes at = sr.getAttributes();
                NamingEnumeration ane = at.getAll();
                while (ane.hasMore()) {
                    Attribute attr = (Attribute) ane.next();
                    String attrType = attr.getID();
                    NamingEnumeration values = attr.getAll();
                    while (values.hasMore()) {
                        Object oneVal = values.nextElement();

                        if(attrType.equals("ou")){
                            ou = (String) oneVal;
                        }
                        if(attrType.equals("description")){
                            organizaName = (String) oneVal;
                        }
                        if(attrType.equals("entryUUID")){
                            uid = (String) oneVal;
                        }
                    }
                }
                if(organizaName.isEmpty()){
                    organizaName = ou;
                }
                //获取用户目录数组
                if(nonNull(name)&&!name.isEmpty()){
                    String[] orgOuRelationArr = getOrgOuRelation(name,root);
                    map.put(uid,orgOuRelationArr);
                }

            }
        } catch (Exception nex) {
            /*logger.error("查询ldpat组织机构数据错误:"+nex.getMessage());
            throw new LocaleBizServiceException("User.Ldap.QueryOrganizaException");*/
        }
        return map;
    }

    /**
     * 组装当前组织的上层级关系
     * @param name
     * @param root
     * @return
     */
    private static String[] getOrgOuRelation(String name, String root) {
        name = name.lastIndexOf(root) != -1 ? name.substring(0,name.lastIndexOf(root)) : name;
        String[] tempArr = null;
        tempArr = name.split(",");
        String[] orgOuRelationArr = new String[tempArr.length];
        for(int i=0;i<(tempArr.length);i++){
            String ou = null;
            String temp = null;
            for(int j=i;j<(tempArr.length);j++){
                temp = isNull(temp) ? "" : (temp+",");
                temp = temp+tempArr[j];
            }
            ou = isNull(temp) ? null : temp + ","+root;
            orgOuRelationArr[i] = ou;
        }
        return orgOuRelationArr;
    }

    private static void combinationUser(LdaptUserResult ldaptUserResult, String attrType,Object oneVal) {
        if(nonNull(oneVal)){
            switch (attrType){
                case "displayName":
                    ldaptUserResult.setName((String) oneVal);
                    break;
                case "uid":
                    ldaptUserResult.setUsername((String) oneVal);
                    break;
                case "entryUUID":
                    ldaptUserResult.setUid((String)oneVal);//唯一作为主键
                    break;
                case "mail":
                    ldaptUserResult.setEmail((String) oneVal);
                    break;
                default:
            }
        }
    }


    public static void main(String[] args) {
        LdapUtils.init();
        List<String> list = LdapUtils.searchOrgBase(SEARCH_ORGANIZA_BASE,"base");
        System.out.println(list);
        System.out.println(organizaDN_UID);
        //Map<String,String[]> list = LdapUtils.searchOrganization();
        LdapUtils.close();

        //System.out.println(list);
        //System.out.println(ldap.checkLdapUser("uid=chencl,ou=SH-Kaifa,ou=Kaifa,ou=ZHUYUN,dc=jiagouyun,dc=com", "*********"));;
    }
}
