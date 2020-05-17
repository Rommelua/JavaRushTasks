package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"D:\\Java\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1919\\test.txt"};
        SortedMap<String, Double> persons = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            reader.lines()
                    .forEach(s -> persons.put(s.split(" ")[0],
                            persons.getOrDefault(s.split(" ")[0], 0.0) + Double.parseDouble(s.split(" ")[1])));
        }
        persons.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
