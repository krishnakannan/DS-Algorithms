public class Solution {
    public String convertToTitle(int n) {
        Character[] alphabets = {' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    	StringBuilder sb = new StringBuilder();
    	while (n != 0) {
    		int x = n;
    		int i = 0;
    		while (x > 26) {
    			x = x % 26 == 0 ? x - 1 : x;
    			x /= 26;
    			i++;
    		}
    		sb.append(alphabets[x]);
    		x = x == 0 ? 1 : x;
    		while(--i >= 0) {
    			x *= 26;
    		}
    		n = n - x;

    	}
    	return sb.toString(); 
    }
}