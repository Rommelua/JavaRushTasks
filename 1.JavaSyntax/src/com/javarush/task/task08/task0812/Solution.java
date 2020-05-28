package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int result = 1;
        for (int i = 0; i < list.size()-1;) {
            int counter = 1;
            while ( i + counter < list.size() && list.get(i).equals(list.get(i + counter))) {
                counter++;
            }
            i += counter;
            if (counter > result)
                result = counter;
        }
        System.out.println(result);
    }
}