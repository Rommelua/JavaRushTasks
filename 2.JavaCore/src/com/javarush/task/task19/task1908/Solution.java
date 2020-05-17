package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        String path1, path2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            path1 = reader.readLine();
            path2 = reader.readLine();
        }
        BufferedReader r = new BufferedReader(new FileReader(path1));
        r.close();
        String data = Files.lines(Paths.get(path1)).flatMap(l -> Stream.of(l.split(" ")))
                .filter(s -> s.matches("\\d+")).collect(Collectors.joining(" "));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path2))){
            writer.write(data);
        }
    }
}
