public class Solution {
    //Borrowed From GeeksForGeeks
    public String addBinary(String a, String b) {
        int aLen = a.length();
    	int bLen = b.length();
    	if (aLen < bLen) {
        	for (int i = 0 ; i < bLen - aLen ; i++)
            	a = '0' + a;
    	} else if (aLen > bLen) {
        	for (int i = 0 ; i < aLen - bLen ; i++)
            	b = '0' + b;
    	}

    	StringBuilder result = new StringBuilder();
    	int nlen = a.length();
    	int carry = 0;

    	for (int i = nlen - 1; i >= 0; i--) {
        	int firstBit = Character.getNumericValue(a.charAt(i));
        	int secondBit = Character.getNumericValue(b.charAt(i));
        	int sum = (firstBit ^ secondBit ^ carry);
        	result.append(sum);
        	carry = (firstBit & secondBit) | (secondBit & carry) | (firstBit & carry);
    	}

    	if (carry > 0)
        	result.append(carry);

    	return result.reverse().toString();

    }
}