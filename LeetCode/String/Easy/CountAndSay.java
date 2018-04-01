public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
    	StringBuilder sb = new StringBuilder(Integer.toString(1));
    	for (int i = 1; i < n; i++) {
    		int slen = sb.length();
    		int count = 1;
    		StringBuilder temp = new StringBuilder();
    		for (int j = 0; j < slen; j++) {
    			if (j + 1 < slen && sb.charAt(j) == sb.charAt(j + 1)) {
    				count++;
    			} else {
    				temp.append(count);
    				temp.append(sb.charAt(j));
    				count = 1;
    			}
    		}
    		sb.setLength(0);
    		sb.append(temp);
    	}    	
    	return sb.toString();
    }
}