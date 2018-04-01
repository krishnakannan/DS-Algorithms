public class Solution {
    public boolean detectCapitalUse(String word) {
        int length = word.length();
        int capCount = 0;
        int pos = 0;
        for (int i = 0; i < length; i++) {
        	if ((int)word.charAt(i) >= 65 && (int) word.charAt(i) < 91) {
        		capCount++;
                pos = i;
        	}
        }
        if (capCount == 0 || (capCount == 1 && pos == 0) || capCount == length) {
        	return true;
        } 

        return false;
    }
}