package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        String text;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            text = reader.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(text))) {
            reader.lines().map(s -> new StringBuilder(s).reverse().toString())
                    .forEach(System.out::println);
        }
    }
}
