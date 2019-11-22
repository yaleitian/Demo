package com.springmvc.thread;

public class Food {
    String name="";

    /**
     * 通过构造方法传入食物的名字
     * @param name
     */
    public Food(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
