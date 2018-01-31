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
    public List<Interval> merge(List<Interval> intervals) {
 		Collections.sort(intervals, new Comparator<Interval>(){
 			public int compare(Interval a, Interval b) {
 				return a.start - b.start;
 			}
 		});       
 		List<Interval> mergedInterval = new ArrayList<>();
 		Stack<Interval> stack = new Stack<>();
 		for (Interval interval : intervals) {
 			if (stack.isEmpty()) {
 				Interval currentInterval = new Interval(interval.start, interval.end);
 				stack.push(currentInterval);
 			} else {
 				Interval currentInterval = stack.peek();
 				if (interval.start <= currentInterval.end) {
 					if (interval.end <= currentInterval.end) {
 						continue;
 					} else {
 						currentInterval.end = interval.end;
 					} 					
 				}  else { 					
 					stack.push(new Interval(interval.start, interval.end));
 				}
 			}
 		}

 		while (!stack.empty()) {
 			mergedInterval.add(stack.pop());
 		}
        Collections.reverse(mergedInterval);
 		return mergedInterval;
    }
}