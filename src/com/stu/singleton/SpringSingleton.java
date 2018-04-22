package com.stu.singleton;

public class SpringSingleton {
   public SpringSingleton(){
       System.out.println("单例被执行==========");
   };

   private static class LazySingletonHolder{
       static SpringSingleton instance = new SpringSingleton();
    };

   public static SpringSingleton getInstance(){
     return LazySingletonHolder.instance;
   };
}
