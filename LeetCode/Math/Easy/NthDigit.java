class Solution {
    public int findNthDigit(int n) {
        int digitLength = 1;
        long count = 9;
        int start = 1;
        while (n > digitLength * count) {
            n -= (digitLength * count);
            digitLength += 1;
            start *= 10;
            count *= 10;            
        }   
        
        start += (n - 1) / digitLength;
        String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % digitLength));
    }
}