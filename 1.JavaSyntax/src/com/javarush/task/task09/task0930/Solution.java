package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* 
Слова вывести в возрастающем порядке, числа - в убывающем.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        List<Boolean> isNumber = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        List<String> words = new ArrayList<>();
        for (String s : array) {
            if (isNumber(s)) {
                numbers.add(Integer.parseInt(s));
                isNumber.add(true);
            } else {
                words.add(s);
                isNumber.add(false);
            }
        }
        Collections.sort(words);
        numbers.sort(Collections.reverseOrder());
        Iterator<Integer> numberIterator = numbers.iterator();
        Iterator<String> wordIterator = words.iterator();
        for (int i = 0; i < array.length; i++) {
            if (isNumber.get(i)) {
                array[i] = String.valueOf(numberIterator.next());
            } else {
                array[i] = wordIterator.next();
            }
        }
        isGreaterThan(array[0], array[0]);
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
