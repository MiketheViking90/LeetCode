package eighteen.algo;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int N = A.length;
        int cnt = 0;

        for (int i = 0; i < N - 2; i++) {
            int j = i+1;
            int d = A[j]-A[i];

            int k = i+2;
            while (k < N && A[k++] - A[j++] == d) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6,7,8,9};
        ArithmeticSlices as = new ArithmeticSlices();
        int n = as.numberOfArithmeticSlices(nums);
        System.out.println(n);
    }
}
