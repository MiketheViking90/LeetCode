package archive.algorithms;

public class VerifyPreorderSerializationBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        return verifyPreorder(preorder, 0, 1);
    }

    private boolean verifyPreorder(String preorder, int prev, int cur) {
        int preVal = preorder.charAt(prev);
        int curVal = preorder.charAt(cur);

        if (preVal == '#' && curVal != '#') {
            return false;
        }
        if (curVal == '#') {

        }

        int rightIndex = getRightIndex(preorder, cur);
        return verifyPreorder(preorder, cur, cur+1) && verifyPreorder(preorder, cur, cur+1);
    }

    private int getRightIndex(String preorder, int cur) {
        while (preorder.charAt(cur) != '#') {
            cur++;
        }

        while (preorder.charAt(cur) == '#') {
            cur++;
        }
        return cur;
    }
}
