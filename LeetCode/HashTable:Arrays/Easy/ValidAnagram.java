public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        int sLen = s.length();
		int tLen = t.length();
        for (int i = 0; i < sLen; i++) {
        	arr[Character.getNumericValue(s.charAt(i)) - 10]++;

        }
        for (int i = 0; i < tLen; i++) {
        	arr[Character.getNumericValue(t.charAt(i)) - 10]--;
        }
        for (int i = 0; i < 26; i++) {        	
        	if (arr[i] != 0) {
        		return false;
        	}
        }
        return true;
    }
}