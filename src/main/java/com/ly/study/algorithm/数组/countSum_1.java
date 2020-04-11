package com.ly.study.algorithm.数组;

/**
 * @describe 给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组
 * @author yang.liu
 * @date 2020-04-09
 */
public class countSum_1 {

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6,7,8,9};
        int k = 7;

        for(int i=0; i<ints.length; i++){
            int curSum = 0;

            int m = i;
            int count = 0;
            while (curSum < k){
                curSum = curSum + ints[m++];
                count ++;
            }

            if(curSum == k){
                for (int j=0; j<=count; j++){
                    System.out.println(ints[i+j]);
                }
            }

        }
    }
}
