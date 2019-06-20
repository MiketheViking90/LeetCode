package algorithms;

public class TrappingRainWater {
    public int trap(int[] height) {
        int N = height.length;
        int[] maxL = new int[N];
        int[] maxR = new int[N];

        int maxLeft = 0;
        for (int i = 0; i < N; i++) {
            int h = height[i];
            maxLeft = Math.max(maxLeft, h);
            maxL[i] = maxLeft;
        }

        int maxRight = 0;
        for (int i = N-1; i >= 0; i--) {
            int h = height[i];
            maxRight = Math.max(maxRight, h);
            maxR[i] = maxRight;
        }

        int area = 0;
        for (int i = 0; i < N; i++) {
            int h = height[i];
            int water = Math.min(maxL[i], maxR[i]) - h;
            area += water;
        }

        return area;
    }
}
