package com.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Execute {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
            executorService.submit((Runnable) () -> {
                for(int j=1;j<10000;j++) {
                    System.out.println("======TheardName====" + Thread.currentThread().getName() + "=======" + j);
                }
            });
    }
}
