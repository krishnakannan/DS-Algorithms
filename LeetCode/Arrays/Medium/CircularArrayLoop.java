class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int length = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            
            int sPtr = i;
            int fPtr = i;
            int count = 0;
            boolean isFwd = nums[sPtr] > 0;
            do {
                int tsPtr = sPtr;
                sPtr = (sPtr + nums[sPtr] + length) % length;
        
                if (isFwd && nums[fPtr] < 0 || !isFwd && nums[fPtr] > 0) {
                     return false;   
                }
                fPtr = (fPtr + nums[fPtr] + length) % length;
        
                if (isFwd && nums[fPtr] < 0 || !isFwd && nums[fPtr] > 0) {
                  return false;  
                } 
                
                fPtr = (fPtr + nums[fPtr] + length) % length;
        
                nums[tsPtr] = 0;
                count++;
                
            } while (sPtr != fPtr);
            
            if (count > 1) {
              return true;  
            } 
        }
        return false;
    }
}