class Solution {

	//Referred.. Revisit;

    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0;
        int i = 0;
        int right = n - 1;

        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            } else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }


    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }


    public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return Integer.MAX_VALUE;
		}
	    return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
	}    

	public int findKthLargest(int[] nums, int start, int end, int k) {
		if (start > end) {
			return Integer.MAX_VALUE;
		}
		
		int pivot = nums[end];
		int left = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot) {				
				swap(nums, left++, i);			
			}
		}
		swap(nums, left, end);
		
		if (left == k) {
			return nums[left];
		} else if (left < k) {
			return findKthLargest(nums, left + 1, end, k);
		} else {
			return findKthLargest(nums, start, left - 1, k);
		}
	} 

	void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;				
	}

}