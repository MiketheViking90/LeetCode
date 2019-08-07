package algorithms;

import org.testng.annotations.Test;

public class MeetingRooms2Test {

    private MeetingRooms2 mr2 = new MeetingRooms2();

    @Test
    public void testMinMeetingRooms() {
        int[][] intervals = {
                {0, 30},
                {5, 10},
                {15, 20},
        };

        int cnt = mr2.minMeetingRooms(intervals);
        System.out.println(cnt);
    }

}