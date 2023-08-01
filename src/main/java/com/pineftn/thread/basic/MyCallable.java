package com.pineftn.thread.basic;

import java.util.concurrent.Callable;

/*
实现Callable接口
Callable<Type> {
public Type call() {
}
}

 */
public class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "子线程求出1~" + n + "的和是" + sum;
    }

}
