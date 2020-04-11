package com.ly.study.algorithm.数组.递归;

/**
 * @author yang.liu
 * @describe
 * @date 2020-04-10
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().reverseWords("the sky is bule");
        System.out.println(result);
    }

    private static String result = "";

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        reverse(arr, 0);
        return result.substring(0, result.length()-1);
    }

    public void reverse (String[] arr, int index){
        if(index >= arr.length){
            return;
        }
        reverse(arr, index + 1);
        result = result + arr[index] + " ";
    }
}
