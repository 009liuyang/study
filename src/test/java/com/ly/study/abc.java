package com.ly.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class abc {


    static void method1(){
        List<String> a = new ArrayList<>();
        a.add("abc");
        a.add("def");
        List<Short> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        method2(a, "a");
        method2(b, "b");
    }

    static void method2(Object list, String type){
        // 这里怎么判断list是 a、b、c哪个类型
        if(type.equals("a")){
            List<String> a = (List<String>)list;
            System.out.println(a.toString());
        }
    }

    public static void main(String[] args) {
        method1();
    }


}
