package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    class Interval {
        int start;
        int end;
    }

    public List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> startComparator = (Interval i1, Interval i2) -> {
            return i1.start - i2.start;
        };

        intervals.sort(startComparator);
        List<Interval> res = new ArrayList<>();

        Interval curInterval = null;
        for (Interval interval : intervals) {
            if (curInterval == null) {
                curInterval = interval;
            } else {
                int curEnd = curInterval.end;
                if (interval.start <= curEnd) {
                    curEnd = Math.max(curEnd, interval.end);
                } else {
                    res.add(curInterval);
                    curInterval = null;
                }
            }
        }
        return res;
    }

}
