class HitCounter {
    
    class Hit {
        int second;
        int count;
        public Hit(int second, int count) {
            this.second = second;
            this.count = count;
        }
    }

    int totalHits;
    
    public static final int _5MINS = 300;
        
    Queue<Hit> counterQueue;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        counterQueue = new LinkedList<Hit>();
        totalHits = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (counterQueue.isEmpty()) {
            counterQueue.add(new Hit(timestamp, 1));
            totalHits = 1;
        } else {
            if (counterQueue.element().second == timestamp) {
                counterQueue.element().count += 1;
            } else {
                counterQueue.add(new Hit(timestamp, 1));                
            }
            totalHits += 1;
        }        
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {        
        while (!counterQueue.isEmpty() && (timestamp - counterQueue.peek().second) >= _5MINS) {
            Hit hit = counterQueue.poll();
            totalHits -= hit.count;
        }        
        return totalHits;
    }
    
    public void print() {
        for (Hit hit : counterQueue) {
            System.out.println(hit.second + " -> " + hit.count);
        }
        System.out.println();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */