package com.javarush.task.task07.task0715;

/* 
1. Создай список из слов "мама", "мыла", "раму".
2. После каждого слова вставь в список строку, содержащую слово "именно".

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Collections.addAll(strings,"мама", "мыла", "раму");
        strings.add(1,"именно");
        strings.add(3,"именно");
        strings.add(5,"именно");
        strings.stream().forEach(System.out::println);
    }
}
