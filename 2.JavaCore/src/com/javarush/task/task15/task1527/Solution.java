package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String url = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            url = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] parameters = url.replaceFirst(".*\\?", "").split("&");
        Arrays.stream(parameters).map(s -> s.replaceFirst("=.*", ""))
                .map(s -> s +" ")
                .forEach(System.out::print);
        String obj = Arrays.stream(parameters).filter(s -> s.startsWith("obj"))
                .map(s -> s.replaceFirst(".*=", ""))
                .findFirst().orElse("");
        if (!obj.isEmpty()) {
            System.out.println();
            if (obj.matches("-?\\d+\\.?\\d*")) {
                alert(Double.parseDouble(obj));
            }else alert(obj);
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
