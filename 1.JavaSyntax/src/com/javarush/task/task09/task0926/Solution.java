package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Collections;

/* 
Добавить в список пять объектов-массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        Collections.addAll(list, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2}, new int[]{1, 2, 3, 4}
                , new int[]{1, 2, 3, 4, 5, 6, 7}, new int[0]);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
