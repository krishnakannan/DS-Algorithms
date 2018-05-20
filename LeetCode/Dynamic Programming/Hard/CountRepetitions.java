class Solution {
    
    int currentIndex = 0;
    int indexLimit;
    int[] dp;
    public int getMaxRepetitions(String str1, int n1, String str2, int n2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();        
        
        //Optimizations
        if (str1.contains(str2)) {
            boolean sameCharS2 = true;
            for (int i = 1; i < s2.length; i++) {
                if (s2[i] != s2[i - 1]) {
                    sameCharS2 = false;
                    break;
                }
            }
            boolean sameCharS1 = true;
            for (int i = 1; i < s1.length; i++) {
                if (s1[i] != s1[i - 1]) {
                    sameCharS1 = false;
                    break;
                }
            }
            if (sameCharS1 && sameCharS2) {
                long s1len = (long)s1.length * (long)n1;
                long s2len = (long)s2.length * (long)n2;
                long res = s1len / s2len;
                return (int) res;
            }
        }
        dp = new int[s1.length];
        int count = 0;                
        indexLimit = s1.length * n1;
        while (currentIndex < indexLimit) {
            if (scanForS2(s1, s2)) {
                count += 1;
            }                           
        }        
        return count / n2;
    }
    
    public boolean scanForS2(char[] str1, char[] str2) {        
        
        int startIndex = currentIndex % str1.length;
        int currentStart = currentIndex;
        //System.out.println("Current " + currentIndex + " StartIndex "+ startIndex);
        if (dp[startIndex] != 0) {
           // System.out.println("DP[" + startIndex + "] = " + dp[startIndex]);
            currentIndex += dp[startIndex];
            return currentIndex <= indexLimit;
        }
        
        int index = currentIndex % str1.length;
        int searchIndex = 0;
        while (currentIndex < indexLimit) {
            if (str2[searchIndex] == str1[index]) {
                searchIndex += 1;
            }
            if (searchIndex == str2.length) {                                                                
                currentIndex += 1;                                
                dp[startIndex] = currentIndex - currentStart;
                return true;
            }
            
            index += 1;
            currentIndex += 1;
            if (index == str1.length) {
                index = 0;
            }            
        }
        return false;
    }
}