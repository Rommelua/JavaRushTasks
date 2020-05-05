package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }



    public boolean fight(Cat anotherCat) {
        int thisScore = 0;
        int anotherScore = 0;
        if (strength > anotherCat.strength) {
            thisScore++;
        } else if (strength < anotherCat.strength) anotherScore++;
        if (age > anotherCat.age) {
            thisScore++;
        } else if (age < anotherCat.age) anotherScore++;
        if (weight > anotherCat.weight) {
            thisScore++;
        } else if (weight < anotherCat.weight) anotherScore++;

        if (thisScore != anotherScore)
            return thisScore > anotherScore;
        if (strength != anotherCat.strength)
            return strength > anotherCat.strength;
        if (age != anotherCat.age)
        return age > anotherCat.age;
        return strength > anotherCat.age;
    }

    public static void main(String[] args) {

    }
}
