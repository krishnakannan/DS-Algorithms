import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/check-frequencies/0

class EqualFrequencies {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		EqualFrequencies equalFreqObj = new EqualFrequencies();
		while (--testcases >= 0) {
		    String str = in.next();		
		    System.out.println(equalFreqObj.isPossible(str) ? "1" : "0");
 		}
	}

	public boolean isPossible(String string) {
		Map<Character, Integer> charMap = new HashMap<>();
		int minElement = Integer.MAX_VALUE;
		int minFreq = 0;
		int maxFreq = 0;
		int maxElement = Integer.MIN_VALUE;
		int length = string.length();
		for (int i = 0; i < length; i++) {
			charMap.put(string.charAt(i), charMap.containsKey(string.charAt(i)) ? charMap.get(string.charAt(i)) + 1 : 1);
		}

		for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
			if (minElement == entry.getValue()) {
				minElement = entry.getValue();
				minFreq++;
			} else if (minElement > entry.getValue()) {
				minElement = entry.getValue();
				minFreq = 1;
			}

			if (maxElement == entry.getValue()) {
				maxElement = entry.getValue();
				maxFreq++;
			} else if (maxElement < entry.getValue()) {
				maxElement = entry.getValue();
				maxFreq = 1;
			}			 			
		}
		// System.out.println("MAP    => " + charMap);
		// System.out.println("MINELE => " + minElement);
		// System.out.println("MAXELE => " + maxElement);
		// System.out.println("MINFRQ => " + minFreq);
		// System.out.println("MAXFRQ => " + maxFreq);
		if (minElement < (maxElement - 1)) {
			return false;
		} else if (minFreq < (charMap.size() - 1) && maxFreq < (charMap.size() - 1))  {
			return false;
		} 

		return true;

	}
}