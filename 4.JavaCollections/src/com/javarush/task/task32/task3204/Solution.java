package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String symbols = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        List<Byte> parol = new ArrayList<>();
        parol.add((byte) symbols.charAt(random.nextInt(10)));
        parol.add((byte) symbols.charAt(random.nextInt(26) + 10));
        parol.add((byte) symbols.charAt(random.nextInt(26) + 36));
        for (int i = 0; i < 5; i++) {
            parol.add((byte) symbols.charAt(random.nextInt(62)));
        }
        Collections.shuffle(parol);
        ByteArrayOutputStream bar = new ByteArrayOutputStream();
        parol.forEach(bar::write);
        return bar;
    }
}