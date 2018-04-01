public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // String binString = toBinary(n);
        // int length = binString.length();
        // int count = 0;
        // for (int i = 0; i < length; i++) {
        // 	if (binString.charAt(i) == '1') {
        // 		count++;
        // 	}
        // }
        // return count;
        return Integer.bitCount(n);
    }
    
    public String toBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
        	sb.append(Integer.toString(n % 2));
        	n /= 2;
        }
        return sb.reverse().toString();
    }
}