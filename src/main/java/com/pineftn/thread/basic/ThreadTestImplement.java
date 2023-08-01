package com.pineftn.thread.basic;

// implement interface
// class MyThreadImplement implement Runnable{}

public class ThreadTestImplement {
    public static void main(String[] args) {
        Runnable target = new MyRunnable("A");
        //使用myThread作为参数，通过Thread的构造器，构造新的Thread实例
        // Thread threadIns = new Thread(target);
        // threadIns.start();
        //简写（标准写法）
        new Thread(target).start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main thread: " + i);
        }
    }
}
