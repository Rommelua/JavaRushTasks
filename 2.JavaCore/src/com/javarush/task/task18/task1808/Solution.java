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
        FileInputStream is = new FileInputStream(path1);
        byte[] data = new byte[is.available()];
        int length = is.read(data);
        is.close();
        // вычисляем половину
        int cut = length - length/2;
        // записываем данные в 2 файла
        FileOutputStream os = new FileOutputStream(path2);
        os.write(data, 0, cut);
        os.close();

        FileOutputStream os2 = new FileOutputStream(path3);
        os2.write(data, cut, length/2);
        os2.close();
    }
}
