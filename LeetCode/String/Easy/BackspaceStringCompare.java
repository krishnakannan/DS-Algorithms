class Solution {
    public boolean backspaceCompare(String S, String T) {
        int sDelCount = 0;
        int tDelCount = 0;
        int sIndex = S.length() - 1;
        int tIndex = T.length() - 1;
        while (sIndex >= 0 || tIndex >= 0) {
            while (sIndex >= 0 && (sDelCount > 0 || S.charAt(sIndex) == '#')) {
                if (S.charAt(sIndex) == '#') {
                    sDelCount += 1;
                    sIndex -= 1;
                } else {
                    sDelCount -= 1;
                    sIndex -= 1;
                }
            }
            while (tIndex >= 0 && (tDelCount > 0 || T.charAt(tIndex) == '#')) {
                if (T.charAt(tIndex) == '#') {
                    tDelCount += 1;
                    tIndex -= 1;
                } else {
                    tDelCount -= 1;
                    tIndex -= 1;
                }
            }
            if (sIndex >= 0 && tIndex >= 0 && S.charAt(sIndex) != T.charAt(tIndex)) {
                return false;
            } else {
                sIndex -= 1;
                tIndex -= 1;
            }
        }
        
        return sIndex == tIndex;
        
    }
}