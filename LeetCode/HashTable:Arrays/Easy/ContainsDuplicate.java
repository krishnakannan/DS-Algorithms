public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> nMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nMap.put(nums[i], nMap.containsKey(nums[i]) ? nMap.get(nums[i]) + 1 : 1);
        }
        for (Map.Entry<Integer, Integer> x : nMap.entrySet()) {
            if (x.getValue() > 1) {
                return true;
            }
        }
        return false;    
    }
}