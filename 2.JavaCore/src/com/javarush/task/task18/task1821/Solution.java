package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
//        SortedMap<Character, Integer> map = new TreeMap<>();
//        String s;
//        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
//            s = reader.readLine();
//        }
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (map.containsKey(ch)) {
//                map.put(ch, map.get(ch) + 1);
//            } else map.put(ch, 1);
//        }
//        map.forEach((k, v) -> System.out.println(k + " " + v));
        int[] array = new int[128];
        try (FileInputStream fis = new FileInputStream(args[0])) {
            while (fis.available() > 0)
                array[fis.read()]++;
        }
        for (int i = 1; i < array.length; i++)
            if (array[i] != 0)
                System.out.println(((char) i) + " " + array[i]);
    }
}
