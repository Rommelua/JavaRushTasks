package com.javarush.task.task08.task0809;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
2. Метод main должен вызывать метод getInsertTimeInMs только два раза.
3. Метод insert10000(List list) должен вставлять 10 тысяч элементов в список.
4. Метод getInsertTimeInMs должен вызывать метод insert10000 только один раз.
5. Метод getInsertTimeInMs должен вернуть время в миллисекундах, которое занимает 10 тысяч вставок в список.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getInsertTimeInMs(new ArrayList()));
        System.out.println(getInsertTimeInMs(new LinkedList()));
    }

    public static long getInsertTimeInMs(List list) {
        Date start = new Date();

        insert10000(list);

        Date end = new Date();
        return end.getTime() - start.getTime();
    }

    public static void insert10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(0, new Object());
        }
    }
}
