package com.ly.study.function;

import java.util.function.Supplier;

public class _a {

    public static void main(String[] args) {


        if(true){

            //System.out.println(2);
            //System.out.println(3);
            print(() -> {
                System.out.println(1);
                return null;
            });
        }else {
            //System.out.println(2);
            //System.out.println(3);
            System.out.println(4);
        }
    }


    public static void print(Supplier supplier){
        supplier.get();
        System.out.println(2);
        System.out.println(3);
    }
}
