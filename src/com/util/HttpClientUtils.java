/*
package com.util;

import com.google.gson.Gson;
import com.stu.EpassUserInfo;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {
    private static CloseableHttpClient httpClient;

    private static String url = null;
    private static String tokenUrl = null;
    private static String verifyTokenUrl = null;
    private static String getUserUrl = null;
    private static String client_id_value = null;
    private static String client_secret_value = null;
    private static String redirect_uri_value = null;
    private static String client_id = "client_id";
    private static String client_secret = "client_secret";
    private static String redirect_uri = "redirect_uri";
    private static String grant_type = "grant_type";
    private static String header_host = null;

    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static SSLContextBuilder builder = null;

    //初始化参数
    public static void init(){
        //测试使用
        url = "https://202.175.27.221";
        header_host = "202.175.27.221";
        client_id_value = "oJYX0iHDR8mDnajbR9r13QhBLs2zUSAd533SUXnc";
        client_secret_value ="lkGqNT2yDeF5jozpf85pahMJHD8ad8i7xQIkLe1BKpahiuQFt0xivLjzEEVegte8FWd5YoBNfSJNuokSbSTO3tcOt9VxdMDaWhouPc7EItHbLwAE3h3eHCdieNEukABU";
        redirect_uri_value ="";

       */
/* url = Configs.getString("epass.url");
        header_host = Configs.getString("epass.host");
        client_id_value = Configs.getString("epass.client_id");;
        client_secret_value = Configs.getString("epass.client_secret");
        redirect_uri_value = Configs.getString("epass.redirect_uri");*//*


        tokenUrl = url+"/o/token/";
        verifyTokenUrl = url+"/o/token-info/";
        getUserUrl = url+"/o/profile/";



        try {
            builder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .register(HTTPS, sslsf)
                    .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(200);//max connection

            httpClient = HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    .setConnectionManager(cm)
                    .setConnectionManagerShared(true)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            //sysLogger.error("HttpClientUtils.init error message=========="+e.getMessage());
        }
    }

    */
/**
     * 模拟请求
     *
     * @param url        资源地址
     * @param encoding    编码
     * @return
     * @throws ParseException
     * @throws IOException
     *//*

    public static String get(String url,Map<String,String> headersMap,String encoding) throws ParseException, IOException{
        String body = "";

         //socks代理地址
        InetSocketAddress socksaddr = new InetSocketAddress("127.0.0.1", 1081);
        HttpClientContext context = HttpClientContext.create();
        context.setAttribute("socks.address", socksaddr);

        if(encoding ==null || encoding.equals("")){
            encoding = "utf-8";
        }

        //创建post方式请求对象
        HttpGet httpGet = new HttpGet(url);
        //装填参数
        //sysLogger.debug("get url："+url);

        //设置header信息
        //指定报文头【Content-type】,【User-Agent】
        httpGet.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        if(headersMap !=null){
            for(String key : headersMap.keySet()){
                httpGet.setHeader(key, headersMap.get(key));
            }
        }

        //执行请求操作，并拿到结果（同步阻塞）
        //CloseableHttpResponse response = httpClient.execute(httpGet);

        //socket代理执行
        CloseableHttpResponse response = httpClient.execute(httpGet,context);

        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;
    }


    */
/**
     * 模拟请求
     *
     * @param url        资源地址
     * @param map    参数列表
     * @return
     * @throws ParseException
     * @throws IOException
     *//*

    public static String post(String url, Map<String,String> map,Map<String,String> headersMap, String encoding) throws ParseException, IOException{

        String body = "";
        // socks代理地址
        */
/*InetSocketAddress socksaddr = new InetSocketAddress("127.0.0.1", 1234);
        HttpClientContext context = HttpClientContext.create();
        context.setAttribute("socks.address", socksaddr);*//*


        if(encoding ==null || encoding.equals("")){
            encoding = "utf-8";
        }

        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(map!=null){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));
        //sysLogger.debug("post url："+url);
        //sysLogger.debug("post params："+nvps.toString());
        //设置header信息
        //指定报文头【Content-type】,【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        if(headersMap !=null){
            for(String key : headersMap.keySet()){
                httpPost.setHeader(key, headersMap.get(key));
            }
        }

        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = httpClient.execute(httpPost);

        //socket代理执行
        //CloseableHttpResponse response = httpClient.execute(httpPost,context);

        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;
    }

    */
/**
     * 根据code获取epass Token
     * @param code
     * @return
     *//*

    public static EpassTokenResult getEpassTokenByCode(String code){
        EpassTokenResult epassTokenResult = null;
        Map<String,String> paramsMap = new HashMap<String,String>();
        Map<String,String> headersMap = new HashMap<String,String>();
        try {
            paramsMap.put(client_id,client_id_value);
            paramsMap.put(client_secret,client_secret_value);
            paramsMap.put(grant_type,"authorization_code");
            paramsMap.put("code",code);
            paramsMap.put(redirect_uri,redirect_uri_value);

            headersMap.put("Host",header_host);

            String body = post(tokenUrl,paramsMap,headersMap,null);
            //sysLogger.debug("HttpClientUtils.getEpassTokenByCode body is============="+body);

            epassTokenResult = new Gson().fromJson(body,EpassTokenResult.class);
        } catch (IOException e) {
            //sysLogger.error("HttpClientUtils.getEpassTokenByCode error message==========="+e.getMessage());
        }
        return epassTokenResult;
    }

    */
/**
     * 根据token获取epass用户信息
     * @param token
     * @return
     *//*

    public static EpassUserInfo getEPassUserInfo(String token){
        EpassUserInfo epassUserInfo = null;
        Map<String,String> headersMap = new HashMap<String,String>();
        try {
            headersMap.put("Authorization","bearer "+token);
            headersMap.put("Host",header_host);

            String body = get(getUserUrl,headersMap,null);
            //sysLogger.debug("HttpClientUtils.getUserInfo body is============="+body);

            epassUserInfo = new Gson().fromJson(body,EpassUserInfo.class);
        } catch (IOException e) {
            //sysLogger.error("HttpClientUtils.getUserInfo error message==========="+e.getMessage());
        }
        return epassUserInfo;
    }

    public static void main(String[] args) {
        //init();
        //getEpassTokenByCode("LNm8K0D6l31DTmO9zNSJyrQyXWL0dP");
        //getEPassUserInfo("db3TW4AU4Ey8WyuWFjs4f1qxZcGzys");
        //String url = "http://133.160.93.56:20200/aopoauth/oauth/authorize?app_id=501563&response_type=code&redirect_uri=http://www.baidu.com";
        String url = "https://172.17.17.254:20110/aopoauth/oauth/authorize?app_id=501563&response_type=code&redirect_uri=http://www.baidu.com";
        try {
            init();
            get(url,null,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
