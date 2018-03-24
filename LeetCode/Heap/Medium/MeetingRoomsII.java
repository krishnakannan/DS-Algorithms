/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {     
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        PriorityQueue<Interval> pQueue = new PriorityQueue<Interval>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        
        int roomsRequired = 1;
        
        int left = 0;
        int right = left + 1;
        
        pQueue.add(intervals[0]);        
        
        for (int i = 1; i < intervals.length; i++) {
            
            Interval interval = pQueue.poll();
            
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                pQueue.add(intervals[i]);
            }
            
            pQueue.add(interval);
            
        }
        
        return pQueue.size();
    }
}