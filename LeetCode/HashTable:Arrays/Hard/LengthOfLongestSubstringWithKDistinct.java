import java.util.*;
import java.lang.*;   
import java.io.*;

class LengthOfLongestSubstringWithKDistinct {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int k = in.nextInt();
		LengthOfLongestSubstringWithKDistinct lolswd = new LengthOfLongestSubstringWithKDistinct();
		System.out.println(lolswd.lengthOfLongestSubstringKDistinct(s, k));
	}

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
    		return 0;
    	}
    	if (s.length() == 0 || s.length() == 1) {
    		return s.length();
    	}
    	

        Map<Character, Integer> countMap = new HashMap<>();
        int right = 0;
        int left = 0;
        int slidingWindow = 0;
        int longestSlidingWindow = Integer.MIN_VALUE;
        char[] string = s.toCharArray();
        while (right < string.length) {
        	countMap.put(string[right], countMap.getOrDefault(string[right], 0) + 1);
        	right += 1;
        	left = advanceLeft(countMap, string, left, right, k);
        	slidingWindow = right - left;
        	longestSlidingWindow = slidingWindow > longestSlidingWindow ? slidingWindow : longestSlidingWindow;
        }
        return longestSlidingWindow;
    }

    public int advanceLeft(Map<Character, Integer> map, char[] string, int left, int right, int k) {
    	if (k >= map.size()) {
    		return left;
    	} else {
    		while (left < right) {
    			if (k >= map.size()) {
		    		return left;
		    	}		
    			map.put(string[left], map.get(string[left]) - 1);
    			if (map.get(string[left]) == 0) {
    				map.remove(string[left]);
    			}
    			left += 1;
    		}
	   	}
	   	return left;
    }
}