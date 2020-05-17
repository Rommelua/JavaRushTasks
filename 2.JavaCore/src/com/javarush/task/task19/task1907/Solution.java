package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        reader.close();
        try (FileReader fileReader = new FileReader(path1)) {}
        long res = Files.lines(Paths.get(path1)).flatMap(s -> Stream.of(s.split("\\W")))
                .filter(s1 -> s1.equals("world")).count();
        System.out.println(res);
    }
}
