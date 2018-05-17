package com.stu.ArrSort;

/**
 * 找出数组中第一个元素重复的元素
 */
public class ArrSortClass {

    public static int[] arr = {1,3,4,5,1};

    public static int find_a_duplication(int[] a,int n){
        for(int i=0;i<n;i++)
        {
            while(a[i] != i+1){
                if(a[a[i]-1] == a[i]){
                    return a[i];
                }
                int temp = a[a[i]-1];
                a[a[i]-1] = a[i];
                a[i] = temp;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println(find_a_duplication(arr,arr.length));
    }
}
