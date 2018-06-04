package seventeen.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combos = new ArrayList<>();
        getCombos(n, k, new ArrayList<>(), combos);
        return combos;
    }

    private void getCombos(int n, int k, List<Integer> cur, List<List<Integer>> combos) {
        if (k == 0) {
            combos.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < n; i++) {
            cur.add(i);
            getCombos(n, k-1, cur, combos);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations combos = new Combinations();
        List<List<Integer>> cs = combos.combine(5, 2);
        System.out.println(cs);
    }
}
