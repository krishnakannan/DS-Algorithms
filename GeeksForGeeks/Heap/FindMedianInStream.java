import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0

class FindMedianInStream {
	
	Queue<Integer> minHeap = new PriorityQueue<>();
	//JAVA 8 Queue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y - x);
	Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer> () {
	    public int compare(Integer a, Integer b) {
	       return b - a;
	    }});

	public static void main (String[] args) {
		FindMedianInStream fm = new FindMedianInStream();
		fm.processStream();
	}

	public void processStream() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
		    int x = in.nextInt();
		    if (maxHeap.isEmpty() || x < maxHeap.peek()) {
		        maxHeap.add(x);
		    } else {
		        minHeap.add(x);
		    }
// 			System.out.println("min " +minHeap);
// 		    System.out.println("max " +maxHeap);
			balanceHeaps();
			System.out.println(getMedian());
			
		}
		in.close();
	}

	public int getMedian() {
		int s1 = minHeap.size();
		int s2 = maxHeap.size();
		if (s1 == s2) {
			return (minHeap.peek() + maxHeap.peek())/ 2;
		} else {
		    if (s1 > s2) {
		        return minHeap.peek();    
		    } else {
		        return maxHeap.peek();
		    }
		}
	}

	public void balanceHeaps() {
		if (maxHeap.size() > (minHeap.size() + 1)) {
			minHeap.add(maxHeap.poll());
		} else if (minHeap.size() > (maxHeap.size() + 1)) {
		    maxHeap.add(minHeap.poll());
		}
	}
}