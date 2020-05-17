package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        String path;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            path = reader.readLine();
        }
        FileInputStream f = new FileInputStream(path);
        f.close();
        Files.lines(Paths.get(path)).filter(line -> line.split(" ")[0].equals(args[0]))
                .findFirst().ifPresent(System.out::println);
    }
}
