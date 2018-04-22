package com.stu.singleton;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton(){
      System.out.println("单例被执行==========");
    };

    public static LazySingleton getInstance(){
        if(instance == null){
            synchronized(LazySingleton.class){
                if(instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
