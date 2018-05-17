package com.stu;

import com.stu.singleton.LazySingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
       List<String> removeList = list.stream().filter(l->"3".equals(l)).collect(Collectors.toList());
        System.out.println(removeList.toString());
        list.removeAll(removeList);

        assert function(9) == 0 :"error";
        System.out.println(function(9));


    }

    public static int function(int n){
        if(n==1||n==2)return 1;
        return function(n-1)+function(n-2);
    }


}
