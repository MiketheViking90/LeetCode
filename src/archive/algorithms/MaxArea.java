package archive.algorithms;

public class MaxArea {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;
        int area = 0;

        while (l < r) {
            int lHeight = height[l];
            int rHeight = height[r];

            int w = r - l;
            int h = Math.min(lHeight, rHeight);
            area = Math.max(w*h, area);

            if (rHeight > lHeight) {
                l++;
            } else if (rHeight < lHeight) {
                r--;
            } else {
                l++;
                r--;
            }
        }
        return area;
    }
}
