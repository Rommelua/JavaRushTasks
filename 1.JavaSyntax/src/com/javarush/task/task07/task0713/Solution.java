package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/* 
1. Объяви и сразу проинициализируй 4 переменных типа ArrayList<Integer> (список целых чисел). Первый список будет главным, а остальные - дополнительными.
2. Считать 20 чисел с клавиатуры и добавить их в главный список.
3. Добавить в первый дополнительный список все числа из главного, которые нацело делятся на 3.
4. Добавить во второй дополнительный список все числа из главного, которые нацело делятся на 2.
5. Добавить в третий дополнительный список все остальные числа из главного.
7. Программа должна вывести три дополнительных списка, используя метод printList.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> all = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        ArrayList<Integer> three = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            all.add(Integer.parseInt(reader.readLine()));
        }
//        List<Integer> oneList = all.stream().filter(i -> i % 3 == 0).collect(Collectors.toList());
//        List<Integer> twoList = all.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
//        List<Integer> threeList = all.stream().filter(i -> i % 2 != 0 && i % 3 != 0).collect(Collectors.toList());
//        Collections.copy(one, oneList);
//        Collections.copy(two, twoList);
//        Collections.copy(three, threeList);
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i) % 3 == 0)
                one.add(all.get(i));
            if (all.get(i) % 2 == 0)
                two.add(all.get(i));
            if (all.get(i) % 3 != 0 && all.get(i) % 2 != 0)
                three.add(all.get(i));
        }
        printList(one);
        printList(two);
        printList(three);
    }

    public static void printList(ArrayList<Integer> list) {
        list.stream().forEach(System.out::println);
    }
}
