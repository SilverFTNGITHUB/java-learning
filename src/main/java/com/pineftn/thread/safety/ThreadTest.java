package com.pineftn.thread.safety;

public class ThreadTest {
    public static void main(String[] args) {
        Account account = new Account("cardA", 1000);
        new DrawThread(account, "A").start();
        new DrawThread(account, "B").start();
    }
}
