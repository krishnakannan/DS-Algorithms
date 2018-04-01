public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int totalStrings = strs.length;
        int prefixLength = 0;
        if (totalStrings > 0) {
            prefixLength = strs[0].length();
        }
        for (int i = 1; i < totalStrings; i++) {
            int strLength = strs[i].length();
            int len = 0;
            for (int j = 1; j <= strLength && j <= prefixLength; j++) {
                len = j;
                if (prefixLength > 0 && strs[0].charAt(j - 1) == strs[i].charAt(j - 1)) {
                    continue;
                } else {
                	len = j - 1;
                    break;
                }
            }   
            prefixLength = prefixLength > len ? len : prefixLength;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prefixLength; i++) {
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}