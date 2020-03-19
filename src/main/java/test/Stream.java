package test;

import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int[] numsStream = { 1, 2, 3 };
        int sum2 = IntStream.of(numsStream).sum();
        System.out.println("结果为：" + sum);
        System.out.println("结果为：" + sum2);

    }
}
