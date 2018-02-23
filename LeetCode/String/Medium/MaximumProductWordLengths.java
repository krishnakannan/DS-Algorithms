class Solution {

	boolean[] alphabets = new boolean[26];

    public int maxProduct(String[] words) {
 		Arrays.sort(words, new Comparator<String>(){
 			public int compare(String a, String b) {
 				return b.length() - a.length(); 
 			}
 		});       
        
        int maxLen = 0;
        int l1 = 0;
        int l2 = 0;

 		for (int i = 0; i < words.length; i++) {
 			populateAlphabets(words[i]); 			            
 			for (int j = 0; j < words.length; j++) {                  
 				if (checkAlphabets(words[j])) {
 					l1 = words[i].length();
                    l2 = words[j].length();                    
                    int temp = l1 * l2;
                    maxLen = temp > maxLen ? temp : maxLen;
                    break;
 				}
 			}
 		}
 		return maxLen;
    }


    public boolean checkAlphabets(String s) {
    	int sLength = s.length();
    	for (int i = 0; i < sLength; i++) {
    		if (alphabets[s.charAt(i) - 'a']) {
    			return false;
    		}
    	}
    	return true;
    }

    public void populateAlphabets(String s) {
    	Arrays.fill(alphabets, false);
    	int sLength = s.length();
    	for (int i = 0; i < sLength; i++) {
    		alphabets[s.charAt(i) - 'a'] = true;
    	}
    }
}