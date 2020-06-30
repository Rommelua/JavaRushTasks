package com.javarush.task.task39.task3905;

import java.util.Arrays;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (desiredColor == null || x < 0 || y < 0 || y >= image.length || x >= image[y].length || image[y][x] == desiredColor) {
            return false;
        }
        image[y][x] = desiredColor;
        return true;
    }
}
