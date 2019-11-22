package com.springmvc.thread;

public class Waiter extends Thread{
    KFC kfc;

    /**
     * KFC要传入，保证每一个服务员和用户在同一个KFC对象内
     * @param kfc
     */
    public Waiter(KFC kfc) {
        this.kfc=kfc;
    }
    @Override
    public void run() {
        //每次生产的数量
        int size=(int)(Math.random()*5)+5;
        while (true) {
            //传入每次生产的数量
            kfc.prod(size);
        }

    }
}