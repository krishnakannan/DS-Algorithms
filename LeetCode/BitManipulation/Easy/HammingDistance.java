public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        String binXor = Integer.toBinaryString(xor);
        int len = binXor.length();
        int count = 0;
        while (--len >= 0) {
            if (binXor.charAt(len) == '1') {
                count++;
            }
        }
        return count;
    }
}