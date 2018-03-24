public class Solution {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] dp = new int[sentence.length];
        int n = sentence.length;

        for(int i = 0, prev = 0, len = 0; i < sentence.length; i++) {
            if (i != 0 && len > 0) {
            	len -= sentence[i - 1].length() + 1;
            }
            while (len + sentence[prev % n].length() <= cols) {
            	len += sentence[prev++ % n].length() + 1;
            } 
            dp[i] = prev;
        }
        int count = 0;

        for (int i = 0, k = 0; i < rows; i++) {

            // if (dp[k] == k) {
            // 	return 0;
            // }

            count += dp[k] - k;
            k = dp[k] % n;
        }
        
        return count / n;
    }
}
