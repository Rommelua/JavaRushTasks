package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        PrepareMyTest a;
        if ((a = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class)) != null) {
            Arrays.stream(a.fullyQualifiedNames()).forEach(System.out::println);
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        PrepareMyTest a;
        if ((a = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class)) != null) {
            Arrays.stream(a.value()).map(Class::getSimpleName).forEach(System.out::println);
            return true;
        }
        return false;
    }
}
