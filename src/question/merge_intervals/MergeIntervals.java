package question.merge_intervals;

// Given a list of intervals,
// merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

/*
[[1,4], [2,5], [7,9]]

 */

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        for (Interval interval : solution(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        for (Interval interval : solution(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        for (Interval interval : solution(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    public static List<Interval> solution(List<Interval> intervals){
        if(intervals.size() <= 1)
            return intervals;

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedInterval = new ArrayList<>();
        Iterator<Interval> iterator = intervals.iterator();
        Interval interval = iterator.next();

        int start = interval.start;
        int end = interval.end;

        while (iterator.hasNext()){
            interval = iterator.next();

            if(interval.start <= end)
                end = Math.max(interval.end, end);
            else {
                mergedInterval.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }

        mergedInterval.add(new Interval(interval.start, interval.end));

        return mergedInterval;
    }
}

//Sort the intervals on the start time to ensure a.start <= b.start
//If ‘a’ overlaps ‘b’ (i.e. b.start <= a.end), we need to merge them into a new interval ‘c’ such that:
//    c.start = a.start
//    c.end = max(a.end, b.end)
//We will keep repeating the above two steps to merge ‘c’ with the next interval if it overlaps with ‘c’.