class MedianFinder {

	//Hold Lower half of the stream
	Queue<Integer> maxHeap;
	//Hold Upper half of the stream
	Queue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        	public int compare(Integer a, Integer b) {
        		return b - a;
        	}
        });

        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
        	maxHeap.add(num);
        } else {
        	if (num > maxHeap.peek()) {
        		minHeap.add(num);
        	} else {
        		maxHeap.add(num);
        	}
        }
        balanceHeaps();
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
        	int v1 = maxHeap.peek();
        	int v2 = minHeap.peek();
        	return (double)(v1 + v2) / 2.0;
        } else {
        	if (maxHeap.size() > minHeap.size()) {
        		return (double)maxHeap.peek(); 
        	} else {
        		return (double)minHeap.peek();
        	}
        }
    }

    public void balanceHeaps() {
    	if (minHeap.size() < maxHeap.size() - 1) {
    		minHeap.add(maxHeap.poll());
    	} else if (maxHeap.size() < minHeap.size() - 1) {
    		maxHeap.add(minHeap.poll());
    	}
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */