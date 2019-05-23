package convoy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

public class Interview2 {

    @Getter
    @RequiredArgsConstructor
    @ToString
    public static class Pair {
        final int x;
        final int y;
    }

    public static Pair[] getRectangle(int[][] img) {
        Pair topLeft = getTopLeft(img);
        Pair btmRight = getBottomRight(img, topLeft);

        Pair[] rect = new Pair[2];
        rect[0] = topLeft;
        rect[1] = btmRight;
        return rect;
    }

    private static Pair getTopLeft(int[][] img) {
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                if (img[i][j] == 1) {
                    return new Pair(i, j);
                }
            }
        }
        return null;
    }

    private static Pair getBottomRight(int[][] img, Pair topLeft) {
        int r = img.length;
        int c = img[0].length;

        int initX = topLeft.getX();
        int initY = topLeft.getY();

        while (initX < r && img[initX][initY] == 1) {
            initX++;
        }
        initX--;
        while(initY < c && img[initX][initY] == 1) {
            initY++;
        }

        return new Pair(initX, initY-1);
    }

    public static void main(String[] args) {
        int[][] img = {
                {0,0,0,0,0},
                {0,0,1,1,1},
                {0,0,1,0,1},
                {0,0,1,0,1},
                {0,0,1,0,1},
                {0,0,1,0,1},
                {0,0,1,1,1},
        };

        Pair[] rect = getRectangle(img);
        System.out.println(Arrays.toString(rect));
    }
}
