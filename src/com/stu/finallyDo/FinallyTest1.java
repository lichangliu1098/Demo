package com.stu.finallyDo;

public class FinallyTest1 {

    public static void main(String[] args) {
        
        System.out.println(test1());
    }

    public static int test1() {
        int b = 20;

        try {
            System.out.println("try block");
            b++;
            return b++;
        }
        catch (Exception e) {
            System.out.println("catch block");
        }
        finally {
            System.out.println("finally block="+b);
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
        }
        return b;
    }
    
}