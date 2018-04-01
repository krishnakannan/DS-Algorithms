public class Solution {
    public boolean isHappy(int n) {
        int x = 0;
        List<Integer> prevVals = new ArrayList<>();
        while (x != 1) {
        	x = calc(n);
        	if (prevVals.contains(x)) {
        		return false;
        	}
        	n = x;
        	prevVals.add(x);
        }
        return true;
    }

    public int calc(int n) {
    	int val = 0;
    	while (n > 0) {
    		val += Math.pow((n % 10), 2);
    		n /= 10;
    	}
    	return val;
    }
    
    
}