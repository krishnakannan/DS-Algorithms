class ExamRoom {
    
    TreeSet<Integer> occupiedLocations;
    int max;
    public ExamRoom(int N) {
        occupiedLocations = new TreeSet<>();        
        max = N - 1;
    }
    
    public int seat() {
        
        if (occupiedLocations.size() == 0) {
            occupiedLocations.add(0);
            return 0;
        } else if (occupiedLocations.size() == 1 && occupiedLocations.contains(0)) {
            occupiedLocations.add(max);            
            return max;
        } else {
            int maxDist = 0;
            int idealLocation = 0;
            Integer prev = 0;
            if (!occupiedLocations.contains(0)) {
                int next = occupiedLocations.higher(0);                
                maxDist = next - 0;
                idealLocation = 0;
            }            
            for (Integer occupiedLocation : occupiedLocations) {
                prev = occupiedLocations.lower(occupiedLocation);
                if (prev == null) {
                    prev = occupiedLocation;
                }
                int mid = prev + (occupiedLocation - prev) / 2;
                int dist = Math.min(diff(prev, mid), diff(occupiedLocation, mid));                
                if (dist > maxDist) {
                    maxDist = dist;                    
                    idealLocation = ((occupiedLocation - prev) / 2) + prev;
                }
            }
            
            if (!occupiedLocations.contains(max)) {                
                int sMax = occupiedLocations.lower(max);                
                int dist = max - sMax;
                if (dist > maxDist) {
                    maxDist = dist;
                    idealLocation = max;    
                }
            }
            
            occupiedLocations.add(idealLocation);
            return idealLocation;
        }
        
    }
    
    public void leave(int p) {
        occupiedLocations.remove(p);
    }
    
    public int diff(int a, int b) {
        return a > b ? a - b : b - a;
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */