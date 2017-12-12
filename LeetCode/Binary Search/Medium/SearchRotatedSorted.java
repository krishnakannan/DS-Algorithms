class Solution {

    int targetIndex = -1;
    public int search(int[] nums, int target) {        
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    public int binarySearch(int[] nums, int leftIndex, int rightIndex, int target) {                
        if (leftIndex > rightIndex) {
            return -1;
        }
        
        int middleIndex = leftIndex + ((rightIndex - leftIndex) / 2);
        //System.out.println("Left = " + leftIndex + " Right = " + rightIndex + " middle = " + middleIndex);
        if (nums[middleIndex] == target) {            
            return middleIndex;
        }
        
        
        //If there is a rotation in the array / subarray
        
        
        if (nums[leftIndex] <= nums[middleIndex]) {
            //LEFT IS SORTED
            if (target >= nums[leftIndex] && target < nums[middleIndex]) {
                //SearchLeft                
                return binarySearch(nums, leftIndex, middleIndex - 1, target);                
            } else {
                return binarySearch(nums, middleIndex + 1, rightIndex, target);
            }            
        }  else  {
            //RIGHT IS SORTED
            if (target > nums[middleIndex] && target <= nums[rightIndex]) {                    
                return binarySearch(nums, middleIndex + 1, rightIndex, target);                        
            } else {
                return binarySearch(nums, leftIndex, middleIndex - 1, target);
            } 
         }
    }        
}
