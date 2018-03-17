class Solution {

	//Beats 99.88 %

    public int totalHammingDistance(int[] nums) {
        int totalHammingDistance = 0;

        int ithBitZero = 0;
        int ithBitOne = 0;
        int bit = 0;

        while (bit <= 31) {
        	ithBitZero = countZeros(nums, bit);
        	ithBitOne = nums.length - ithBitZero;
        	totalHammingDistance += (ithBitZero * ithBitOne);
        	bit++;
        }
 
 		return totalHammingDistance;
    }

    public int countZeros(int[] nums, int bit) {
    	int andVal = 1 << bit;
    	int zeroCount = 0;
    	for (int i = 0; i < nums.length; i++) {
    		zeroCount = nums[i] & andVal == 0 ? zeroCount + 1 : zeroCount;
    	}
    	return zeroCount;
    }
}