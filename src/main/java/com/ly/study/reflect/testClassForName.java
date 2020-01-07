package com.ly.study.reflect;

public class testClassForName {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        // 加载类A
        Class c = Class.forName("com.ly.study.reflect.A");
        // 初始化类A 返回类A的实例
        c.newInstance();

    }
}

class A{

    public A(){
        System.out.println("默认构造方法执行");
    }

    public A(String name){
        System.out.println("name");
    }

    static {
        System.out.println("静态初始化块");
    }

    {
        System.out.println("非静态初始化块");
    }

}
