package com.pineftn.thread.basic;

//创建Runnable接口的匿名内部类
public class ThreadTestInner {
    public static void main(String[] args){
        //写法1
        Runnable target = new Runnable() {
            @Override
            public void run() {
                // 线程中实际运行的程序
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程输出：" + i);
                }
            }
        };
        new Thread(target).start();

        //写法2
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 线程中实际运行的程序
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程输出：" + i);
                }
            }
        }).start();
    }
}
