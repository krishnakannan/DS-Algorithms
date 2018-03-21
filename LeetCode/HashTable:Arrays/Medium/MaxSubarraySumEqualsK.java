class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int[] sums = new int[nums.length];
        Map<Integer, Integer> indexMap = new HashMap<>();
        sums[0] = nums[0];
        indexMap.put(sums[0], 0);
        for (int i = 1; i < sums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }
        
        int maxLength = 0;
        indexMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {                        
            if (indexMap.containsKey(sums[i] - k)) {
                int length = i - indexMap.get(sums[i] - k);
                maxLength = length > maxLength ? length : maxLength;
            }            
            if (!indexMap.containsKey(sums[i])) {
                indexMap.put(sums[i], i);
            }
        }        
        return maxLength;
    }
}