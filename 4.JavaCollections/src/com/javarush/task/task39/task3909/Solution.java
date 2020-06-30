package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("abc", "abcd"));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first == null || second == null || Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        int differences = 0;
        for (int f = 0, s = 0; f < first.length() && s < second.length(); f++, s++) {
            if (first.charAt(f) != second.charAt(s)) {
                differences++;
                if (first.length() > second.length()) {
                    s--;
                } else if (second.length() > first.length()) {
                    f--;
                }
            }
        }
        return differences < 2;
    }
}
