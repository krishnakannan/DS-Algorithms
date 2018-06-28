class Solution {
    public boolean rotateString(String A, String B) {
        if (A.equals("") && B.equals("")) {
            return true;
        }
        if (A.length() != B.length()) {
            return false;
        }
        for (int i = 0; i < A.length(); i++) {
            String fHalf = A.substring(0, i);
            String sHalf = A.substring(i, A.length());
            if (B.equals(sHalf + fHalf)) {
                return true;
            }
        }
        return false;
    }
}