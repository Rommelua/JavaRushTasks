package com.javarush.task.task07.task0710;

/* 
В начало списка
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        String value = "Old value";
        System.out.println(value);

        //Получаем поле value в классе String
        Field field = value.getClass().getDeclaredField("value");
        //Разрешаем изменять его
        field.setAccessible(true);
        //Устанавливаем новое значение
        field.set(value, "JavaRush".getBytes());

        System.out.println(value);
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            strings.add(0,reader.readLine());
        }
        strings.stream().forEach(System.out::println);
    }
}
