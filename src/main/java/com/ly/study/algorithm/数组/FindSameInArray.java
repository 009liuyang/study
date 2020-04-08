package com.ly.study.algorithm.数组;

/**
 * 求两个数组的交集
 *
 * @author yang.liu
 * @date 2020-03-25
 */
public class FindSameInArray {

    public static void main(String[] args) {
        int[] a = {2,3,5,7,10,13};
        int[] b = {1,3,8,13,15};
        int[] c = new int[a.length + b.length];

        int i=0, j=0, k=0;
        while (i<a.length && j<b.length){
            if(a[i] > b[j]){
                j++;
            }else if(a[i] < b[j]){
                i++;
            }else {
                c[k++] = a[i];
                i++;
                j++;
            }
        }

        for (int l = 0; l <c.length ; l++) {
            System.out.println(c[l]);
        }
    }

}
