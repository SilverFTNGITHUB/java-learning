package com.pineftn.thread.basic;

/*
One is to declare a class to be a subclass of Thread.
This subclass should override the run method of class Thread.
An instance of the subclass can then be allocated and started.
For example, a thread that computes primes larger than a stated value could be written as follows:
*/

class MyThread extends Thread {
    String name;

    //constructor 创建一个线程（实例）：new MyThread()
    MyThread(String name) {
        this.name = name;
    }

    // 重写thread类的run方法
    // 在 MyThreadInstance.start()时，run()被调用
    @Override
    public void run() {
        // 线程中实际运行的程序
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread name = " + this.name + ", 线程输出：" + i);
        }
    }
}
