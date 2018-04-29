package com.stu.cloneDo;

public class CloneClass implements Cloneable{

    public int aInt;
    public Object clone(){
        CloneClass o = null;
        try{
            o = (CloneClass) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        return 0;
    }
}
