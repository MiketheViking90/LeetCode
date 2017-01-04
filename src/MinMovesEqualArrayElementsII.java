public class MinMovesEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        int sum = findSum(nums);
        int avg = sum / nums.length;

        int moves = 0;
        for (int i : nums) {
            int curMoves = findDiff(i, avg);
            moves += curMoves;
        }
        return moves;
    }

    private int findDiff(int n1, int n2) {
        if (n1 > n2) {
            return n1-n2;
        }
        return n2-n1;
    }

    private int findSum(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        MinMovesEqualArrayElementsII minMoves = new MinMovesEqualArrayElementsII();

        int[] vals = {1,0,0,8,6};
        int moves = minMoves.minMoves2(vals);
        System.out.println(moves);
    }
}
