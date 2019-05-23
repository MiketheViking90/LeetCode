package eighteen.algo;

import seventeen.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        List<String> nums = new ArrayList<>();
        fillNumbers(root, nums, "");
        return sumBinNums(nums);
    }

    private int sumBinNums(List<String> nums) {
        int sum = 0;
        for (String bin : nums) {
            sum += getDecimalRepresentation(bin);
        }
        return sum;
    }

    private int getDecimalRepresentation(String bin) {
        int sum = 0;
        int pow2 = 0;
        for (int i = bin.length() - 1; i >= 0 ; i--) {
            int v = bin.charAt(i) - '0';
            if (v == 1) {
                sum += (int) Math.pow(2, pow2);
            }
        }
        return sum;
    }

    private void fillNumbers(TreeNode root, List<String> nums, String curNum) {
        if (root == null) {
            nums.add(curNum);
            return;
        }

        String num = curNum + root.val;
        fillNumbers(root.left, nums, num);
        fillNumbers(root.right, nums, num);
    }

    public static void main(String[] args) {

    }
}
