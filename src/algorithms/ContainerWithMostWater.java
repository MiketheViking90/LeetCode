package algorithms;

public class ContainerWithMostWater {

    int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int max = 0;

        while (i < j) {
            int h = Math.min(heights[i], heights[j]);
            int w = j-i;
            int area = h*w;

            max = Math.max(max, area);

            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cw = new ContainerWithMostWater();
        int a = cw.maxArea(new int[]{1, 1});
        System.out.println(a);
    }

}
