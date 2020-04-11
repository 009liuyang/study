package com.ly.study;

import com.ly.study.springIoc.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yang.liu
 * @describe
 * @date 2020-04-09
 */
public class liwenhao {

    static ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        shenpi();
        makeContract();
        pool.submit(new Thread(liwenhao :: notifyNC));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    /**
     * 审批
     */
    public static void shenpi() throws InterruptedException {
        System.out.println("审批");
        Thread.sleep(1000);//模拟耗时
    }

    /**
     * 生成合同
     */
    public static void makeContract() throws InterruptedException {
        System.out.println("生成合同");
        Thread.sleep(1000);//模拟耗时
    }


    /**
     * 通知财务
     */
    public static void notifyNC() {
        System.out.println("通知财务");
        try {
            Thread.sleep(1000);//模拟耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void addPool(){
         ExecutorService pool = Executors.newCachedThreadPool();
         User u = new User();
        for (int i = 0; i < 10; i++) {
            pool.submit(new myThread(u));
        }
    }

    class myThread implements Runnable{
        User user;

        myThread(User u){
            this.user = u;
        }

        @Override
        public void run() {
            System.out.println("这里可以操作线程池传过来的user类"+user.getStudent());
        }
    }

}
