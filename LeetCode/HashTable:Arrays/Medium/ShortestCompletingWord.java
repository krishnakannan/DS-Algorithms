class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
    	int[] lpArray = tokenize(licensePlate);
    	int minLength = Integer.MAX_VALUE;
    	String shortestCompletingWord = "";
    	for (String word : words) {
    		int[] wArray = tokenize(word);
    		if (minLength > word.length()) {           
    			if (isCompleting(lpArray, wArray)) {                    
    				minLength = word.length();
    				shortestCompletingWord = word;
    			}
                //System.out.println("MinLen " + minLength + " currnet Word " + word);
    		}
    	}
    	return shortestCompletingWord;
    }

    public int[] tokenize(String str) {
    	int[] tokens = new int[26];
    	int sLength = str.length();
    	for (int i = 0; i < sLength; i++) {
            char c = str.charAt(i);            
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                int index = Character.toLowerCase(c) - 'a';                    
                //System.out.println(c + " " + (Character.toLowerCase(c) - 'a')) ;
    		    tokens[index]++;
            }    		
    	}        
    	return tokens;
    }

    public boolean isCompleting(int[] lpArray, int[] wArray) {
    	for (int i = 0; i < 26; i++) {
    		if (lpArray[i] > wArray[i]) {
    			return false;
    		}
    	}
    	return true;
    }
}