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
    public int eraseOverlapIntervals(Interval[] intervals) {
 		Arrays.sort(intervals, new Comparator<Interval>(){
 			public int compare(Interval a, Interval b) {
 				if (a.end == b.end) {
 					return a.start - b.start;
 				}
 				return a.end - b.end;
 			}
 		});    
        
        // for (int i = 0; i < intervals.length; i++) {
        //     System.out.print("[" + intervals[i].start + "," + intervals[i].end + "],");
        // }
        // System.out.println();

 		int left = 0;
 		int right = left + 1;
 		int toDelete = 0;

 		while (right < intervals.length) {
 			if (intervals[left].end > intervals[right].start) {                
 				right++;
 				toDelete++;
                
 			} else {                
 				left = right;
 				right++;
 			}
 		}

 		return toDelete;
    }
}