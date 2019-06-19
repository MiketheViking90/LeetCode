package algorithms;

public class TrappingRainWater {
    public int trap(int[] height) {
        int N = height.length;

        for (int i = 0; i < N; i++) {
            int l = getMaxLeft(i, height);
            int r = getMaxRight(i, height);
        }
        return 0;
    }

    private int getMaxLeft(int h, int[] height) {
        int max = height[h];
        for (int i = h; i >= 0; i++) {
        }
        return max;
    }

    private int getMaxRight(int h, int[] height) {
        int max = height[h];
        for (int i = h; i < height.length; i++) {
            
        }
        return max;
    }
}
