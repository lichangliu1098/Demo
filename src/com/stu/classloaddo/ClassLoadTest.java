package com.stu.classloaddo;

public class ClassLoadTest {

    public static void main(String[] args){
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        System.out.println(System.getProperty("java.class.path"));
        String info="liguo";
        System.out.println(info.toString());
        System.out.println(info.getClass().getClassLoader());
    }
}
