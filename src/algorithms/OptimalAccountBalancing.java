package algorithms;

import java.util.*;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> accounts = new HashMap<>();
        for (int[] tx : transactions) {
            int debtor = tx[0];
            int creditor = tx[1];
            int amt = tx[2];

            int debits = accounts.getOrDefault(debtor, 0);
            int credits = accounts.getOrDefault(creditor, 0);
            debits -= amt;
            credits += amt;

            accounts.put(debtor, debits);
            accounts.put(creditor, credits);
        }

        return countTransactions(new ArrayList<>(accounts.values()));
    }

    private int countTransactions(List<Integer> balances) {
        Collections.sort(balances);
        int i = 0;
        int j = balances.size() - 1;
        int cnt = 0;
        while (i < j) {
            int iVal = balances.get(i);
            int jVal = balances.get(j);

            if (iVal >= 0 && jVal >= 0) {
                return cnt;
            }
            if (Math.abs(iVal) > jVal) {
                balances.set(i, iVal + jVal);
                balances.set(j, 0);
                j--;
            } else if (Math.abs(iVal) < jVal){
                balances.set(i, 0);
                balances.set(j, jVal - iVal);
                i++;
            } else {
                balances.set(i, 0);
                balances.set(j, 0);
                i++;
                j--;
            }
            cnt++;
        }
        return cnt;
    }
}
