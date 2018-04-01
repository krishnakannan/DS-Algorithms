public class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        int index = 0;
        int nIndex = 0;
        if (needle.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < hLen; i++) {
            if (haystack.charAt(i) == needle.charAt(nIndex)) {
                if (nIndex == nLen - 1) { 
                    return index;
                } 
                
                if (nIndex == 0) {
                    index = i;
                    nIndex++;
                } else {
                    nIndex++;
                }
            } else {
                i -= nIndex;
                nIndex = 0;
                index = 0;
            }            
        }
        
        return -1;
    }
}