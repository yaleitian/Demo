package com.springmvc.thread;


/**
 * @author tianyalei
 */
public class Bank {

    /**
     * 假设一个账户有100000块钱
     */
    static int money = 100000;

    /**
     * 柜台Counter取钱的方法  参数是每次取走的钱
     * @param money
     */
    public synchronized void Counter(int money) {
        //取钱后总数减少
        Bank.money -= money;
        System.out.println("A取走了" + money + "还剩下" + (Bank.money));
    }

    /**
     * ATM取钱的方法 参数是每次取走的钱
     * @param money
     */
    public synchronized void ATM(int money) {
        //取钱后总数减少
        Bank.money -= money;
        System.out.println("B取走了" + money + "还剩下" + (Bank.money));
    }

    /**
     * ALPAY 参数是每次取走的钱
     * @param money
     */
    public synchronized void ALIPAY(int money) {
        //取钱后总数减少
        Bank.money -= money;
        System.out.println("C取走了" + money + "还剩下" + (Bank.money));
    }

    /**
     * PAYPAL 参数是每次取走的钱
     * @param money
     */
    public synchronized void PAYPAL(int money) {
        //取钱后总数减少
        Bank.money -= money;
        System.out.println("D取走了" + money + "还剩下" + (Bank.money));
    }

    /**
     * PAYONEER 参数是每次取走的钱
     * @param money
     */
    public synchronized void PAYONEER(int money) {
        //取钱后总数减少
        Bank.money -= money;
        System.out.println("D取走了" + money + "还剩下" + (Bank.money));
    }

}