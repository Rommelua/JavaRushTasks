package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new FileReader(args[0], Charset.forName("Windows-1251")));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1], StandardCharsets.UTF_8))) {
//            while (reader.ready()) {
//                String s = reader.readLine();
//                writer.write(s);
//            }
//        }
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), Charset.forName("Windows-1251")));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {
            while (in.ready()) {
                String s = in.readLine();
                out.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
