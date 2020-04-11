package com.ly.study.algorithm.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @describe 找出数组中 中文、英文、数字出现的次数
 * @author yang.liu
 * @date 2020-04-09
 */
public class FindStr_2 {

    public static void main(String[] args) {
        String arr = "sfca留s啊3a";
        char[] chars = arr.toCharArray();
        Map<String,Integer> map = new HashMap<>();
        map.put("中文",0);
        map.put("英文",0);
        map.put("数字",0);
        for (int i=0;i<chars.length;i++){
            if((int)chars[i] > 47 && (int)chars[i] < 59){
                System.out.println(chars[i]);
            }
        }
    }
}
