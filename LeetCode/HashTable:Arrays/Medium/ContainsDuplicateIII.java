class Solution {

	//TreeSet - Uses Red-Black Tree (Self Balancing Binary Search Tree);
	// O(n log k);

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
 		TreeSet<Integer> tSet = new TreeSet<>();
 		for (int i = 0; i < nums.length; i++) {
 			//Get the number lower and higher.
 			Integer lower = tSet.floor(nums[i]);
 			if (lower != null && (long)nums[i] - (long)lower <= (long)t) {
 				return true;
 			} 

 			Integer higher = tSet.ceiling(nums[i]);
 			if (higher != null && (long)higher - (long)nums[i] <= (long)t) {
 				return true;
 			}

 			tSet.add(nums[i]);
 			if (tSet.size() > k) {
 				tSet.remove(nums[i - k]);
 			}
 		}
 		return false;
    }
}