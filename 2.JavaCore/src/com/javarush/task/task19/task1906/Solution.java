package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        reader.close();
        try (FileReader fileReader = new FileReader(path1);
             FileWriter writer = new FileWriter(path2)) {
            while (fileReader.ready()) {
                fileReader.read();
                if (fileReader.ready()) {
                    writer.write(fileReader.read());
                }
            }
        }
    }
}
