class Solution {

	//Referred Solution

	//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91049/Java-O(n)-solution-using-bit-manipulation-and-HashMap/95535

    public int findMaximumXOR(int[] nums) {
        
        int maxResult = 0;
        int mask = 0;

        for (int i = 31; i >= 0; i--) {

        	mask = mask | 1 << i;
        	Set<Integer> set = new HashSet<>();

        	for (int x = 0; x < nums.length; x++) {
        		set.add(nums[x] & mask);
        	}

        	// Based on a ^ b = c then a ^ c = b;

        	int a = maxResult | 1 << i;
        
        	for (Integer c : set) {

        		int b = a ^ c;
        		if (set.contains(b)) {
        			maxResult = a;
        			break;
        		}
        	}

        }
        
        
        return maxResult;
    }
}