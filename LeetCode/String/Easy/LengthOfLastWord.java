public class Solution {
    public int lengthOfLastWord(String s) {
        int sLength = s.length();
    	int retLength = 0;
    	boolean isFirstWord = true;

    	for (int i = sLength - 1; i >= 0; i--) {
    		if (s.charAt(i) == ' ') {
    			if (isFirstWord) {
    				continue;	
    			} else {
    				return retLength;
    			}
    			
    		} else {
    			isFirstWord = false;
    			retLength++;
    		}
    	}

    	return retLength;
    }
}