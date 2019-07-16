package archive.domain;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public void add(int d) {
        add(this, d);
    }

    private TreeNode add(TreeNode root, int d) {
        boolean greaterThan = d > val;
        if (greaterThan) {
            if (root.right == null) {
                root.right = new TreeNode(d);
            } else {
                add(root.right, d);
            }
        } else {
            if (this.left == null) {
                left = new TreeNode(d);
            } else {
                add(root.left, d);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.add(3);


    }

    public static TreeNode makeTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        return root;
    }

    public static void print(TreeNode root) {
        Map<Integer, List<String>> map = new HashMap<>();

        buildLevelMap(map, 0, root);

        for (int lvl : map.keySet()) {
            List<String> vals = map.get(lvl);
            System.out.println(Arrays.toString(vals.toArray()));
        }
    }

    private static void buildLevelMap(Map<Integer, List<String>> map, int level, TreeNode root) {
        List<String> curLevel = map.getOrDefault(level, new ArrayList<>());

        if (root == null) {
            curLevel.add("/");
            map.put(level, curLevel);
            return;
        }
        curLevel.add(String.valueOf(root.val));
        map.put(level, curLevel);

        buildLevelMap(map, level + 1, root.left);
        buildLevelMap(map, level + 1, root.right);
    }

}
