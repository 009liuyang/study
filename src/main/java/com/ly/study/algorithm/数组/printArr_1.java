package com.ly.study.algorithm.数组;

/**
 * @describe 顺时针打印一个矩阵
 * @author yang.liu
 * @date 2020-04-10
 */
public class printArr_1 {

    public static void main(String[] args){
        int[][] num = new int[4][4];
        int n = 4;
        int count =1;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = count++;
            }
        }
        output(num,0,n-1);
    }

    /**
     * 1   2  3   4
     * 5   6  7   8
     * 9  10 11  12
     * 13 14 15  16
     *
     *
     * @param num
     * @param start
     * @param end
     */
    public static void output(int[][] num,int start,int end){
        if(start>=end || end<=0){
            return;
        }

        for(int i=start;i<=end;i++){
            System.out.println(num[start][i]);
        }

        for(int i=start+1;i<=end;i++){
            System.out.println(num[i][end]);
        }

        for(int i=end-1;i>=start;i--){
            System.out.println(num[end][i]);
        }

        for(int i=end-1;i>start;i--){
            System.out.println(num[i][start]);
        }

        output(num,start+1,end-1);
    }

}
