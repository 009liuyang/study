package com.ly.study.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc
 * @Author liuyang
 * @Date 2020-04-11 10:11
 **/
public class num_1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = new num_1().twoSum(nums, target);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 暴力遍历法
     * 复杂度 O(n2)
     */
//    public int[] twoSum(int[] nums, int target) {
//
//        for (int i=0; i<nums.length; i++){
//            for (int j=1; j<nums.length; j++){
//                if((nums[i] + nums[j]) == target){
//                    return new int[]{nums[i],nums[j]};Å
//                }
//            }
//        }
//        return null;
//    }



    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }
        return null;
    }

}
