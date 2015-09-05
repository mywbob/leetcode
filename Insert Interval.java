/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) return 0;
                else if (i1.start > i2.start) return 1;
                else return -1;
            }
        });
        
        return merge(intervals);
        
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.size() == 0) return res;
        Interval prev = null;
        for (int i=0; i<intervals.size(); i++) {
            Interval inter = intervals.get(i);
            if (prev==null || inter.start>prev.end ) {
                res.add(inter);
                prev = inter;
            } else if (inter.end>prev.end) {
                prev.end = inter.end;
            }

        }
        
        
        return res;
    }
}