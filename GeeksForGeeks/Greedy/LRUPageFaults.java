import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/page-faults-in-lru/0

class LRUPageFaults {
	Queue<Integer> memory = null;
	Integer LRUSize = -1;
	int faults = 0;

	
	public static void main (String[] args) {
		LRUPageFaults lpf = new LRUPageFaults();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    Integer[] arr = new Integer[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			lpf.LRUSize = in.nextInt();
			System.out.println(lpf.noOfFaults(arr));
 		}
	}

	public int noOfFaults(Integer[] pages) {
		faults = 0;		
		memory = new LinkedList<>();
		for (int i = 0; i < pages.length; i++) {
			//printLRUCache();
			updateMem(pages[i]);
		}
		return faults;
	}

	public void updateMem(Integer page) {		
		if (memory.isEmpty()) {
			faults++;
			memory.add(page);
		} else {			
			if (memory.contains(page)) {
				memory.remove(page);
				memory.add(page);
			} else {
				if (memory.size() == LRUSize) {
					memory.poll();
				}
				memory.add(page);
				faults++;
			}
		}
	}

	public void printLRUCache() {
		for (Integer page : memory) {
		  System.out.print(page + "->");
		}
		System.out.println();
	}
}