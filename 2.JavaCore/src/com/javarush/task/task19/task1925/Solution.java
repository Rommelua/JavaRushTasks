package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[]{"2.JavaCore/src/com/javarush/task/task19/task1925/test1.txt",
                "2.JavaCore/src/com/javarush/task/task19/task1925/test2.txt"};
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            String s = reader.lines().flatMap(l -> Stream.of(l.split(" ")))
                    .filter(w -> w.length() > 6)
                    .collect(Collectors.joining(","));
                writer.write(s);
        }
    }
}
