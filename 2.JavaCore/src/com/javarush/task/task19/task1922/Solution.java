package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        String text;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            text = reader.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(text))) {
            reader.lines().map(s -> Stream.of(s.split(" ")).collect(Collectors.toList()))
                    .filter(s -> words.stream().mapToInt(w -> Collections.frequency(s, w)).sum() == 2)
                    .map(l -> String.join(" ", l)).forEach(System.out::println);
        }
    }
}
