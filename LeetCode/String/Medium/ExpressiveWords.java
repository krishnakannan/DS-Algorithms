class Solution {
    public int expressiveWords(String S, String[] words) {
 		
    	int sRight = 0;
    	int sLeft = 0;
    	int wLeft = 0;
    	int wRight = 0;
    	char[] string = S.toCharArray();
    	int expressiveWords = 0;
    	for (String wordStr : words) {
    		sLeft = 0;
    		sRight = 0;
    		wLeft = 0;
    		wRight = 0;
    		char[] word = wordStr.toCharArray();    		
    		if (word.length > string.length || word.length == 0) {
    			continue;
    		} else {								
                boolean isExpressive = true;
                
				while (sRight < string.length && wRight < word.length) {
                    //System.out.println("Processing " + string[sRight] + "  " + word[wRight]);
					if (string[sLeft] != word[wLeft]) {					
                        isExpressive = false;
						break;
					}
					while (sRight < string.length - 1) {
	    				if (string[sRight] == string[sRight + 1]) {
	    					sRight++;
	    				} else {
                            break;
                        }
	    			}

	    			while (wRight < word.length - 1) {
	    				if (word[wRight] == word[wRight + 1]) {
	    					wRight++;
	    				} else {
                            break;
                        }
	    			}

	    			int sGroupLength = sRight - sLeft + 1;
	    			int wGroupLength = wRight - wLeft + 1;
	    			if (sGroupLength < wGroupLength) {
                        isExpressive = false;
	    				break;
	    			}

	    			if (sGroupLength <= 2) {                        
                        if (sGroupLength != wGroupLength) {
                            isExpressive = false;
                        }	    				
	    			} 
	    			sLeft = sRight + 1;
	    			wLeft = wRight + 1;
	    			sRight = sLeft;
	    			wRight = wLeft;
				}
                if (isExpressive && sRight == string.length) {
                    expressiveWords++;
                }
    		}
    	}

    	return expressiveWords;
    }
}