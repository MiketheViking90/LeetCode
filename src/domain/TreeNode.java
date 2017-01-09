package domain;

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
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);

        return root;
    }
}
