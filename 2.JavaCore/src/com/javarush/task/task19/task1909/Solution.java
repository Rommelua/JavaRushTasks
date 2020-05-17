package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String path1, path2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            path1 = reader.readLine();
            path2 = reader.readLine();
        }
        try (BufferedReader r = new BufferedReader(new FileReader(path1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(path2))){
            while (r.ready()) {
                writer.write(r.readLine().replaceAll("\\.", "!"));
            }
        }
    }
}
