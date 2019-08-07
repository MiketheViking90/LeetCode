package algorithms;

import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceRecordII {
    private final String[] statuses = {"A", "L", "P"};

    public int checkRecord(int n) {
        List<String> records = new ArrayList<>();
        getRecordCombos("", n, records);
        System.out.println(records);
        String a = "asdf";
        return 0;
    }

    private void getRecordCombos(String combo, int n, List<String> combos) {
        if (combo.length() == n) {
            combos.add(combo);
            return;
        }
        for (String status : statuses) {
            getRecordCombos(combo + status, n, combos);
        }
    }
}
