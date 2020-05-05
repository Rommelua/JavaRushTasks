package com.javarush.task.task10.task1019;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Программа вводит с клавиатуры пары (число и строку), сохраняет их в HashMap.
Пустая строка - конец ввода данных.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int id;
        String name;
        while (true) {
            name = reader.readLine();
            if (name.isEmpty()) {
                break;
            }
            id = Integer.parseInt(name);
            name = reader.readLine();
            map.put(name, id);
        }
        map.forEach((k, v) -> System.out.println(v + " " + k));
    }
}
