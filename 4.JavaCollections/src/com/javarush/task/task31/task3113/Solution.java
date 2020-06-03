package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path directory = Paths.get(reader.readLine());
        if (!Files.isDirectory(directory)) {
            System.out.println(directory.toString() + " - не папка");
            return;
        }
        final int[] directoryNumber = {-1};
        final int[] fileNumber = {0};
        final long[] size = {0};
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                fileNumber[0]++;
                size[0] += attrs.size();
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                directoryNumber[0]++;
                return super.preVisitDirectory(dir, attrs);
            }
        });
        System.out.println("Всего папок - " + directoryNumber[0]);
        System.out.println("Всего файлов - " + fileNumber[0]);
        System.out.println("Общий размер - " + size[0]);
    }
}
