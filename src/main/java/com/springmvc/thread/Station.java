package com.springmvc.thread;


/**
 * @author tianyalei
 */
public class Station extends Thread {

    /**
     * 通过构造方法给线程名字赋值  给线程名字赋值
     * @param name
     */
    public Station(String name) {
        super(name);
    }

    /**
     * 为了保持票数的一致，票数要静态
     */
    static int tick = 20;

    /**
     * 创建一个静态钥匙
     * 值是任意的
     */
    static Object ob = "aa";

    /**
     * 重写run方法，实现买票操作
     */
    @Override
    public void run() {
        while (tick > 0) {
            // 这个很重要，必须使用一个锁，
            synchronized (ob) {
                // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
                if (tick > 0) {
                    System.out.println(getName() + "卖出了第" + tick + "张票");
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }
            }
            try {
                // 休息一秒
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
