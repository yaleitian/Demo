package com.springmvc.thread;

import com.springmvc.thread.AbstractAnimal.Calltoback;
/**
 * @author tianyalei
 */
public class LetOneStop implements Calltoback {

    /**
     * 动物对象
     */
    AbstractAnimal an;

    /**
     * 获取动物对象，可以传入兔子或乌龟的实例
     * @param an
     */
    public LetOneStop(AbstractAnimal an) {
        this.an = an;
    }

    /**
     * 让动物的线程停止
     */
    @Override
    public void win() {
        // 线程停止
        an.stop();
    }

}