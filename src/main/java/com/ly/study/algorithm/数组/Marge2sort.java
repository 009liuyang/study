package com.ly.study.algorithm.数组;

/**
 * @describe 合并两个有序数组
 *
 * @author yang.liu
 * @date 2020-04-08
 */
public class Marge2sort {

    public static void marge(int[] a, int[] b, int[] c){

        int i = 0;
        int j = 0;
        int k = 0;

        while (i<a.length && j<b.length){
            if(a[i] > b[j]){
                c[k++] = b[j];
                j++;
            }else{
                c[k++] = a[i];
                i++;
            }
        }

        while (i < a.length){
            c[k++] = a[i++];
        }

        while (j < b.length){
            c[k++] = b[i++];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9};
        int[] b = {2,4,5,8};
        int[] c = new int[a.length + b.length];
        marge(a, b, c);
        for (int i = 0; i <c.length ; i++) {
            System.out.println(c[i]);
        }
    }
}
