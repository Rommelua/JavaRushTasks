package templates;

import java.util.Arrays;

public class ArraySort extends Test {
    public static void main(String[] args) {
        int[] ints = getInts();
        // Сортировка вставками
        for (int i = 1; i < ints.length; i++) {
            for (int j = i; j > 0 && ints[j-1] > ints[j]; j--) {
                int temp = ints[j-1];
                ints[j-1] = ints[j];
                ints[j] = temp;
            }
            //System.out.println(Arrays.toString(ints));
        }
        System.out.println(Arrays.toString(ints));

        // Сортировка Шелла
        ints = getInts();
        int d = ints.length / 2;
        while (d>0) {
            for (int i = 0; i < ints.length - d; i++) {
                int j = i;
                while (j >= 0 && ints[j] > ints[j + d]) { //Этот цикл будет отрабатывать 1 или 0 раз пока d>1
                    int temp = ints[j];
                    ints[j] = ints[j+d];
                    ints[j+d] = temp;
                    j--;
                }
            }
            d = d/2;
        }
        System.out.println(Arrays.toString(ints));
        // Сортировка Шелла for
        ints = getInts();
        d = ints.length / 2;
        while (d>0) {
            for (int i = 0; i < ints.length - d; i++) {
                for (int j = i; j >= 0 && ints[j] > ints[j + d]; j--) { //Этот цикл будет отрабатывать 1 или 0 раз пока d>1
                    int temp = ints[j];
                    ints[j] = ints[j+d];
                    ints[j+d] = temp;
                }
            }
            d = d/2;
        }
        System.out.println(Arrays.toString(ints));
    }



    private static int[] getInts() {
        int[] array = new int[6];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

}
