public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int a) {
        long n = a & 0xffffffffl;
		StringBuilder sb = new StringBuilder();
    	while (n > 0) {
    		sb.append(n % 2);
    		n /= 2;
    	}
		int length = sb.length();

    	for (int i = length; i < 32; i++) {
    		sb.append('0');
    	}

    	long x = 1;
    	long ans = 0;
    	for (int i = 31; i >= 0; i--) {
    		ans += x * Character.getNumericValue(sb.charAt(i));
    		x *= 2;
    	}
    	return (int)ans;    
    }
}