package com.stu.classloaddo;

public class classA extends ClassB {
    static{
        System.out.println("Load A static");
    }

    {
        System.out.println("Load A");
    }

    public classA(){
        System.out.println("Create A");
    }
}
