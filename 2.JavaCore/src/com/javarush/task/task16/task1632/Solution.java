package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }
    public static void main(String[] args) {
    }
    public static class ThreadOne extends Thread{
        @Override
        public void run() {
            while (true) {

            }
        }
    }
    public static class ThreadTwo extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
    public static class ThreadThree extends Thread{
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class ThreadFour extends Thread implements Message{
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        @Override
        public void showWarning() {
            if (isAlive()) {
                interrupt();
            }
        }
    }
    public static class ThreadFive extends Thread{
        @Override
        public void run() {
            int sum = 0;
            String s;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (!(s = reader.readLine()).equals("N")) {
                    sum += Integer.parseInt(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        }
    }
}