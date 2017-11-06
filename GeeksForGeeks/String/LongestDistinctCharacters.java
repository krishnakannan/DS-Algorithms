import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string/0

class LongestDistinctCharacters {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		LongestDistinctCharacters ldc = new LongestDistinctCharacters();
		while (--testcases >= 0) {		    
		    String str = in.next();
			System.out.println(ldc.getLongestDistinctChars(str));
 		}
	}

	public int getLongestDistinctChars(String str) {
		int maxDistinct = 0;
		int distinct = 0;
		char[] sArr = str.toCharArray();
		int oldIndex = -1;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < sArr.length; i++) {
			if (map.containsKey(sArr[i])) {				
				oldIndex = oldIndex < map.get(sArr[i]) ? map.get(sArr[i]) : oldIndex;
				map.put(sArr[i], i);				
				distinct = i - oldIndex;
			} else {
				oldIndex = oldIndex == -1 ? i : oldIndex;
				map.put(sArr[i], i);
				distinct++;
			}				
			maxDistinct = maxDistinct < distinct ? distinct : maxDistinct;		
			//System.out.println("Char = " + sArr[i] + " Old Index " + oldIndex + " Distinct = " + distinct + " maxDistinct " + maxDistinct + " MAP " + map);
		}
		return maxDistinct;
	}
}