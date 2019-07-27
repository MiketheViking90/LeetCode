package algorithms.quadtree;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConstructQuadTreeTest {

    private ConstructQuadTree cqt = new ConstructQuadTree();

    @Test
    public void testConstruct() {
        int[][] grid = {
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},

                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
        };

        Node node = cqt.construct(grid);
        Node.print(node);
    }
}