package com.ly.study.algorithm.排序;


/**
 * @description :冒泡排序
 * @Author : ly
 * @Date : 2019-11-05 17:18
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3,4,1,7,5,9,2};

        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if(arr[j+1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

       for(int x : arr){
           System.out.println(x);
       }

    }
}
