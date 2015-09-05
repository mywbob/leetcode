/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
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
 
 /*
 sort interval using start
 then merge them until cannot do it anymore, add to result list
 use comparator interface, i cannot new an interface, the code new a class implement the comparator interface. "anonymous class"
 */
public class Solution {

/*
    public List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) return 0;
                else if (i1.start > i2.start) return 1;
                else return -1;
            }
        });
        
        
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.size() == 0) return res;
        Interval it = null;
        for (int i=0; i<intervals.size(); i++) {
            it = new Interval(intervals.get(i).start, intervals.get(i).end);
            for (int j=i+1; j<intervals.size(); j++) {
                if (it.end >= intervals.get(j).start) {//overlay, merge
                    if (it.end < intervals.get(j).end) {//update
                        it.end = intervals.get(j).end;
                    }
                } else {//start from next
                    res.add(it);
                    i = j-1;
                    break;
                }
            }
        }
        res.add(it);//last one
        
        return res;
    }
 */  
    public List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) return 0;
                else if (i1.start > i2.start) return 1;
                else return -1;
            }
        });
        
        
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

    
    /*
        public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        List<Interval> ret = new ArrayList<>();
        Interval prev = null;
        for (Interval inter : intervals) {
            if (  prev==null || inter.start>prev.end ) {
                ret.add(inter);
                prev = inter;
            } else if (inter.end>prev.end) {
                // Modify the element already in list
                prev.end = inter.end;
            }
        }
        return ret;
    }
    */
}