package algorithms;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        int[] ival = intervals[0];
        IntervalTreeNode root = new IntervalTreeNode(ival[0], ival[1]);


        int len = intervals.length;
        for (int i = 1; i < len; i++) {
            ival = intervals[i];
            if (addToTree(root, ival) == null) {
                return false;
            }
        }
        return true;
    }

    private IntervalTreeNode addToTree(IntervalTreeNode node, int[] ival) {
        if (node == null) {
            return new IntervalTreeNode(ival[0], ival[1]);
        }

        int a = ival[0];
        int b = ival[1];
        if (node.inRange(a) || node.inRange(b)) {
            return null;
        }
        if (b > node.max) {
            node.right = addToTree(node.right, ival);
            return node.right;
        } else if (a < node.min) {
            node.left = addToTree(node.left, ival);
            return node.left;
        }
        return null;
    }

    class IntervalTreeNode {
        int min;
        int max;
        IntervalTreeNode left;
        IntervalTreeNode right;

        public IntervalTreeNode(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public boolean inRange(int n) {
            return !(n < min || n > max);
        }
    }
}
