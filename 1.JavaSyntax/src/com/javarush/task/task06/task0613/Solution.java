package com.javarush.task.task06.task0613;

/* 
1. В классе Cat создай статическую переменную public int catCount.
2. В классе Cat создай конструктор public Cat() без параметров.
3. Конструктор должен увеличивать значение статической переменной catCount на 1.
4. В методе main создай 10 котов.
5. В методе main, после создания всех котов, выведи значение переменной catCount.
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Cat c = new Cat();
        }

        System.out.println(Cat.catCount);
    }

    public static class Cat {
       public static int catCount;

        public Cat() {
            catCount++;
        }
// Создай конструктор
    }
}
