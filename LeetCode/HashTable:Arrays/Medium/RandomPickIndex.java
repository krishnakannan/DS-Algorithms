class Solution {

    Map<Integer, List<Integer>> map;
    
    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        Random r = new Random();
        List<Integer> indexes = map.get(target);
        if (indexes == null || indexes.size() == 0) {
            return -1;            
        } else if (indexes.size() == 1) {
            return indexes.get(0);
        }
        int indexOfIndex = r.nextInt((indexes.size()));        
        return indexes.get(indexOfIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */