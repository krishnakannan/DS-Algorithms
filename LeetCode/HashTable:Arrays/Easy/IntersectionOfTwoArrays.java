public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> n1Set = new HashSet<>();
		Set<Integer> intersection = new HashSet<>();
		int index = 0;
		for (int i = 0; i < nums1.length; i++) {
			n1Set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (n1Set.contains(nums2[i])) {
				intersection.add(nums2[i]);
			}
		}
		int[] o = new int[intersection.size()];
		for (Integer x : intersection) {
			o[index] = x;
			index++;
		}
		return o;
    }
}