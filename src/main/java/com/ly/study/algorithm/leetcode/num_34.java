package com.ly.study.algorithm.leetcode;

/**
 * @author yang.liu
 * @describe
 * @date 2020-04-14
 */
public class num_34 {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(result);
    }

    public static int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length;

        int[] result = new int[10];
        int k = 0;

        while (start < end){
            int middle = (start + end) / 2;
            if(target > nums[middle]){
                start = middle + 1;
            }else if(target < nums[middle]){
                end = middle - 1;
            }else {
                result[k++] = middle;
            }
        }

        return result;
    }
}
