package com.stu.HashDo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashTableTest {
    public static void main(String[] args){

        //hashMapTest();

        hashTableTest();

        concurrentHashMapTest();

        //printlnHash();

    }

    private static void concurrentHashMapTest() {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        concurrentHashMap.put("1","1k");

        concurrentHashMap.put("2","2k");

        concurrentHashMap.put("3","3k");


    }

    private static void hashTableTest() {

        Hashtable<String,String> hashtable = new Hashtable<>();

        hashtable.put("1","1k");

        hashtable.put("2","2k");

        hashtable.put("3","3k");


    }

    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void hashMapTest(){
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
        hashMap.put("19","19k");
        System.out.println("=====19=="+(15 & hash("19")));
        hashMap.put("70","70k");
        System.out.println("=====70=="+(15 & hash("70")));
        hashMap.put("80","80k");
        System.out.println("=====80=="+(15 & hash("80")));
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

        System.out.println("=====17=="+(15 & hash("17")));
        System.out.println("=====18=="+(15 & hash("18")));
        System.out.println("=====19=="+(15 & hash("19")));
        System.out.println("=====23=="+(15 & hash("21")));
        System.out.println("=====24=="+(15 & hash("22")));
        System.out.println("=====25=="+(15 & hash("25")));
        System.out.println("=====26=="+(15 & hash("26")));
        System.out.println("=====27=="+(15 & hash("27")));
        System.out.println("=====28=="+(15 & hash("28")));
        System.out.println("=====29=="+(15 & hash("29")));
        System.out.println("=====30=="+(15 & hash("30")));
        System.out.println("=====40=="+(15 & hash("31")));
        System.out.println("=====50=="+(15 & hash("32")));
        System.out.println("=====60=="+(15 & hash("33")));
    }
}
