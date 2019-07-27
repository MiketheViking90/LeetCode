package algorithms;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MeetingRoomsTest {

    MeetingRooms mr = new MeetingRooms();

    @Test
    public void testCanAttendMeetings() {
        int[][] intervals = {
                {7, 10},
                {2, 4},
        };

        boolean b = mr.canAttendMeetings(intervals);
        System.out.println(b);
    }
}