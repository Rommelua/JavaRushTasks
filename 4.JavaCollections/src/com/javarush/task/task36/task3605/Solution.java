package com.javarush.task.task36.task3605;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
       // args = new String[]{"4.JavaCollections/src/com/javarush/task/task36/task3605/test1.txt"};
        Path file = Paths.get(args[0]);
        TreeSet<Character> set = new TreeSet<>();
        Files.lines(file).map(String::toLowerCase)
                .map(s -> s.replaceAll("\\W", ""))
                .flatMapToInt(String::chars)
                .distinct().sorted().limit(5)
                .forEach(i -> set.add((char)i));
        set.forEach(System.out::print);
    }
}
