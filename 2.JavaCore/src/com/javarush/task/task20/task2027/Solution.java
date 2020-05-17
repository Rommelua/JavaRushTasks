package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same", "lse").forEach(System.out::println);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();
        for (String s : words) {
            Word w = new Word(s);
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if(crossword[i][j] == s.charAt(0)){
                        int length = s.length() - 1;
                        int m = i;
                        int n = j;      //----Вперед---//
                        while (++n < crossword[i].length && crossword[i][n] == s.charAt(n - j)){
                            length--;
                            if (length == 0) {
                                w.setStartPoint(j,i);
                                w.setEndPoint(n, m);
                                result.add(w);
                                break;
                            }
                        }
                        length = s.length() - 1;
                        m = i;
                        n = j;          //----Вперед и вниз---//
                        while (++n < crossword[i].length && ++m < crossword.length && crossword[m][n] == s.charAt(n - j)){
                            length--;
                            if (length == 0) {
                                w.setStartPoint(j,i);
                                w.setEndPoint(n, m);
                                result.add(w);
                                break;
                            }
                        }
                        length = s.length() - 1;
                        m = i;
                        n = j;          //----Вниз---//
                        while (++m < crossword.length && crossword[m][n] == s.charAt(m - i)){
                            length--;
                            if (length == 0) {
                                w.setStartPoint(j,i);
                                w.setEndPoint(n, m);
                                result.add(w);
                                break;
                            }
                        }
                        length = s.length() - 1;
                        m = i;
                        n = j;          //----Вниз и назад---//
                        while (--n >= 0 && ++m < crossword.length && crossword[m][n] == s.charAt(m - i)){
                            length--;
                            if (length == 0) {
                                w.setStartPoint(j,i);
                                w.setEndPoint(n, m);
                                result.add(w);
                                break;
                            }
                        }
                        length = s.length() - 1;
                        m = i;
                        n = j;          //----Назад---//
                        while (--n >= 0 && crossword[m][n] == s.charAt(j - n)){
                            length--;
                            if (length == 0) {
                                w.setStartPoint(j,i);
                                w.setEndPoint(n, m);
                                result.add(w);
                                break;
                            }
                        }
                        length = s.length() - 1;
                        m = i;
                        n = j;          //----Назад и вверх---//
                        while (--n >= 0 && --m >= 0 && crossword[m][n] == s.charAt(j - n)){
                            length--;
                            if (length == 0) {
                                w.setStartPoint(j,i);
                                w.setEndPoint(n, m);
                                result.add(w);
                                break;
                            }
                        }
                        length = s.length() - 1;
                        m = i;
                        n = j;          //----вверх---//
                        while (--m >= 0 && crossword[m][n] == s.charAt(i - m)){
                            length--;
                            if (length == 0) {
                                w.setStartPoint(j,i);
                                w.setEndPoint(n, m);
                                result.add(w);
                                break;
                            }
                        }
                        length = s.length() - 1;
                        m = i;
                        n = j;          //----вверх and strait---//
                        while (++n < crossword[i].length && --m >= 0 && crossword[m][n] == s.charAt(i - m)){
                            length--;
                            if (length == 0) {
                                w.setStartPoint(j,i);
                                w.setEndPoint(n, m);
                                result.add(w);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
