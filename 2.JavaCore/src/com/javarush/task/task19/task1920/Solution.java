package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"D:\\Java\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1920\\test.txt"};
        SortedMap<String, Double> persons = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            reader.lines().forEach(s -> persons.merge(s.split(" ")[0],
                            Double.parseDouble(s.split(" ")[1]),
                            Double::sum));
        }
        double max = Collections.max(persons.values());
        persons.entrySet().stream().filter(entry -> entry.getValue() == max)
                .forEach((entry) -> System.out.println(entry.getKey()));
    }
}
