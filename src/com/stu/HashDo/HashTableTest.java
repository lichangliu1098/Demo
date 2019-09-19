package com.stu.HashDo;

import java.util.*;

public class HashTableTest {
    public static void main(String[] args){
        /*Hashtable<String,Integer> table = new Hashtable<String,Integer>();

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
        set.add("化学");*/

        HashMap<String,String> hashMap = new HashMap();

        hashMap.put("0","0k");
        System.out.println("=====0=="+(15 & hash("0")));
        hashMap.put("1","1k");
        System.out.println("=====1=="+(15 & hash("1")));
        hashMap.put("2","2k");
        System.out.println("=====2=="+(15 & hash("2")));
        hashMap.put("3","3k");
        System.out.println("=====3=="+(15 & hash("3")));
        hashMap.put("4","4k");
        System.out.println("=====4=="+(15 & hash("4")));
        hashMap.put("5","5k");
        System.out.println("=====5=="+(15 & hash("5")));
        hashMap.put("6","6k");
        System.out.println("=====6=="+(15 & hash("6")));
        hashMap.put("7","7k");
        System.out.println("=====7=="+(15 & hash("7")));
        hashMap.put("8","8k");
        System.out.println("=====8=="+(15 & hash("8")));
        hashMap.put("9","9k");
        System.out.println("=====9=="+(15 & hash("9")));
        hashMap.put("10","10k");
        System.out.println("=====10=="+(15 & hash("10")));
        hashMap.put("20","20k");
        System.out.println("=====20=="+(15 & hash("20")));
        hashMap.put("30","30k");
        System.out.println("=====30=="+(15 & hash("30")));
        hashMap.put("40","40k");
        System.out.println("=====40=="+(15 & hash("40")));
        hashMap.put("50","50k");
        System.out.println("=====50=="+(15 & hash("50")));
        hashMap.put("60","60k");
        System.out.println("=====60=="+(15 & hash("60")));
        hashMap.put("70","70k");
        System.out.println("=====70=="+(15 & hash("70")));
        hashMap.put("80","80k");
        System.out.println("=====80=="+(15 & hash("80")));

        /*System.out.println("=================================================");

        hashMap.put("11","11k");
        System.out.println("=====11=="+(15 & hash("11")));
        hashMap.put("12","12k");
        System.out.println("=====12=="+(15 & hash("12")));
        hashMap.put("13","13k");
        System.out.println("=====13=="+(15 & hash("13")));

        System.out.println("=================================================");

        hashMap.put("22","11k");
        System.out.println("=====22=="+(15 & hash("22")));
        hashMap.put("23","12k");
        System.out.println("=====23=="+(15 & hash("23")));
        hashMap.put("24","13k");
        System.out.println("=====24=="+(15 & hash("24")));

        hashMap.put("14","14k");
        System.out.println("=====14=="+(15 & hash("14")));
        hashMap.put("15","15k");
        System.out.println("=====15=="+(15 & hash("15")));*/

        //printlnHash();

    }

    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void printlnHash(){
        System.out.println("=====0=="+(15 & hash("0")));
        System.out.println("=====1=="+(15 & hash("1")));
        System.out.println("=====2=="+(15 & hash("2")));
        System.out.println("=====3=="+(15 & hash("3")));
        System.out.println("=====4=="+(15 & hash("4")));
        System.out.println("=====5=="+(15 & hash("5")));
        System.out.println("=====6=="+(15 & hash("6")));
        System.out.println("=====7=="+(15 & hash("7")));
        System.out.println("=====8=="+(15 & hash("8")));
        System.out.println("=====9=="+(15 & hash("9")));
        System.out.println("=====10=="+(15 & hash("10")));

        System.out.println("=====20=="+(15 & hash("20")));
        System.out.println("=====21=="+(15 & hash("21")));
        System.out.println("=====22=="+(15 & hash("22")));
        System.out.println("=====23=="+(15 & hash("23")));
        System.out.println("=====24=="+(15 & hash("24")));
        System.out.println("=====25=="+(15 & hash("25")));
        System.out.println("=====26=="+(15 & hash("26")));
        System.out.println("=====27=="+(15 & hash("27")));
        System.out.println("=====28=="+(15 & hash("28")));
        System.out.println("=====29=="+(15 & hash("29")));
        System.out.println("=====30=="+(15 & hash("30")));
        System.out.println("=====40=="+(15 & hash("40")));
        System.out.println("=====50=="+(15 & hash("50")));
        System.out.println("=====60=="+(15 & hash("60")));
    }
}
