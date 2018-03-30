//Referred Solution

class Solution {
    public int findLUSlength(String[] strs) {
        int maxLen = -1;
        
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }                
                if (isSubSeq(strs[j], strs[i])) {
                    break;
                }
            }
            if (j == strs.length) {
                maxLen = maxLen < strs[i].length() ? strs[i].length() : maxLen;
            }
        }        
        
        return maxLen;
    }
    
    public boolean isSubSeq(String a, String b) {
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < a.length() && bIndex < b.length()) {
            if (a.charAt(aIndex) == b.charAt(bIndex)) {
                bIndex++;
            }
            aIndex++;
        }
        return bIndex == b.length();
    }
}