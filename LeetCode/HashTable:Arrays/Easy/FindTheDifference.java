public class Solution {
    public char findTheDifference(String s, String t) {
        int[] alphabets = new int[26];
        int sLength = s.length();
        int tLength = t.length();
        for (int i = 0; i < tLength; i++) {
        	alphabets[Character.getNumericValue(t.charAt(i)) - 10]++;
        }
        
        for (int i = 0; i < sLength; i++) {
        	alphabets[Character.getNumericValue(s.charAt(i)) - 10]--;
        }

        for (int i = 0; i < 26; i++) {
        	if (alphabets[i] > 0) {
        		return (char) (i + 97);
        	}	
        }
        return '\0';
    }
}