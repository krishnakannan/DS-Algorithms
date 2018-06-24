class Solution {    
    public int findLHS(int[] nums) {
        if (nums.length == 0)  {
            return 0;
        }
        TreeMap<Integer, Integer> count = new TreeMap<>();        
        for (int i = 0; i < nums.length; i++) {            
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);            
        }
        
        int maxValue = 0;
        Integer prev = null;
        System.out.println(count);
        for (Map.Entry<Integer, Integer> curr : count.entrySet()) {
            if (prev == null) {
                prev = curr.getKey();
            } else {
                if (curr.getKey() - prev == 1) {
                    int val = count.get(prev) + curr.getValue();
                    maxValue = val > maxValue ? val : maxValue;                    
                }
                prev = curr.getKey();    
            }
        }
        return maxValue;
    }
}