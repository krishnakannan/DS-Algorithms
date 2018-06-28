class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isValid(i)) {
                count += 1;
            }
        }
        return count;
    }
    
    public boolean isValid(int N) {        
        boolean isVal = false;        
        while (N > 0) {
            int lastDigit = N % 10;            
            if (lastDigit != 2 && lastDigit != 5 && lastDigit != 6 && lastDigit != 9) {                
                isVal |= false;
            } else {
                isVal |= true;
            }
            if (lastDigit == 3 || lastDigit == 4 || lastDigit == 7) {
                return false;
            }
            N /= 10;
        }
        return isVal;
    }
}