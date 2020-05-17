package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
    public static void main(String[] args) throws IOException {
        String text;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            text = reader.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(text))) {
            reader.lines()
                    .map(l -> Stream.of(l.split(" ")) //Внутри оператора map превращаем линию в стрим слов
                            .map(s -> s.matches("\\d+") ? map.getOrDefault(Integer.parseInt(s), s) : s)//Если попадаются слова из цифр - пробуем заменить
                            .collect(Collectors.joining(" ")))//Собираем все обратно в строку
                    .forEach(System.out::println);//Печатаем
        }
    }
}
