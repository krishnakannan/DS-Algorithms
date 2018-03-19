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
    
    class IntervalIndex {
        Interval interval;
        Integer index;
        Integer rightOf;
        IntervalIndex(Interval interval, Integer index) {
            this.interval = interval;
            this.index = index;
        }
    }
    
    public int[] findRightInterval(Interval[] intervals) {
        
        IntervalIndex[] intervalsWIndexArray = new IntervalIndex[intervals.length];
        
        for (int i = 0; i < intervalsWIndexArray.length; i++) {
            IntervalIndex intervalWIndex =  new IntervalIndex(intervals[i], i);   
            intervalsWIndexArray[i] = intervalWIndex;
        }
        
        
        Arrays.sort(intervalsWIndexArray, new Comparator<IntervalIndex>(){
            public int compare(IntervalIndex a, IntervalIndex b) {
                return a.interval.start - b.interval.start;
            }
        });       

        int[] result = new int[intervals.length];

        for (int i = 0; i < intervalsWIndexArray.length; i++) {
        	intervalsWIndexArray[i].rightOf = binarySearch(intervalsWIndexArray, intervalsWIndexArray[i].interval.end, i + 1, intervals.length - 1);        	
        }

        Arrays.sort(intervalsWIndexArray, new Comparator<IntervalIndex>(){
            public int compare(IntervalIndex a, IntervalIndex b) {
                return a.index - b.index;
            }
        });       
        
        for (int i = 0; i < intervalsWIndexArray.length; i++) {
            result[i] = intervalsWIndexArray[i].rightOf;
        }
        
        return result;
    }
    
    public int binarySearch(IntervalIndex[] intervals, int searchVal, int start, int end) {
        //System.out.println("Search VAl "+ searchVal + " Start " + start + " End " + end);
    	if (start > end) {
    		return -1;
    	}

        int middle = start + ((end - start) / 2);          
        
    	if (start == end) {
            if (intervals[middle].interval.start >= searchVal) {
                return intervals[start].index;    
            } else {
                return -1;    
            }
        }

		

		if (intervals[middle].interval.start >= searchVal) {
			return binarySearch(intervals, searchVal, start, middle);
		} else {
			return binarySearch(intervals, searchVal, middle + 1, end);
		}

    }
}