//Referred Solution;

class Solution {
	public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int left = 0;
        int alphaCountInWindow = 0;
        int maxLength = 0;

        for (int right = 0; right < len; right++) {
            alphaCountInWindow = max(alphaCountInWindow, ++count[s.charAt(right) - 'A']);
            while (right - left + 1 - alphaCountInWindow > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = max(alphaCountInWindow, right - left + 1);
        }
        return maxLength;
    }

    public int max(int a, int b) {
    	return a > b ? a : b;
    }

}

/*

	//MY SOLUTION - WRONG

class Solution {
    public int characterReplacement(String s, int k) {
		
    	char[] str = s.toCharArray();
    	int left = 0;
    	int right = 0;
    	int maxLength = 0;
    	int currentLength = 0;

    	while (right < str.length) {
    		if (str[left] == str[right]) {
    			right++;
    		} else {
    			k--;
                //right++;
    			if (k < 0) {    				    				
    				k++;
    				right--;
    				currentLength = right - left + 1;
    				maxLength = maxLength < currentLength ? currentLength : maxLength;
    				left++;    				
    				if (left > 0 && str[left - 1] != str[right]) {
    					k++;
    				}
                    
    			} 
                right++;
    		}
            //System.out.println("Left " + left + " Right " + right);
    	}
        
        currentLength = right - left;
        maxLength = maxLength < currentLength ? currentLength : maxLength;
        
        left = str.length - 1;
        right = str.length - 1;
        
        while (left >= 0) {
    		if (str[left] == str[right]) {
    			left--;
    		} else {
    			k--;
                //right++;
    			if (k < 0) {    				    				
    				k++;
    				left++;
    				currentLength = right - left + 1;
    				maxLength = maxLength < currentLength ? currentLength : maxLength;
    				right--;    				
    				if (right < str.length - 1 && str[right + 1] != str[left]) {
    					k++;
    				}
                    
    			} 
                left--;
    		}
            //System.out.println("Left " + left + " Right " + right);
    	}

        
        currentLength = right - left;
        maxLength = maxLength < currentLength ? currentLength : maxLength;
        
    	return maxLength;
    }
}
	
*/