package algorithms;

import domain.ListNode;

public class SumLists {

    public int sumLists(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) {
            return 0;
        }

        int sum = 0;
        int power = 0;
        boolean isCarry = false;
        while (n1 != null && n2 != null) {
            int nodeSum = n1.val + n2.val;

            int curDigit = isCarry ? 1 : 0;

            if (nodeSum >= 10) {
                isCarry = true;
                curDigit += (nodeSum - 10);
            } else {
                isCarry = false;
                curDigit += nodeSum;
            }

            sum += (curDigit * Math.pow(10, power));
            power++;

            n1 = n1.next;
            n2 = n2.next;
        }

        if (n1 != null) {
            while (n1 != null) {
                int val = n1.val;
                if (isCarry) {
                    val++;
                }

                if (val >= 10) {
                    isCarry = true;
                    val -= 10;
                } else {
                    isCarry = false;
                }

                sum += (val * (Math.pow(10, power)));
                power++;
                n1 = n1.next;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        SumLists sl = new SumLists();

        ListNode n1 = ListNode.makeList();
        ListNode.append(n1, 6);
        ListNode.append(n1, 7);
        ListNode.append(n1, 8);
        ListNode.append(n1, 9);
        ListNode n2 = ListNode.makeList();

        int sum = sl.sumLists(n1, n2);
    }
}
