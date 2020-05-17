package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] data = fileScanner.nextLine().split(" ", 4);
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            try {
                return new Person(data[1], data[2], data[0],
                        format.parse(data[3]));
            } catch (ParseException e) {
                return null;
            }
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
