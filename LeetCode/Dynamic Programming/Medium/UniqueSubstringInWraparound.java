//https://leetcode.com/problems/unique-substrings-in-wraparound-string/description/

class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int maxCurrentLength = 0;
        char[] pArr = p.toCharArray();
        int sum = 0;
        for (int i = 0; i < pArr.length; i++) {
        	if (i > 0 && (pArr[i] - pArr[i - 1] == 1 ||  pArr[i - 1] - pArr[i] == 25)) {
        		maxCurrentLength++;
        	} else {
        		maxCurrentLength = 1;
        	}
        	int index = pArr[i] - 'a';
        	dp[index] = max(dp[index], maxCurrentLength);
        }

        for (int i = 0; i < 26; i++) {
        	sum += dp[i];
        }
        return sum;
    }

    public int max (int a, int b) {
    	return a > b ? a : b;
    }
}