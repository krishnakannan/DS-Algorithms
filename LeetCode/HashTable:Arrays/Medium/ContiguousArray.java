class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            count = nums[i] == 0 ? count - 1 : count + 1;
            if (count == 0) {
                maxLength = maxLength < (i + 1) ? (i + 1) : maxLength;
            } else if (map.containsKey(count)) {
                int pIndex = map.get(count);
                maxLength = maxLength < (i - pIndex) ? (i - pIndex) : maxLength;
            } else {
                map.put(count, i);
            }
        }
      
        
        return maxLength;    
    }
    
}