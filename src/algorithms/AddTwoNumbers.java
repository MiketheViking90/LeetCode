package algorithms;

import seventeen.domain.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode n1, ListNode n2) {
        boolean carry = false;
        ListNode sum = null;
        ListNode sumCur = sum;

        while (n1 != null && n2 != null) {
            int val = carry ? 1 : 0;
            carry = false;

            val += (n1.val + n2.val);

            if (val >= 10) {
                val -= 10;
                carry = true;
            }

            if (sum == null) {
                sum = new ListNode(val);
                sumCur = sum;
            } else {
                sumCur.next = new ListNode(val);
                sumCur = sumCur.next;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        if (n1 != null || n2 != null) {
            ListNode tail = n1 != null ?  n1 : n2;

            while (tail != null) {
                int val = carry ? 1 : 0;
                carry = false;
                val += tail.val;

                if (val >= 10) {
                    val -= 10;
                    carry = true;
                }

                sumCur.next = new ListNode(val);
                sumCur = sumCur.next;

                tail = tail.next;
            }
        }

        if (carry) {
            sumCur.next = new ListNode(1);
        }

        return sum;
    }

}
