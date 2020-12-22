package com.ly.study.design.命令模式;

public class Main {
    public static void main(String[] args) {
        Command cmd = new CommandImpl();
        Invoker ir = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法...");
        ir.call();
    }
}
