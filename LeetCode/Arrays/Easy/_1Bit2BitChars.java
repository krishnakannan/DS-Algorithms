class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1 && bits[0] == 0) {
            return true;
        } 
        for (int i = 0; i < bits.length;) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
            if (i == bits.length - 1) {
                return true;
            }
        }
        return false;
    }
}