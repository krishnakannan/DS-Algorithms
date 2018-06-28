class Solution {
    public boolean hasAlternatingBits(int n) {
        String nString = Integer.toBinaryString(n);
        for (int i = 1; i < nString.length(); i++) {
            if (nString.charAt(i) == nString.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}