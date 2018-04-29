package com.stu.cloneDo;

public class CloneC implements Cloneable{
    public String str;
    public StringBuffer strBuff;
    public Object clone(){
        CloneC o = null;
        try {
            o = (CloneC) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return o;
    }
}

class StrClone{
    public static void main(String[] args) {
        CloneC c1 = new CloneC();
        c1.str = new String("initializeStr");
        c1.strBuff = new StringBuffer("initializeStrBuff");
        System.out.println("before clone,c1.str="+c1.str);
        System.out.println("before clone,c1.strBuff="+c1.strBuff);

        CloneC c2 = (CloneC)c1.clone();
        c2.str.substring(0,5);
        c2.strBuff.append("change strBuff clone");
        System.out.println("=================");
        System.out.println("after clone,c2.str="+c2.str);
        System.out.println("after clone,c2.strBuff="+c2.strBuff);
    }
}
