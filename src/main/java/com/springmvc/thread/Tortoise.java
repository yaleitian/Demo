package com.springmvc.thread;


/**
 * @author tianyalei
 */
public class Tortoise extends AbstractAnimal {

    /**
     * Thread的方法，给线程赋值名字
     */
    public Tortoise() {
        setName("乌龟");
    }

    /**
     * 重写running方法，编写乌龟的奔跑操作
     */
    @Override
    public void runing() {
        // 跑的距离
        double dis = 0.1;
        length -= dis;
        if (length <= 0) {
            length = 0;
            System.out.println("乌龟获得了胜利");
            // 让兔子不要在跑了
            if (calltoback != null) {
                calltoback.win();
            }
        }
        System.out.println("乌龟跑了" + dis + "米，距离终点还有" + (int) length + "米");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}