package com.ly.study.algorithm.数组.排列组合;

import java.util.Stack;

/**
 * @author yang.liu
 * @describe
 * @date 2020-04-10
 */
public class UserStack {

    public static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        int shu[] = {1,2,3};
        f(shu,3,0);
    }

    /**
     *
     * @param shu   待选择的数组
     * @param targ  要选择多少个次
     * @param cur   当前选择的是第几次
     */
    private static void f(int[] shu, int targ, int cur) {
        if(cur == targ) {
            System.out.println(stack);
            return;
        }

        for(int i=0; i<shu.length; i++) {

            System.out.println("递归前");
            stack.add(shu[i]);

            f(shu, targ, cur+1);

            stack.pop();
            System.out.println("递归后");

        }
    }

}
