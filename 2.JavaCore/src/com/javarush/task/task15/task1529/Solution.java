package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();//add your code here - добавьте код тут
    }

    public static CanFly result;

    public static void reset() {
        String s = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            s = reader.readLine();
            if (s.equals("helicopter")) {
                result = new Helicopter();
            }
            if (s.equals("plane")) {
                int capacity = Integer.parseInt(reader.readLine());
                result = new Plane(capacity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
