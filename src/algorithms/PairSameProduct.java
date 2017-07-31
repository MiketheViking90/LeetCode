package algorithms;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairSameProduct {

    @ToString
    private class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public void findEqualProductPairs(int[] nums) {
        Map<Integer, List<Pair>> productToCompositePairMap  = new HashMap<>();

        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int m1 = nums[i];

            for (int j = i+1; j < n; j++) {
                int m2 = nums[j];
                int product = m1*m2;
                Pair pair = new Pair(m1, m2);
                List<Pair> currentPairs = productToCompositePairMap.getOrDefault(product, new ArrayList<>());
                currentPairs.add(pair);
                productToCompositePairMap.put(product, currentPairs);
            }
        }

        for (int product : productToCompositePairMap.keySet()) {
            List<Pair> pairs = productToCompositePairMap.get(product);
            if (pairs.size() >= 2) {
                System.out.println(product);

                for (Pair pair : pairs) {
                    System.out.println("\t" + pair);
                }
            }
        }
    }

    public static void main(String[] args) {
        PairSameProduct psp = new PairSameProduct();

        int[] nums = {3, 4, 7, 1, 2, 9, 8};
        psp.findEqualProductPairs(nums);
    }

}
