package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[]{"D:\\Java\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1923\\test1.txt",
//                "D:\\Java\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1923\\test2.txt"};
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            List<String> list = reader.lines().flatMap(l -> Stream.of(l.split(" ")))
                    .filter(w -> w.matches(".*\\d.*"))
                    .map(w -> w + " ").collect(Collectors.toList());
            for (String s : list) {
                writer.write(s);
            }
        }
    }
}
