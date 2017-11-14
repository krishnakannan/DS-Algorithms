class NumberOfUniqueDigits {
	/*
		Idea is to find number of unique digits by going from left most digit. 
		If left most can have 10 (Omit 0 so 9) unique digits, then leftmost - 1 can have 10 - 1 digits.
		for example if n = 4. Total number is 10000. for 1000-9999 we can follow the above method to find the unique ways. 
		Then we should add the n-1(3 digits) till n - (n - 1). Memoize it.
	*/

//https://leetcode.com/problems/count-numbers-with-unique-digits/description/

		
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
        	dp[i] = 1;
        }
        if (n == 0) {
        	return 0;
        }
        //Basecase
        dp[1] = 10;    
        for (int i = 2; i <= n; i++) {
        	int leftMost = 10 - 1;        	
        	int digits = i;
        	while (--digits >= 1 && leftMost >= 1 && i <= 10) {
        		if (leftMost == 9) {
        			dp[i] *= leftMost * leftMost;	
        		} else {
        			dp[i] *= leftMost;
        		}
        		leftMost--;        		
        	}
            //After 10 unique digits there is no way we can generate any number with unique digits
        	dp[i] = i <= 10 ? dp[i] + dp[i - 1] : dp[i - 1];
        }

        for(int i = 0; i <= n; i++) {
            System.out.println(dp[i]);
        }
        return dp[n];
    }
}