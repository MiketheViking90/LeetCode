package algorithms.quadtree;

public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        return makeNode(0, M-1, 0, N-1, grid);
    }

    private Node makeNode(int r0, int r1, int c0, int c1, int[][] grid) {
        if (r0 < 0 || r1 >= grid.length || c0 < 0 || c1 >= grid[0].length) {
            return null;
        }

        boolean b = (grid[r0][c0] == 1);
        if (r0 == r1 && c0 == c1) {
            return new Node(b, true, null, null, null, null);
        }
        if (sameValues(r0, r1, c0, c1, grid)) {
            return new Node(b, true, null, null, null, null);
        }
        Node root = new Node(false, false, null, null, null, null);
        int rMid = (r0 + r1) / 2;
        int cMid = (c0 + c1) / 2;
        root.topLeft = makeNode(r0, rMid, c0, cMid, grid);
        root.bottomLeft = makeNode(rMid+1, r1, c0, cMid, grid);
        root.topRight = makeNode(r0, rMid, cMid + 1, c1, grid);
        root.bottomRight = makeNode(rMid + 1, r1, cMid + 1, c1, grid);
        return root;
    }

    private boolean sameValues(int r0, int r1, int c0, int c1, int[][] grid) {
        int v0 = grid[r0][c0];
        for (int i = r0; i <= r1; i++) {
            for (int j = c0; j <= c1; j++) {
                int v1 = grid[i][j];
                if (v0 != v1) {
                    return false;
                }
            }
        }
        return true;
    }
}
