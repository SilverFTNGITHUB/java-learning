package com.pineftn.thread.basic;

//Sub Class
// class MyThread extend Thread{}

public class ThreadTestSubClass {
    public static void main(String[] args) {
        // main方法由主线程执行

        // 创建线程实例
        MyThread tA = new MyThread("ThreadA");
        MyThread tB = new MyThread("ThreadB");
        // 启动线程（call run()）
        tA.start();
        tB.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出：" + i);
        }

    }
}
