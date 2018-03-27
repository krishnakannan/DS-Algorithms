class Solution {
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {            
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        int maxSum = sum / k;
        
        for (int i = 0; i < nums.length; i++) {            
            if (nums[i] > maxSum) {
                return false;
            }
        }        
        
        //This is a referred speed-up which is brilliant
        int maxIndex = nums.length - 1;
        while (maxIndex >= 0 && nums[maxIndex] == maxSum) {
            maxIndex--;
            k--;
        }
        
        
        boolean can = constructSubsets(new int[k], nums, 0, maxIndex, maxSum);
        //print(p);
        return can;
    }
    
    public boolean constructSubsets(int[] partitions, int[] nums, int index, int maxIndex, int maxsum) {        
        //print(partitions);
        if (index > maxIndex) {
            return true;
        }                
        for (int i = 0; i < partitions.length; i++) {
            partitions[i] += nums[index];
            if (partitions[i] <= maxsum) {
                if (constructSubsets(partitions, nums, index + 1,maxIndex, maxsum)) {
                    return true;
                }
            }            
            partitions[i] -= nums[index];
            
            //Another Speed-up Referred.
            if (partitions[i] == 0) {
                break;
            }
        }        
        return false;        
    }
    
    public void print(int[] p) {
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }
    
}