import java.util.*;
import java.lang.*;   
import java.io.*;

class SlidingWindowMedian {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		SlidingWindowMedian swm = new SlidingWindowMedian();
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		int k = in.nextInt();
		double[] medians = swm.medianSlidingWindow(nums, k);
		for (int i = 0; i < medians.length; i++) {
			System.out.print(medians[i] + " ");
		}
		System.out.println();
	}

	Queue<Long> minHeap;
	Queue<Long> maxHeap;

    public double[] medianSlidingWindow(int[] nums, int k) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Long>(){
        	public int compare(Long a, Long b) {
                if (b == a) {
                    return 0;
                } else if (b > a) {
                    return 1;
                }
        		return -1;
        	}
        });
        int left = 0;
        int right = k;
        double[] medians = new double[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < k; i++) {
        	addToHeap((long)nums[i]);
        }
        
        while (right < nums.length) {        	
            //print();
        	medians[index] = getMedian();	
        	removeFromHeap((long)nums[left]);
        	addToHeap((long)nums[right]);
        	right++;
        	left++;
        	index++;            
        }
        //print();
        medians[index] = getMedian();	
        return medians;
    }

    public void addToHeap(Long value) {
    	if (maxHeap.isEmpty()) {
    		maxHeap.add(value);
    	} else {
    		if (value > maxHeap.peek()) {
    			minHeap.add(value);
    		} else {
    			maxHeap.add(value);
    		}
    	}        
    	balanceHeaps();
    }

    public void removeFromHeap(Long value) {
    	boolean removed = minHeap.remove(value);
    	if (!removed) {
    		maxHeap.remove(value);
    	}        
    	balanceHeaps();
    }

    public double getMedian() {
    	if (minHeap.size() == maxHeap.size()) {
    		return (double)(minHeap.peek() + maxHeap.peek()) / 2;
    	} else if (minHeap.size() > maxHeap.size()) {
    		return minHeap.peek();
    	} else {
    		return maxHeap.peek();
    	}
    }

    public void balanceHeaps() {
    	if (minHeap.size() < maxHeap.size() - 1) {
    		minHeap.add(maxHeap.poll());
    	} else if (maxHeap.size() < minHeap.size() - 1) {
    		maxHeap.add(minHeap.poll());
    	}    	
    }
    
    public void print() {
        Queue<Long> minCopy = new PriorityQueue<>(minHeap);
        Queue<Long> maxCopy = new PriorityQueue<>(maxHeap);
        while (!maxCopy.isEmpty()) {
            System.out.print(maxCopy.poll() + " ");
        }
        System.out.print(" | ");
        while (!minCopy.isEmpty()) {
            System.out.print(minCopy.poll() + " ");
        }
        System.out.println();
    }
}