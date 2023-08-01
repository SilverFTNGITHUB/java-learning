package com.pineftn.thread.basic;

//实现runable接口（只有一个run()需要实现）
class MyRunnable implements Runnable {
    String name;

    MyRunnable(String name) {
        this.name = name;
    }

    // 实现runable接口的run()方法
    // 在 MyThreadInstance.start()时，run()被调用
    @Override
    public void run() {
        // 线程中实际运行的程序
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread name = " + this.name + ", 线程输出：" + i);
        }
    }
}

