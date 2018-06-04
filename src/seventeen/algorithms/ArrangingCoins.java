package seventeen.algorithms;

public class ArrangingCoins {

    public int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        int i = 1;
        while (cumulativeSum(i) <= n) {
            i++;
        }

        return i-1;
    }

    private int cumulativeSum(int i) {
        return (i * (i+1)) / 2;
    }

    public static void main(String[] args) {
        ArrangingCoins ac = new ArrangingCoins();
        int n = ac.arrangeCoins(3);
        System.out.println(n);
    }
}
