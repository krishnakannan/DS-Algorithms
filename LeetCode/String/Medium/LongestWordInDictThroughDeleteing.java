public class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d);
        String maxWord = "";
        int p1len = s.length();
        for (String word : d) {
			int p2len = word.length();			
        	int index = 0;        	
	        for (int i = 0; i < p1len && index < p2len; i++) {
	            if (s.charAt(i) == word.charAt(index)) {
	                index++;	                
	                if (index == p2len) {
	                    if (maxWord.length() < word.length()) {
	                    	maxWord = word;
	                    }
	                }
	            }
	        }
        }

        return maxWord;
    }
}