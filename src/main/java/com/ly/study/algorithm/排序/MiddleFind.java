package com.ly.study.algorithm.排序;

/**
 * @describe二分查找
 *
 * @author yang.liu
 * @date 2020-04-08
 */
public class MiddleFind {

    public static int middleFind(int[] arr, int k){

        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        while (low < high){
            middle = (low + high) / 2;
            if(k > arr[middle]){
                low = middle + 1;
            }else if(k < arr[middle]){
                high = middle + 1;
            }else {
                return arr[middle];
            }
        }
        return -1;
    }

}
