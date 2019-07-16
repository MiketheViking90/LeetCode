package algorithms;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] lProds = new int[N];
        int[] rProds = new int[N];

        int curProd = 1;
        lProds[0] = curProd;
        for (int i = 1; i < N; i++) {
            curProd *= nums[i-1];
            lProds[i] = curProd;
        }

        curProd = 1;
        rProds[N-1] = curProd;
        for (int i = N-2; i >= 0; i--) {
            curProd *= nums[i+1];
            rProds[i] = curProd;
        }

        int[] prods = new int[N];
        for (int i = 0; i < N; i++) {
            prods[i] = lProds[i] * rProds[i];
        }
        return prods;
    }
}
