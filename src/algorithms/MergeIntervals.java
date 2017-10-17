package algorithms;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    @ToString
    public static class Interval {
        int start;
        int end;

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> startComparator = (Interval i1, Interval i2) -> {
            return i1.start - i2.start;
        };

        if (intervals.si)
        intervals.sort(startComparator);
        List<Interval> res = new ArrayList<>();

        Interval curInterval = null;
        for (Interval interval : intervals) {
            if (curInterval == null) {
                curInterval = interval;
            } else {
                int curEnd = curInterval.end;
                if (interval.start <= curEnd) {
                    curInterval.end = Math.max(curEnd, interval.end);
                } else {
                    res.add(curInterval);
                    curInterval = interval;
                }
            }
        }
        res.add(curInterval);
        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        MergeIntervals mi = new MergeIntervals();
        List<Interval> res = mi.merge(intervals);
        System.out.println(res);
    }
}
