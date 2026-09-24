package test;

public class StringTest {
    public static void main(String[] args) {
        String[] words = {"level", "hello", "上海自来水来自海上", "abcba", "java"};
        for (String word : words) {
            System.out.println(word + " -> 反转: " + reverse(word) + ", 回文: " + isPalindrome(word));
        }
    }

    public static String reverse(String source) {
        if (source == null) {
            return null;
        }
        return new StringBuilder(source).reverse().toString();
    }

    public static boolean isPalindrome(String source) {
        if (source == null || source.length() == 0) {
            return false;
        }
        int left = 0;
        int right = source.length() - 1;
        while (left < right) {
            if (source.charAt(left) != source.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
