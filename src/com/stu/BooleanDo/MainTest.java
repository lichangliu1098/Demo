package com.stu.BooleanDo;

import static com.sun.tools.doclint.Entity.and;
import static com.sun.tools.doclint.Entity.or;

public class MainTest {

    public static void main(String[] args) {

        /*boolean flag1 = false ||  true && true;
        boolean flag2 = false ||  true && false;
        boolean flag7 = false ||  false && false;
        boolean flag8 = false ||  false && true;

        System.out.println("======="+flag1+"==="+flag2+"==="+flag7+"==="+flag8);

        boolean flag3 = true ||  true && true;
        boolean flag4 = true ||  true && false;
        boolean flag5 = true ||  false && false;
        boolean flag6 = true ||  false && true;

        System.out.println("======="+flag3+"==="+flag4+"==="+flag5+"==="+flag6);*/

        /*boolean flag2 = false ||  trueS() && falseS();
        boolean flag7 = false ||  falseS() && trueS();
        boolean flag8 = false ||  trueS() && trueS();
        boolean flag9 = false ||  falseS() && falseS();*/
        //boolean flag8 = false ||  falseS() && trueS();

        boolean flag1 = true ||  trueS() && falseS();
        boolean flag3 = true ||  falseS() && trueS();
        boolean flag4 = true ||  trueS() && trueS();
        boolean flag5 = true ||  falseS() && falseS();


    }


    public static boolean trueS(){
        System.out.println("======true===");

        return true;
    }

    public static boolean falseS(){
        System.out.println("======false===");
        return true;
    }
}
