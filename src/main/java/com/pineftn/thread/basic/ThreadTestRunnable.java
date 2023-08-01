package com.pineftn.thread.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTestRunnable {
    public static void main(String[] args) {
        // call不是一个任务对象，不能直接交给Thread
        Callable<String> call = new MyCallable(100);
        // 要封装为FutureTask 线程任务对象
        // FutureTask中实现了Runnable接口
        FutureTask<String> target = new FutureTask<String>(call);
        // 启动线程
        new Thread(target).start();

        // 获取线程返回结果
        // 正常运行，get得到返回结果
        // 有异常，抛出Exception
        try {
            // 阻塞等待线程执行完毕 拿取结果
            String retStr = target.get();
            System.out.println(retStr);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
