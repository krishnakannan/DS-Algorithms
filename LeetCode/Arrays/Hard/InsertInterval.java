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
	int index = 0;
    boolean added = false;

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> newList = new ArrayList<>();
    	int size = intervals.size();
    	for (; index < size; index++) {
    		if (intervals.get(index).end < newInterval.start) {
    			newList.add(new Interval(intervals.get(index).start, intervals.get(index).end));
    		} else {
    			break;
    		}            
    	}	            
        insertAndMerge(intervals, newInterval, newList);
        
    	for (; index < size; index++) {
    		newList.add(intervals.get(index));
    	}
        
        if (!added) {
            newList.add(newInterval);
        }

    	return newList;

    }

    public void insertAndMerge(List<Interval> intervals, Interval newInterval, List<Interval> newList) {
    	Interval mergedInterval = new Interval(newInterval.start, newInterval.end);
        int size = intervals.size();
    	for (; index < size; index++) {
    		if (newInterval.end >= intervals.get(index).start) {
    			mergedInterval.start = min(mergedInterval.start, intervals.get(index).start);
    			mergedInterval.end = max(mergedInterval.end, intervals.get(index).end);
    		} else {
                added = true;
    			newList.add(mergedInterval);
    			break;
    		}
    	}
        if (index == size) {
            added = true;
            newList.add(mergedInterval);
        }
    }

    public int min(int a, int b) {
    	return a < b ? a : b;
    }

    public int max(int a, int b) {
    	return a > b ? a : b;
    }


}