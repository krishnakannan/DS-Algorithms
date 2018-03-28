class Solution {
    public boolean canTransform(String startString, String endString) {
        if (startString.length() == 1 && endString.length() == 1) {
            return startString.equals(endString);
        } else if (startString.length() != endString.length()) {
            return false;
        }
        char[] start = startString.toCharArray();
        char[] end = endString.toCharArray();
        
        int i = 0;
        int j = 0;
        boolean toFind = false;
        
        while (i < start.length && j < end.length) {
            if ((start[i] == 'R' && end[i] == 'L') || (start[i] == 'L' && end[i] == 'R')) {
                return false;
            }
            
            while (i < start.length - 1 && start[i] == 'X') {
                i++;
            }
            
            while (j < end.length - 1 && end[j] == 'X') {
                j++;
            }
            
            if (start[i] != end[j] || (start[i] == 'L' && i < j) || (start[i] == 'R' && i > j) ) {
                return false;
            }
            
            if (start[i] == end[j]) {                                                                
                i++;
                j++;                
            }
                    
        }
        
        return true && !toFind;
    }
}