package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        String s;
        do {
            s = reader.readLine();
            writer.write(s);
            writer.newLine();
        } while (!s.equals("exit"));
        writer.close();
    }
}
