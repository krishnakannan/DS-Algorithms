class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int bitCount = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    bitCount++;
                    bitCount %= 3;
                }
            }
            if(bitCount != 0) {
                ans |= bitCount << i;
            }
        }
        return ans;        
    }
}