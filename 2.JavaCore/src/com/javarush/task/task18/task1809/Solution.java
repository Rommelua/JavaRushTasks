package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        reader.close();

        FileInputStream is = new FileInputStream(path1);
        byte[] data = new byte[is.available()];
        int length = is.read(data);
        is.close();

        FileOutputStream os = new FileOutputStream(path2);
        for (int i = length - 1; i >= 0 ; i--) {
            os.write(data[i]);
        }
        os.close();
    }
}
