package com.stu.ArrSort;

import java.util.Arrays;

/**
 * 升序数组
 */
public class mergeArr {

    public static void main(String[] args){
        int[] a={2,6,7,8}; int[] b={4,6,66,77,88,99,444,666,777,999};
        int[] c = uninArray(a,b);
        System.out.println(Arrays.toString(c));
    }

    public static int[] uninArray(int[] a,int[] b){
        int left =0,mid=0,third=0;
        int[] tmpArr = new int[a.length+b.length];
        while(left<a.length && mid<b.length){
            if(a[left]<=b[mid]){
                tmpArr[third++] = a[left++];
            }else{
                tmpArr[third++] = b[mid++];
            }
        }

        while(mid<b.length){
            tmpArr[third++] = b[mid++];
        }
        while(left <a.length){
            tmpArr[third++] = a[left++];
        }

        return tmpArr;
    }
}
