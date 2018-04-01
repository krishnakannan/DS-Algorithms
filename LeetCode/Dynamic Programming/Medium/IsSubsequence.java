public class Solution {
    public boolean isSubsequence(String s, String t) {
		char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int sLen = sArr.length;
        int tLen = tArr.length;
        if (sLen == 0) {
            return true;
        } 
        if (tLen == 0) {
            return false;
        }

        int index = 0;
        for (int i = 0; i < tLen; i++) {
            if (sArr[index] == tArr[i]) {
                index++;
                if (index == sLen) {
                    return true;
                }
            }
        }   
        return false;
    }
}