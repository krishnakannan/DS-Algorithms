public class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[52];
        boolean hasOdd = false;
        int length = s.length();
        int index = 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
        	index = (int)s.charAt(i);
        	if (index >= 65 && index <= 90) {
        		arr[index - 65]++;
        	} else if (index >= 97 && index <= 122) {
        		arr[index - 97 + 26]++;
        	}
        }

        for (int i = 0; i < 52; i++) {
        	if (arr[i] % 2 != 0) {
        		hasOdd = true;
        		count +=  arr[i] - 1;
        	} else {
        		count += arr[i];
        	}
        }

        if (hasOdd) {
        	count++;
        }

        return count;    
    }
}