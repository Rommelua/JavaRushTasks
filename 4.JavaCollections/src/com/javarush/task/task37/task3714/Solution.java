package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }
    public static int romanToInteger(String s) {
        List<String> letters = Arrays.asList("I", "V", "X", "L", "C", "D", "M");
        int[] numbers = {1, 5, 10, 50, 100, 500, 1000};
        String[] task = s.split("");
        int result = numbers[letters.indexOf(task[task.length - 1])];
        for (int i = task.length - 2; i >= 0 ; i--) {
            if (numbers[letters.indexOf(task[i])] < numbers[letters.indexOf(task[i + 1])]) {
                result -= numbers[letters.indexOf(task[i])];
            } else {
                result += numbers[letters.indexOf(task[i])];
            }
        }
        return result;
    }

//    public static int romanToInteger(String s) {
//        List<Integer> numbers = convertToNumList(s);
//        int temp = numbers.get(0);
//        if (s.length() < 2) return temp;
//        int result = 0;
//        int successionIndex = 1;
//        for (int i = 1; i < numbers.size(); i++) {
//            if (numbers.get(i).equals(numbers.get(i - 1))) {
//                temp += numbers.get(i);
//                if (++successionIndex == 4) {
//                    throw new IllegalArgumentException();
//                }
//            } else if (numbers.get(i) > numbers.get(i - 1)) {
//                result += numbers.get(i) - temp;
//                temp = 0;
//                successionIndex = 1;
//            } else {
//                result += temp;
//                temp = numbers.get(i);
//                successionIndex = 1;
//            }
//        }
//        return result + temp;
//    }

//    private static List<Integer> convertToNumList(String roman) {
//        char[] chars = roman.toCharArray();
//        List<Integer> numbers = new ArrayList<>();
//        for (int i = 0; i < chars.length; i++) {
//            switch (chars[i]) {
//                case 'I':
//                    numbers.add(1);
//                    break;
//                case 'V':
//                    numbers.add(5);
//                    break;
//                case 'X':
//                    numbers.add(10);
//                    break;
//                case 'L':
//                    numbers.add(50);
//                    break;
//                case 'C':
//                    numbers.add(100);
//                    break;
//                case 'D':
//                    numbers.add(500);
//                    break;
//                case 'M':
//                    numbers.add(1000);
//                    break;
//                default:
//                    throw new IllegalArgumentException();
//            }
//        }
//        return numbers;
//    }
}
