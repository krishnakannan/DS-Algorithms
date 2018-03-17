import java.util.*;
import java.lang.*;
import java.io.*;

class ReOrganizeString {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		ReOrganizeString ros = new ReOrganizeString();
		System.out.println(ros.reorganizeString(s));
	} 


    public String reorganizeString(String S) {
		
    	Map<Character, Integer> frequency = new HashMap<>();    	
    	char[] str = S.toCharArray();
    	char[] newStr = new char[str.length];

    	for (Character c : str) {
    		frequency.put(c, frequency.containsKey(c) ? frequency.get(c) + 1 : 1);
    	}

    	Queue<Map.Entry<Character, Integer>> pQueue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
    		public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
    			if (b.getValue() == a.getValue()) {
    				return (int)(a.getValue() - b.getValue());
    			} 
    			return b.getValue() - a.getValue();
    		}
    	});


    	for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
    		if (entry.getValue() > (str.length / 2) + 1) {
    			return "";
    		}
    		pQueue.add(entry);
    	}

    	int index = 0;    	

    	while (pQueue.size() >= 2) {
    		Map.Entry<Character, Integer> entryOne = pQueue.poll();
    		Map.Entry<Character, Integer> entryTwo = pQueue.poll();
    		int f1 = entryOne.getValue();
    		int f2 = entryTwo.getValue();
    		newStr[index] = entryOne.getKey();
    		index++;
    		newStr[index] = entryTwo.getKey();
    		index++;
    		f1 -= 1;
    		f2 -= 1; 
    		if (f1 > 0) {
    			entryOne.setValue(f1);
    			pQueue.add(entryOne);
    		}
    		if (f2 > 0) {
    			entryTwo.setValue(f2);
    			pQueue.add(entryTwo);
    		}    		
    	}

    	if (!pQueue.isEmpty()) {
    		Map.Entry<Character, Integer> entry = pQueue.poll();
    		if (entry.getValue() > 1) {
    			return "";
    		} else {
    			newStr[index] = entry.getKey();
    		}
    	}

    	return new String(newStr);
    }
}