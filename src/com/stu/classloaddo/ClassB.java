package com.stu.classloaddo;

public class ClassB extends Object{
    static{
        System.out.println("Load B static");
    }

    {
        System.out.println("Load B");
    }

    public ClassB(){
        System.out.println("Create B");
    }
}
