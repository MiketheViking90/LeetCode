package algorithms;

import java.util.Arrays;

public class ConstructTheRectange {

    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);

        int l = area;
        int w = 1;
        for (int i = 2; i <= sqrt; i++) {
            if (area % i == 0) {
                w = i;
                l = (area / i);
            }
        }

        return new int[]{l, w};
    }

    public static void main(String[] args) {
        ConstructTheRectange ctr = new ConstructTheRectange();
        System.out.println(Arrays.toString(ctr.constructRectangle(16)));
        System.out.println(Arrays.toString(ctr.constructRectangle(17)));
        System.out.println(Arrays.toString(ctr.constructRectangle(36)));
    }
}
