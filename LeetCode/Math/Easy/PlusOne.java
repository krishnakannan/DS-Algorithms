public class Solution {
    public int[] plusOne(int[] digits) {
       int nLength = 0;
		int length = digits.length - 1; 
        if (digits[0] == 9) {
        	nLength = length + 1;
        } else {
			nLength = length;
        }
        List<Integer> out = new ArrayList<>();
        int carry = 1;
        for (int i = length; i >= 0; i--) {
        	int temp = carry + digits[i];
        	out.add(temp % 10);
        	carry = temp / 10;
        }

        if (carry > 0) {
        	out.add(carry);
        }
        int[] outArr = new int[out.size()];
        int index = 0;
        for (int i = out.size() - 1; i >= 0 ; i--) {
		    outArr[index] = out.get(i);
        	index++;        	
        }

        
        return outArr;  
    }
}