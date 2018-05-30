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
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
 		Queue<List<Interval>> heap = new PriorityQueue<>(new Comparator<List<Interval>>(){
 			public int compare(List<Interval> a, List<Interval> b) {
 				if (a.get(0).start == b.get(0).start) {
 					return a.get(0).end - b.get(0).end;
 				}
 				return a.get(0).start - b.get(0).start;
 			}
 		}); 

 		for (List<Interval> intervals : schedule) {
 			heap.add(new ArrayList<>(intervals));
 		}

 		List<Interval> merged = new ArrayList<>();
 		List<List<Interval>> tempList = new ArrayList<>();

 		while (!heap.isEmpty()) {
 			List<Interval> localMerge = new ArrayList<>();
 			List<Interval> prevList = heap.poll();
 			Interval prev = prevList.get(0);
 			prevList.remove(0);
 			if (!prevList.isEmpty()) {
 				tempList.add(prevList);	
 			} 			
 			while (!heap.isEmpty()) {
 				List<Interval> currentList = heap.poll();
 				Interval current = currentList.get(0);
 				currentList.remove(0);	
 				if (!currentList.isEmpty()) {
 					tempList.add(currentList);
 				}
 				if (prev.end >= current.start) {
                    if (prev.start > current.start) {
                        prev.start = current.start;
                    }
 					if (prev.end < current.end) {
 						prev.end = current.end;
 					}
 				} else {
 					localMerge.add(copyOf(prev));
 					prev = current;
 				}	
 			}            
 			localMerge.add(copyOf(prev));
            //printIntervals(localMerge);
 			merged.addAll(localMerge);
 			heap.addAll(tempList);
 			tempList.clear();
 		}
        
        List<Interval> processedMerge = processMerge(merged);

        // printIntervals(merged);
        // printIntervals(processedMerge);
        
        List<Interval> freeTime = new ArrayList<>();
        for (int i = 1; i < processedMerge.size(); i++) {
            freeTime.add(new Interval(processedMerge.get(i - 1).end, processedMerge.get(i).start));
        }
 		return freeTime;
    }
    
    public List<Interval> processMerge(List<Interval> merged) {        
        Collections.sort(merged, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
 				if (a.start == b.start) {
 					return a.end - b.end;
 				}
 				return a.start - b.start;
 			}
        });        
        List<Interval> processed = new ArrayList<>();
        Interval prev = merged.get(0);
        for (int i = 1; i < merged.size(); i++) {
            Interval current = merged.get(i);
            if (prev.end >= current.start) {
                if (prev.start > current.start) {
                    prev.start = current.start;
                }
                if (prev.end < current.end) {
                    prev.end = current.end;
                }
            } else {
                processed.add(copyOf(prev));
                prev = current;
            }	
        }
        processed.add(copyOf(prev));
        return processed;
    }    

    public void printIntervals(List<Interval> intervals) {
    	for (Interval interval : intervals) {
    		System.out.print("[" + interval.start + ", " + interval.end + "] ");
    	}
    	System.out.println();
    }

    public Interval copyOf(Interval interval) {
    	return new Interval(interval.start, interval.end);
    }
}