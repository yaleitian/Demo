package com.springmvc.thread;

/**
 * @author tianyalei
 */
public class ThreadSum extends Thread {

    /**
     * 判断要进行的操作
     */
    int operate = 0;
    /**
     * 要操作的数
     */
    static int sum = 0;
    /**
     * 创建一个静态钥匙
     * 值是任意的
     */
    static Object ob = "aa";

    /**
     * 把操作运算通过构造方法传进来
     *
     * @param operate
     */
    public ThreadSum(int operate) {
        super();
        this.operate = operate;
    }

    @Override
    public void run() {
        super.run();
        synchronized (ob) {
            while (sum < 10000) {
                if (operate > 0) {
                    sum += 5;
                    System.out.println( "加后，sum=" + sum );
                }
                try {
                    // 睡眠0.5秒
                    sleep( 5 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}