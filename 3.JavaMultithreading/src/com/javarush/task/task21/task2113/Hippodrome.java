package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        Collections.addAll(horses,
                new Horse("\uD83D\uDC0E", 3, 0),
                new Horse("Staraya Klyacha", 3, 0),
                new Horse("Hromaya Kobula", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
        }
    }
    public  void move(){
        horses.forEach(Horse::move);
    }
    public void print(){
        horses.forEach(Horse::print);
        IntStream.range(0, 10).forEach(i -> System.out.println());
    }
    public Horse getWinner(){
        return Collections.max(horses, Comparator.comparingDouble(Horse::getDistance));
    }
    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());
    }
}
