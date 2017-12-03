import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/rearrange-characters/0

class RearrangeCharacters {

	public class Entry{
		Character key;
		Integer value;
		Integer counter;
		public Entry(){};
		public Entry(Character key, Integer value, Integer counter) {
			this.key = key;
			this.value = value;
			this.counter = counter;
		}
	}

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		RearrangeCharacters reChars = new RearrangeCharacters();
		while (--testcases >= 0) {
		    String str = in.next();		
		    System.out.println(reChars.isPossibleToRearrange(str) ? "1" : "0");
 		}
	}

	public boolean isPossibleToRearrange(String s) {

		//Declare Required Datastructures.
		StringBuilder sBuilder = new StringBuilder();
		Queue<Entry> pQueue = new PriorityQueue<>(new Comparator<Entry>(){
			public int compare(Entry a, Entry b) {
				if (a.value == b.value) {
					return b.counter - a.counter;
				}
				return b.value - a.value;
			}
		});
		Queue<Entry> evictedQueue = new LinkedList<>();		
		Map<Character, Integer> map = new HashMap<>();
		char[] sArray = s.toCharArray();
		int counter = 1;


		//Populate the Frequency Map
		for (int i = 0; i < sArray.length; i++) {
			map.put(sArray[i], map.containsKey(sArray[i]) ? map.get(sArray[i]) + 1 : 1);
		}
		//Push the values into the Heap
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			pQueue.add(new Entry(entry.getKey(), entry.getValue(), counter));
			counter++;
		}

		//Process Heap
		while (!pQueue.isEmpty()) {
			Entry evicted = pQueue.poll();			
			sBuilder.append(evicted.key);
			evicted.value = evicted.value - 1;
			evicted.counter++;
			if (evicted.value >= 1) {
				evictedQueue.add(evicted);
			} else if (!evictedQueue.isEmpty()){
				pQueue.add(evictedQueue.poll());
			}
			
			//printQueue(evictedQueue);
			
			if (evictedQueue.size() > 1) {								
				pQueue.add(evictedQueue.poll());
			}
		}
		
		
		//Analyse the Result
		if (pQueue.isEmpty() && !evictedQueue.isEmpty()) {
			if (evictedQueue.size() != 1) {
				return false;
			} else if (evictedQueue.size() == 1 && evictedQueue.peek().value > 1) {				
				return false;
			} else {
				if (sBuilder.charAt(sBuilder.length() - 1) != evictedQueue.peek().key) {
					sBuilder.append(evictedQueue.peek().key);					
					return true;	
				} else {
					return false;
				}
				
			}
		} else if (pQueue.isEmpty() && evictedQueue.isEmpty()) {			
			return true;
		}

		return false;
		
	}

	public void printQueue(Queue<Entry> queue) {
		for (Entry entry : queue) {
			System.out.print(entry.key + "=>" + entry.value);
		}
		System.out.println();
	}
}