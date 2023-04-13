package test;

import java.util.HashMap;
import java.util.Map;

public class mapTest {
    public static void main(String[] args) {
        String[] numbers = {"101", "201", "301", "401", "501", "601", "701", "801", "901", "1001", "2001"};
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
        Map<String, Character> map = new HashMap<String, Character>();

        for (int i = 1; i <= numbers.length; i++) {
            map.put(numbers[i-1], letters[i-1]);
        }
        System.out.println(map);
    }
}
