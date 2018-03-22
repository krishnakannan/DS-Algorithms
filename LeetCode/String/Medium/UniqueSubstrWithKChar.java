class Solution {

	//Referred Soln

    public int longestSubstring(String s, int k) {
        
    	int max = 0;
    	char[] str = s.toCharArray();
    	for (int i = 1; i <= 26; i++) {
    		int tMax = getLongestSubstring(str, k, i);
    		max = max < tMax ? tMax : max;
    	}

    	return max;
    }

    public int getLongestSubstring(char[] string, int reqRepetition, int reqUniqCharInSubstring) {

    	int max = 0;
    	int left = 0;
    	int right = 0;
    	int[] map = new int[26];
    	int currentUniqInSubstring = 0;
    	int numCharsNoLessThanK = 0;

    	while (right < string.length) {
    		if (currentUniqInSubstring <= reqUniqCharInSubstring) {
    			if (map[string[right] - 'a'] == 0) {
	    			currentUniqInSubstring++;
	    		}
	    		map[string[right] - 'a']++;	
	    		if (map[string[right] - 'a'] == reqRepetition) {
	    			numCharsNoLessThanK++;
	    		}
	    		right++;
    		} else {
    			if (map[string[left] - 'a'] == reqRepetition) {
    				numCharsNoLessThanK--;
    			}
    			map[string[left] - 'a']--;
    			if (map[string[left] - 'a'] == 0) {
	    			currentUniqInSubstring--;
	    		}
                left++;
    		}

    		// For example. There are 3 characters and each character's length is less than K
    		if (currentUniqInSubstring == reqUniqCharInSubstring && currentUniqInSubstring == numCharsNoLessThanK) {
    			max = max < right - left ? right - left : max;
    		}
    	}
    	return max;
    }
}