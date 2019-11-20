package com.springmvc.thread;

/**
 * @author tianyalei
 */
public class PersonB extends Thread {
    /**
     * 创建银行对象
     */
    Bank bank;

    /**
     * 通过构造器传入银行对象，确保四个人进入的是一个银行
     * @param bank
     */
    public PersonB(Bank bank) {
        this.bank = bank;
    }

    /**
     * 重写run方法，在里面实现使用ATM取钱
     */
    @Override
    public void run() {
        int getMoney = 200;
        while (Bank.money >= getMoney) {
            // 每次取200块
            bank.ATM(200);
            try {
                // 取完休息0.1秒
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}