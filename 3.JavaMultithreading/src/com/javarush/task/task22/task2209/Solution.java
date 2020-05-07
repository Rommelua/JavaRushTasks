package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        String[] words = Files.lines(Paths.get(fileName)).flatMap(s1 -> Arrays.stream(s1.split(" ")))
                .toArray(String[]::new); // creating array of words
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) {
            return new StringBuilder();
        }
        List<String> list = new ArrayList<>(Arrays.asList(words));
        StringBuilder result = new StringBuilder(list.remove(0));
        for (int i = 0; i < list.size(); i++) {
            if (Character.toLowerCase(result.charAt(0)) ==
                    Character.toLowerCase(list.get(i).charAt(list.get(i).length() - 1))) {
                result.insert(0, list.remove(i) + " ");
                i = -1;
            } else if (Character.toLowerCase(result.charAt(result.length() - 1)) ==
                    Character.toLowerCase(list.get(i).charAt(0))) {
                result.append(" ").append(list.remove(i));
                i = -1;
            }
        }
        return result;
    }
}
