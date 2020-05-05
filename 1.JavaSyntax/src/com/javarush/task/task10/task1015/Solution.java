package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.Collections;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] res = new ArrayList[2];
        res[0] = new ArrayList<>();
        Collections.addAll(res[0], "kkk", "ttt");
        res[1] = new ArrayList<>();
        Collections.addAll(res[1], "111", "222");
        return res;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}