class DecodeWays {

	//https://leetcode.com/problems/decode-ways/description/
	
	/*
		Similar to the Count ways to reach to of stairs, Count Steps.
	*/
    public int numDecodings(String s) {
    	char[] sArr = s.toCharArray();
    	int length = s.length();
    	int[] dp = new int[length];
    	if (length == 0) {
    		return 0;
    	} else if (length == 1) {
            return sArr[0] != '0' ? 1 : 0; 
        }
        //Base         
        dp[0] = sArr[0] == '0' ? 0 : 1;
        if (sArr[0] == '0') {
        	dp[1] = 0;
        } else {
        	int val = Integer.parseInt(s.substring(0, 2));
        	if (val <= 26) {
        		dp[1] = sArr[1] == '0' ? 1 : 2;	
        	} else {
        	    dp[1] = sArr[1] == '0' ? 0 : dp[0];
        	}
        	
        }
    	
    	for (int i = 2; i < length; i++) {
    		if (sArr[i] != '0') {
    			dp[i] += dp[i - 1];
    		} 
    		int val = Integer.parseInt(s.substring(i-1, i+1));
			if(val <= 26 && val >= 10){
	            dp[i] += dp[i - 2];
	        }    		            
    	}
    	return dp[length - 1];
    }
 }