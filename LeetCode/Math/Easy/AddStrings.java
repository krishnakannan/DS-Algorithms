public class Solution {
    public String addStrings(String num1, String num2) {
        int n1Len = num1.length() - 1;
        int n2Len = num2.length() - 1;
        int carry = 0;
        int temp = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        while (n1Len >=0 || n2Len >= 0) {
        	int v1 = 0;
        	int v2 = 0;
        	if (n1Len >= 0) {
        		v1 = Character.getNumericValue(num1.charAt(n1Len)); 
        	}
        	if (n2Len >= 0) {
        		v2 = Character.getNumericValue(num2.charAt(n2Len));
        	}
        	int t = v1 + v2 + carry;
        	temp = t % 10;
        	carry = t / 10;
        	n1Len--;
        	n2Len--;
        	sb.append(temp);
        }

        if (carry != 0) {
      		sb.append(carry);
        }
        return sb.reverse().toString();    
    }
}