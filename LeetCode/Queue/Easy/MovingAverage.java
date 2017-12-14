class MovingAverage {


	Queue<Integer> sQueue;
	Integer maxSize;
	Double average = 0d;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.sQueue = new LinkedList<>();
        this.maxSize = size;
    }
    
    public double next(int val) {
        return getAvg(val);
    }

	public double getAvg(int val) {
		if (sQueue.size() > maxSize) {
			int polled = sQueue.poll();
			average = ((double)((average * maxSize) - polled + val) / (double)maxSize);
			sQueue.add(val);
			return average;
		} else {
			sQueue.add(val);
			average = ((double)((average * sQueue.size()) + val) / (double)sQueue.size());			
			return average;
		}
	}
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */