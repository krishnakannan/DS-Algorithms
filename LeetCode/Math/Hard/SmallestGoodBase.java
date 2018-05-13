class Solution {
    public String smallestGoodBase(String n) {
        int mDigits = 63;
        int kBase;
        long nValue = Long.parseLong(n);
        
        double baseCandidate = 1;
        
        while (baseCandidate < nValue) {
            baseCandidate = Math.pow((double)nValue, (1d / (mDigits - 1)));
            if (baseCandidate < 2) {
                //System.out.println("Base Candidate " + baseCandidate + " mDigits " + mDigits + " nValue " + nValue);
                mDigits -= 1;
                continue;
            } else {
                long base = (long)(Math.floor(baseCandidate));
                long exp = base;                
                long newValue = 1l;
                for (int i = 1; i < mDigits; i++) {                    
                    newValue += exp;
                    exp = exp * base;
                }
                //System.out.println("Base Candidate " + baseCandidate + " mDigits " + mDigits + " nValue " + nValue + " New Value " + newValue);
                if (nValue == newValue) {
                    return Long.toString(base);
                } else {
                    mDigits -= 1;
                }
            }            
        }
        return Long.toString(nValue - 1);
    }
}