package com.javarush.task.task07.task0705;

/* 
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[20];
        for (int i = 0; i < 20; i++) {
            result[i] = Integer.parseInt(reader.readLine());
        }
        int[] one = new int[10];
        one = Arrays.copyOf(result,10);
        int[] two = new int[10];
        two = Arrays.copyOfRange(result,10, 20);
        Arrays.stream(two).forEach(System.out::println);
    }
}
