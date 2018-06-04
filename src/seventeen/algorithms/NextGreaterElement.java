package seventeen.algorithms;

import java.util.*;
import java.util.LinkedList;

public class NextGreaterElement {

    int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> valToNextGreater = new HashMap<>();
        Deque<Integer> prevElements = new LinkedList<>();

        for (int n : nums) {
            while (!prevElements.isEmpty() && n > prevElements.peek()) {
                int prevElt = prevElements.pop();
                valToNextGreater.put(prevElt, n);
            }
            prevElements.push(n);
        }

        int len = findNums.length;
        int[] nextInts = new int[len];
        for (int i = 0; i < len; i++) {
            int elt = findNums[i];
            nextInts[i] = valToNextGreater.getOrDefault(elt, -1);
        }

        return nextInts;
    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();

        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] nextInts = nge.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(nextInts));
    }
}
