class Solution {
    public int[] searchRange(int[] nums, int target) {
		int left = -1;
		int right = -1;
		if (nums.length > 0) {
			left = binarySearch(nums, target, true);
        	right = binarySearch(nums, target, false);
		}
        int[] retVal = new int[2];
        retVal[0] = left;
        retVal[1] = right;
        return retVal;
    }
    
    public int binarySearch (int[] arr, int val, boolean isLeft) {
		int left = 0;
		int right = arr.length - 1;

		int mid = (left + right) / 2;
        if (isLeft) {
            while (left < right) {
            	if (arr[mid] == val && arr[mid] > arr[left] && mid > 0 && arr[mid] > arr[mid - 1]) {
					return mid;
				}
                if (val <= arr[mid]) {
                    right = mid - 1;
                } else if (val > arr[mid]) {
                    left = mid + 1;
                }
                mid = (left + right) / 2;
		    }    
        } else {
            while (left < right) {
				if (arr[mid] == val && arr[mid] < arr[right] && mid < arr.length && arr[mid] < arr[mid + 1]) {
					return mid;
				}				
				if (val < arr[mid]) {
					right = mid - 1;
				} else if (val >= arr[mid]) {
					left = mid + 1;
				}
				mid = (left + right) / 2;
			}
        }
		
		return arr[left] == val ? left : -1;
	}			
}