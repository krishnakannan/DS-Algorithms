import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0

class NonRepeatingCharStream {
	public static void main (String[] args) {
		NonRepeatingCharStream nrcs = new NonRepeatingCharStream();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    char[] arr = new char[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.next().charAt(0);
		    }
			nrcs.processStream(arr);
			System.out.println();
 		}
	}

	public void processStream(char[] arr) {
		Queue<Character> nonRepeatingQueue = new LinkedList<>();
		char[] frequencyMap = new char[256];

		for (int i = 0; i < arr.length; i++) {
			frequencyMap[(int)arr[i]]++;
			if (frequencyMap[(int)arr[i]] <= 1) {
				nonRepeatingQueue.add(arr[i]);
			} else {
				if (!nonRepeatingQueue.isEmpty() && nonRepeatingQueue.peek() == arr[i]) {
					nonRepeatingQueue.poll();
				}
			}


			//Printing
			boolean isPrinted = false;
			while (!nonRepeatingQueue.isEmpty()) {
				if (frequencyMap[nonRepeatingQueue.peek()] == 1) {
					System.out.print(nonRepeatingQueue.peek() + " ");
					isPrinted = true;
					break;
				} else {
					nonRepeatingQueue.poll();
				}
			}
			if (!isPrinted) {
				System.out.print("-1 ");
			}
		}
	}
}