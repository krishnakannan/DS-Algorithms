public class Solution {
    public int findComplement(int num) {
        String binNum = Integer.toBinaryString(num);
        StringBuilder complement = new StringBuilder();
        int length = binNum.length();
        for (int i = 0; i < length; i++) {
        	if (binNum.charAt(i) == '0') {
        		complement.append('1');
        	} else {
        		complement.append('0');
        	}
        }
        return Integer.parseInt(complement.toString(), 2);   
    }
}