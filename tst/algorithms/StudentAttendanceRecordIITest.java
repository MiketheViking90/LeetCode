package algorithms;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StudentAttendanceRecordIITest {

    StudentAttendanceRecordII sar = new StudentAttendanceRecordII();

    @Test
    public void testCheckRecord() {
        sar.checkRecord(3);
    }
}