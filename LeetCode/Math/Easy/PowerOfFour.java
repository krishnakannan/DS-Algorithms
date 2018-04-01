public class Solution {
    public boolean isPowerOfFour(int num) {
        String bitString = Integer.toBinaryString(num);
		return Integer.bitCount(num) == 1 && bitString.charAt(0) == '1' && bitString.length() % 2 != 0;
    }
}