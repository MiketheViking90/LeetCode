package archive.algorithms;

public class HouseRobber2 {

    public int rob(int[] houses) {
        int n = houses.length;
        int[] val = new int[n];
        val[0] = houses[0];
        val[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < n; i++) {
            val[i] = Math.max(
                    val[i-2] + houses[i],
                    val[i-1]
            );
        }

        return val[n-1];
    }
}
