class Solution {
    public int[] singleNumber(int[] nums) {
        int[] n = new int[2];
        int xors = 0;
        for (int i = 0; i < nums.length; i++) {
            xors ^= nums[i];
        }
        
        //Find Last Set Bit
        xors = xors & -xors;
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((xors & nums[i]) == 0) {
                n1 ^= nums[i];
            } else {
                n2 ^= nums[i];
            }
        }
        n[0] = n1;
        n[1] = n2;
            
        return n;
    }
}