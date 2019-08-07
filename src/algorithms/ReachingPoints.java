package algorithms;

public class ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        int[][] mem = new int[tx+1][ty+1];
        return reachingPointsRecur(sx, sy, tx, ty, mem);
    }

    private boolean reachingPointsRecur(int sx, int sy, int tx, int ty, int[][] mem) {
        if (mem[sx][sy] == -1) {
            return true;
        }
        if (mem[sx][sy] == 1) {
            return true;
        }
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx && sy == ty) {
            return true;
        }
        int sum = sx + sy;
        boolean addToX = false;
        boolean addToY = false;
        if (sum <= tx) {
            addToX = reachingPointsRecur(sum, sy, tx ,ty, mem);
        }
        if (sum <= ty) {
            addToY = reachingPointsRecur(sx, sum, tx, ty, mem);
        }
        if (addToX || addToY) {
            mem[sx][sy] = 1;
        } else {
            mem[sx][sy] = -1;
        }
        return addToX || addToY;
    }
}
