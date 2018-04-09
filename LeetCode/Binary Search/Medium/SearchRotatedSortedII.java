class Solution {

    int targetIndex = -1;
    public boolean search(int[] nums, int target) {        
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    public boolean binarySearch(int[] nums, int leftIndex, int rightIndex, int target) {                
        if (leftIndex > rightIndex) {
            return false;
        }
        
        int middleIndex = leftIndex + ((rightIndex - leftIndex) / 2);
        //System.out.println("Left = " + leftIndex + " Right = " + rightIndex + " middle = " + middleIndex);
        if (nums[middleIndex] == target) {            
            return true;
        }
        
        
        //This is Theta(n)
        //return binarySearch(nums, leftIndex, middleIndex - 1, target) || binarySearch(nums, middleIndex + 1, rightIndex, target);
        
        //This is O(n);
        if (nums[leftIndex] < nums[middleIndex]) {
            //LEFT IS SORTED
            if (target >= nums[leftIndex] && target < nums[middleIndex]) {
                //SearchLeft                
                return binarySearch(nums, leftIndex, middleIndex - 1, target);                
            } else {
                return binarySearch(nums, middleIndex + 1, rightIndex, target);
            }            
        }  else  if (nums[leftIndex] > nums[middleIndex]) {
            //RIGHT IS SORTED
            if (target > nums[middleIndex] && target <= nums[rightIndex]) {                    
                return binarySearch(nums, middleIndex + 1, rightIndex, target);                        
            } else {
                return binarySearch(nums, leftIndex, middleIndex - 1, target);
            } 
        } else {
            return binarySearch(nums, leftIndex + 1, rightIndex, target);
        }
    }        
}
