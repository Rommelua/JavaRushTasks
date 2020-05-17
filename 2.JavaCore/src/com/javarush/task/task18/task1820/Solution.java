package com.javarush.task.task18.task1820;

/* 
Округление чисел
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
        String s;
        try (BufferedReader reader = new BufferedReader(new FileReader(path1))) {
            s = reader.readLine();
        }
        String result = Stream.of(s.split(" "))
                .map(Double::parseDouble).map(Math::round).map(String::valueOf)
                .collect(Collectors.joining(" "));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path2))) {
            writer.write(result);
        }
    }
}
