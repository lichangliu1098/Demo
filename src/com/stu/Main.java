package com.stu;

import com.stu.singleton.LazySingleton;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //System.out.println("当前线程是="+Thread.currentThread().getName());
                LazySingleton lazySingleton = LazySingleton.getInstance();
            }
        };

        for(int i=0;i<100000;i++){
            new Thread(runnable,"线程"+i).start();
        }

        ArrayList<String> a = new ArrayList<String>();
    }


}
