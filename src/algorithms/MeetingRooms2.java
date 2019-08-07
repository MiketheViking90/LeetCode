package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));

        int cnt = 0;
        for (int[] i : intervals) {
            if (pq.isEmpty()) {
                pq.offer(i);
                cnt++;
            } else {
                int[] j = pq.peek();
                if (ifRoomFree(j, i)) {
                    pq.poll();
                    pq.offer(i);
                } else {
                    pq.offer(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean ifRoomFree(int[] cur, int[] next) {
        return cur[1] <= next[0];
    }
}
