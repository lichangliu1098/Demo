package com.lichangliu;

import java.lang.reflect.Method;

public class Client {

   public void MethodA(String str,Integer...is){
       for(int s : is){
           System.out.println("is======"+s);
       }
    }

    public void MethodA(String str,String...strs){
        for (String s : strs){
            System.out.println("overload========"+s);
        }
    }

    public static void main(String[] args) {
       Client client = new Client();
        client.MethodA("china", 0);
        client.MethodA("china","people");
        //client.MethodA("china",null);
    }
}
