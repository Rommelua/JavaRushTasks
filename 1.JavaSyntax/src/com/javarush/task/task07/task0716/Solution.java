package com.javarush.task.task07.task0716;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }
//2.1. удалять из списка строк все слова, содержащие букву "р"
// 2.2. удваивать все слова содержащие букву "л".
// 2.3. если слово содержит и букву "р" и букву "л", то оставить это слово без изменений.

    public static ArrayList<String> fix(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {

            if (strings.get(i).contains("р") && strings.get(i).contains("л"))
                continue;
            if (strings.get(i).contains("р")) {
                strings.remove(i);
                i--;
                continue;
            }
            if (strings.get(i).contains("л")) {
                strings.add(i, strings.get(i));
                i++;
            }
        }
        return strings;
    }
}