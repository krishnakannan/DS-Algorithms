class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> maxKeys = new ArrayList<>();
        int maxValue = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKeys.clear();
                maxKeys.add(entry.getKey());
            } else if (entry.getValue() == maxValue) {
                maxKeys.add(entry.getKey());
            }
        }
        // System.out.println("MAP " + map + " MAXKEY " + maxKey + " MAXVALUE " + maxValue);
        int minLength = Integer.MAX_VALUE;
        for (Integer maxKey : maxKeys) {
            int left = 0;
            int right = nums.length - 1;        
            while (nums[left] != maxKey) {
                left += 1;
            }
            while (nums[right] != maxKey) {
                right -= 1;
            }
            int length = right - left + 1;
            minLength = length < minLength ? length : minLength;
        }
        
        
        return minLength;
    }
}