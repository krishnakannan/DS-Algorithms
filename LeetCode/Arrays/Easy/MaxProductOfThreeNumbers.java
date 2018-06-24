class Solution {
    public int maximumProduct(int[] nums) {
        int fHighest = Integer.MIN_VALUE;
        int sHighest = Integer.MIN_VALUE;
        int tHighest = Integer.MIN_VALUE;
        
        int fLowest = 0;
        int sLowest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] < fLowest) {
                int temp = fLowest;
                fLowest = nums[i];
                sLowest = temp;
            } else if (nums[i] < sLowest) {
                sLowest = nums[i];
            }
            
            if (nums[i] > fHighest) {
                int temp = fHighest;
                fHighest = nums[i];
                int sTemp = sHighest;
                sHighest = temp;
                tHighest = sTemp;                    
            } else if (nums[i] > sHighest) {
                int sTemp = sHighest;
                sHighest = nums[i];
                tHighest = sTemp;    
            } else if (nums[i] > tHighest) {
                tHighest = nums[i];
            }
        }
        
        int candidate1 = fHighest * sHighest * tHighest;
        int candidate2 = fHighest * fLowest * sLowest;
        return candidate1 > candidate2 ? candidate1 : candidate2;
    }
}