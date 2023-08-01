package com.pineftn.thread.safety;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    String cardId;
    double money;
    //final:确保在整个类的生命周期内lock不被改变，永远指向同一个对象
    private final ReentrantLock lock = new ReentrantLock();

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    public void drawMoneySyncBlock(double drawMoney) {
        String name = Thread.currentThread().getName();
        synchronized (this) {//用实例本身做锁，每个实例有不同的锁
            if (this.money >= drawMoney) {
                System.out.println(name + "来取钱" + drawMoney + "，成功！");
                this.money -= drawMoney;
                System.out.println(name + "来取钱后，余额剩余" + this.money);
            } else {
                System.out.println(name + "来取钱" + drawMoney + "，余额不足！");
            }
        }
    }

    //使用同步方法时，Java会隐式地为每个实例对象创建一个内置锁
    //比如在当前情况下，每个Account account = new Account()拥有一把锁
    public synchronized void drawMoneySyncMethod(double drawMoney) {
        String name = Thread.currentThread().getName();
        if (this.money >= drawMoney) {
            System.out.println(name + "来取钱" + drawMoney + "，成功！");
            this.money -= drawMoney;
            System.out.println(name + "来取钱后，余额剩余" + this.money);
        } else {
            System.out.println(name + "来取钱" + drawMoney + "，余额不足！");
        }
    }

    public void drawMoneyLock(double drawMoney) {
        String name = Thread.currentThread().getName();
        lock.lock();
        try {
            if (this.money >= drawMoney) {
                System.out.println(name + "来取钱" + drawMoney + "，成功！");
                this.money -= drawMoney;
                System.out.println(name + "来取钱后，余额剩余" + this.money);
            } else {
                System.out.println(name + "来取钱" + drawMoney + "，余额不足！");
            }
        } finally {
            // 使用finally，保证即使出现异常也会解锁，否则会被一直卡住
            lock.unlock();
        }
    }
}
