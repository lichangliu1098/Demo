package com.stu.ArrSort;

public class erfenClass {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,9,90};
        //System.out.println(erfen(nums,90,0,nums.length));
        //System.out.println(guessNumber(1));
        System.out.println(guess2(nums,100));
    }

    public static int erfen(int[] nums,int m,int left,int right){
        int mid = (left+right)/2;
        if(m< nums[left] || m > nums[right-1] || nums[left] > nums[right-1]){
            return -1;
        }
        int midValue = nums[mid];
        if(midValue == m){
            return mid;
        }else if(midValue > m){
            return erfen(nums, m, left,mid);
        }else{
            return erfen(nums, m, midValue, nums.length);
        }
    }

    public static int guessNumber(int n){
        int i=1,j=n,mid =0;
        while(i<=j){
            mid = (j-i)/2+i;
            int val = guessNumber(mid);
            if(val == -1){
                j = mid -1;
            }else if(val == 1){
                i = mid +1;
            } else{
                return mid;
            }
        }

        return -1;
    }

    public static int guess2(int[] arr,int targer){
        int start = 0,end = arr.length,mid = (arr.length)/2;
        while(start < mid && end > mid){
            if(arr[mid] > targer){
                end = mid;
            }else if(arr[mid] < targer){
                start = mid;
            }else{
                return mid;
            }
            mid = (start + end)/2;
        }
        return -1;
    }
}
