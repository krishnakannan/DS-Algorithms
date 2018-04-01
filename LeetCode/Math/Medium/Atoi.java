class Solution {
    public int myAtoi(String str) {
        long value = 0;
        boolean isNegative = false;
        boolean hasNumberSeriesStarted = false;
        int symbolCount = 0;
        char[] sArray = str.toCharArray();
        for (int i = 0; i < sArray.length; i++) {            
            if (sArray[i] == ' ' || sArray[i] == '+' || sArray[i] == '-') {  
                if (sArray[i] == '+') {
                    symbolCount++;
                }
                if (sArray[i] == '-') {
                    isNegative = true;
                    symbolCount++;
                }
                if (sArray[i] == ' ') {
                    if (symbolCount > 0) {
                        break;
                    }
                }
                if (!hasNumberSeriesStarted) {                    
                    continue;    
                } else {                    
                    break;
                }                
            } else if ((int)sArray[i] >= 48 && (int)sArray[i] <= 57) {
                value *= 10;
                hasNumberSeriesStarted = true;
                
                value += (long)sArray[i] - 48;
                if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
                    break;
                }
                
            } else {
                break;
            }
        }
        
        if (symbolCount > 1)  {
            value = 0;
        }
        
        return isNegative ? -value < Integer.MIN_VALUE ? Integer.MIN_VALUE : 
                (int)-value : value > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)value;
    }
}