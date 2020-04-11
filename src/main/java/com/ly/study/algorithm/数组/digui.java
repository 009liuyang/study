package com.ly.study.algorithm.数组;

/**
 * @describe 理解递归 递进和回归
 * @author yang.liu
 * @date 2020-04-10
 */
public class digui {

    public static void main(String[] args) {
        recursion_display(5);
    }

    public static void recursion_display(int n) {
        int temp=n;//保证前后打印的值一样
        System.out.println("递进:" + temp);
        if (n > 0) {
            recursion_display(--n);
        }
        System.out.println("回归:" + temp);
    }
}
