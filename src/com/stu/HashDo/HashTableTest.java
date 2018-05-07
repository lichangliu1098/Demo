package com.stu.HashDo;

import java.util.*;

public class HashTableTest {
    public static void main(String[] args){
        Hashtable<String,Integer> table = new Hashtable<String,Integer>();

        table.put("zhangsan",22);
        table.put("lisi",33);
        table.put("wangwu",44);

        System.out.println(table.toString());

        Iterator<Map.Entry<String,Integer>> iter = table.entrySet().iterator();

        HashSet<String> set = new HashSet<String>();
        set.add("语文");
        set.add("数学");
        set.add("英语");
        set.add("历史");
        set.add("政治");
        set.add("地理");
        set.add("生物");
        set.add("化学");

        HashMap map;
    }
}
