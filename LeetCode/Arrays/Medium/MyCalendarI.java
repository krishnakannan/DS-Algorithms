class MyCalendar {

    List<int[]> bookings;
    
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {        
        
        if (bookings.isEmpty()) {
            bookings.add(new int[]{start, end});
            return true;
        } else if (bookings.size() == 1 && start >= bookings.get(0)[1]) {
            bookings.add(new int[]{start, end});
            return true;
        }
                               
        if (end <= bookings.get(0)[0]) {
            bookings.add(0, new int[]{start, end});
            return true;    
        }
        
        int bookingsCount = bookings.size();
        for (int i = 1; i < bookingsCount; i++) {            
            if (i == bookingsCount - 1 && start >= bookings.get(i)[1]) {                
                bookings.add(new int[]{start, end});
                return true;
            } else if (start >= bookings.get(i - 1)[1] && end <= bookings.get(i)[0]) {
                bookings.add(i, new int[]{start, end});
                return true;
            }            
        }                
        return false;
    }    
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */