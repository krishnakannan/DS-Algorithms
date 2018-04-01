public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
    	int x = 0;
    	int res = 0;
    	int count = 2;
    	for (int i = 1; i < A.length - 1; i++) {
    		x = A[i - 1] - A[i];
    		if (x == A[i] - A[i + 1]) {
    			count++;
    		} else {
    			if (count > 2) {
    	            res += ((count - 1)*(count - 2) / 2);    
    	        }   
    			count = 2;
    		}
    	}
    	if (count > 2) {
    	    res += ((count - 1)*(count - 2) / 2);    
    	}
    	return res;
    }
}