class Solution {
    public String customSortString(String S, String T) {
 		
    	int[] countArr = new int[26];
    	int tLength = T.length();
    	int sLength = S.length();
    	StringBuilder sBuilder = new StringBuilder();

    	for (int i = 0; i < tLength; i++) {
    		countArr[T.charAt(i) - 'a']++;
    	}

    	for (int i = 0; i < sLength; i++) {
    		char c = S.charAt(i);
    		int index = c - 'a';
    		int count = countArr[index];
    		for (int x = 0; x < count; x++) {
    			sBuilder.append(c);
    			countArr[index]--;
    		} 
    	}

    	for (int i = 0; i < 26; i++) {
            int c = i + 'a';                    
    		while (countArr[i] > 0) {                
    			sBuilder.append((char)c);
    			countArr[i]--;
    		}
    	}

    	return sBuilder.toString();
    }
}