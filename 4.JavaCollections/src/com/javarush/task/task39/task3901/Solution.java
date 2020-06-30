package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        int length = 1;
        if (s == null || s.isEmpty()) return 0;
        for (int i = 0; i < s.length() && s.length() - i > length; i++) {
            Set<Character> set = new HashSet<>();
            int j = i;
            while (j < s.length() &&!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
            }
            length = Math.max(length, set.size());
        }
        return length;
    }
}
