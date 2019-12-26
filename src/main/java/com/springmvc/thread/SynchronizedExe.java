package com.springmvc.thread;

/**
 * @author tianyalei
 */
public class SynchronizedExe {
    public void func1() {
        synchronized (this) {
            String i = "1";
            System.out.print( i + " " );
        }
    }

}
