package com.ly.study.reflect;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        List list2 = list.subList(0,1);

        System.out.println(0x61c88647);


        A  a1 = new A("a");
        A a2 = new A("b");
        A a3 = new A("c");
        System.out.println(1);
    }


    static class A {

        public A(String a){
            arrb = new B[10];
            arrb[1] = new B(a);
        }

        static class B{
            String s ;
            public B(String a){
                s = a;
            }
        }

        B[] arrb;

    }


}
