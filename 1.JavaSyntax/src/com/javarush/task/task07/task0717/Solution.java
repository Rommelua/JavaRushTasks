package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        ArrayList<String> result = doubleValues(list);

        result.stream().forEach(System.out::println);
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        return list.stream().flatMap(s -> Stream.of(s, s)).collect(Collectors.toCollection(ArrayList::new));
    }
}
