import java.util.*;
import java.lang.*;   
import java.io.*;

class LongestSubstringWithAtmostTwoDistinct {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		LongestSubstringWithAtmostTwoDistinct lswatd = new LongestSubstringWithAtmostTwoDistinct();
		System.out.println(lswatd.lengthOfLongestSubstringTwoDistinct(s));
	}

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] string = s.toCharArray();
        int longestSubString = 0;

        while (right < string.length) {        	
        	map.put(string[right], map.containsKey(string[right]) ? map.get(string[right]) + 1 : 1);
        	right++;

        	while (map.size() > 2) {
        		if (map.containsKey(string[left]) && map.get(string[left]) > 0) {
        			map.put(string[left], map.get(string[left]) - 1);
        		}
        		if (map.get(string[left]) == 0) {
        			map.remove(string[left]);
        		}
        		left++;
        	}
        	System.out.println(map);
        	int length = right - left;
        	longestSubString = length > longestSubString ? length : longestSubString;
        }
        return longestSubString;
    }
}