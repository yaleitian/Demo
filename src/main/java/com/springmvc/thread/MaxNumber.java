package com.springmvc.thread;

/**
 * @author tianyalei
 */
public class MaxNumber {

    int MaxYue1(int a,int b) {
        //在辗转相除之前，确保a比b大
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        //辗转相除法球最大公约数
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
