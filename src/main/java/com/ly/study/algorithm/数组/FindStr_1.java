package com.ly.study.algorithm.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @describe 找出数组中重复出现字符的次数
 * @author yang.liu
 * @date 2020-04-09
 */
public class FindStr_1 {

    public static void main(String[] args) {
        String s = "abcbcaad";
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<chars.length;i++){
            if(map.get(chars[i]) != null){
                map.put(chars[i],map.get(chars[i]) + 1);
            }else {
                map.put(chars[i],1);
            }
        }

        for (Map.Entry<Character,Integer> x : map.entrySet()){
            System.out.println(x.getKey() + "-->" + x.getValue());
        }
    }
}
