package test;

public class FibonacciTest {
    public static void main(String[] args) {
        int count = 10;
        System.out.println("前 " + count + " 项斐波那契数列：");
        for (int i = 0; i < count; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }

    public static long fibonacci(int n) {
        long previous = 0;
        long current = 1;
        for (int i = 0; i < n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return previous;
    }
}
