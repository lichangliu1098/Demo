package com.stu.stringDemo;

public class StringTest {

    private volatile  String volatileLock;

    public static void main(String[] args) {

        String a = null;

        synchronized ("bb"){
            a  = "cc";
        }
    }
}
