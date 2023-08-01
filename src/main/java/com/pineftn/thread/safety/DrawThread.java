package com.pineftn.thread.safety;

public class DrawThread extends Thread{
    private Account account;

    public DrawThread(Account account, String name){
        //显式调用父类（Thread）的构造器，指定线程名称
        super(name);
        this.account = account;
    }

    @Override
    public void run(){
        account.drawMoneySyncMethod(1000);
    }
}
