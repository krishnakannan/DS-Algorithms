class MyCalendarTwo {
	List<int[]> overallBookings;
	List<int[]> overlappedBookings;

    public MyCalendarTwo() {
    	overallBookings = new ArrayList<>();
    	overlappedBookings = new ArrayList<>();    
    }
    
    public boolean book(int start, int end) {

        for (int[] interval : overlappedBookings) {
            if (end > interval[0] && start < interval[1]) {
                return false;  
            } 
        }
        for (int[] interval: overallBookings) {
            if (end > interval[0] && start < interval[1]) {
                overlappedBookings.add(new int[]{Math.max(start, interval[0]), Math.min(end, interval[1])});
            }                    
        }
        overallBookings.add(new int[]{start, end});
        return true;

        
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */