package seventeen.algorithms;

public class JumpGame2 {

    public boolean canJump(int[] squares) {
        int n = squares.length;

        int max = 0;
        for (int i = 0; i < n-1; i++) {
            int jump = squares[i];
            System.out.println("\t" + (i+jump));
            max = Math.max(max, i+jump);
        }

        System.out.println(max);
        return max>n;
    }

    public static void main(String[] args) {
        JumpGame2 jg = new JumpGame2();

        int[] game = {3,2,1,0,4};
        int[] game1 = {2,3,1,1,4};

        boolean b = jg.canJump(game);
        System.out.println(b);
        b = jg.canJump(game1);
        System.out.println(b);
    }
}
