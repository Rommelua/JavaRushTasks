package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        String path3 = reader.readLine();
        reader.close(); //Считали 3 имени файлов
        // Записываем все данные в byte[] data
        byte[] data;
        int length;
        try (FileInputStream is = new FileInputStream(path1)) {
            data = new byte[is.available()];
            length = is.read(data);
        }
        // вычисляем половину
        int fileOneLength = length - length/2;
        // записываем данные в 2 файла
        try (FileOutputStream os = new FileOutputStream(path2)) {
            os.write(data, 0, fileOneLength);
        }
        try (FileOutputStream os2 = new FileOutputStream(path3)) {
            os2.write(data, fileOneLength, length / 2);
        }
    }
}
