import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream/0

class KthLargestInStream {

	Queue<Integer> minHeap = new PriorityQueue<>();	

	public static void main (String[] args) {
		KthLargestInStream kl = new KthLargestInStream();
		kl.processStream();
	}

	public void processStream() {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();		
		while (--testCases >= 0) {
			minHeap.clear();
			int k = in.nextInt();
			int n = in.nextInt();
			for (int i = 0; i < n; i++) {
				minHeap.add(in.nextInt());
				checkSizeAndRemove(k);
				System.out.print(getKth(k));
			}	
		}
		in.close;
	}

	public void checkSizeAndRemove(int k) {
		if (minHeap.size() > k) {
			minHeap.poll();
		}
	}

	public int getKth(int k) {
		if (minHeap.size() < k) {
			return -1;
		} else {
			return minHeap.peek();
		}
	}
}