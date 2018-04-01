public class Solution {
    public boolean checkRecord(String s) {
        int	absent = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
        	if (s.charAt(i) == 'A') {
        		absent++;
        	} else if (s.charAt(i) == 'L') {
        		if (i + 2 < len) {
        			if (s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
        				return false;
        			}
        		}
        	}
        }
        return absent > 1 ? false : true;    
    }
}