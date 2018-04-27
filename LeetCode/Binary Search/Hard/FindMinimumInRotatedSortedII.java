class Solution {
    public int findMin(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    
    public int search(int[] nums, int left, int right) {
        //System.out.println("Left " + left + " Right " + right);
        if (left == right) {
            return nums[left];
        }
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        
        int middle = left + ((right - left) / 2);
        //System.out.println("Middle " + middle);
        if (nums[left] < nums[right]) {
            return nums[left];
        } else if (nums[left] > nums[right]) {            
            if (nums[left] > nums[middle] && nums[middle] > nums[right]) {
                return search(nums, middle, right);
            } else if (nums[left] > nums[middle] && nums[middle] < nums[right]) {                
                return search(nums, left, middle);
            } else  {
                return search(nums, left + 1, right);
            }
        } else {
            return search(nums, left + 1, right);
        }
    }
}