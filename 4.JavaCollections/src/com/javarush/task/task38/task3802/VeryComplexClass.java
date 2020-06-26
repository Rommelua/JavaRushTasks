package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        Stream<String> s = Files.lines(Paths.get("kjd"));
    }

    public static void main(String[] args) {

    }
}
