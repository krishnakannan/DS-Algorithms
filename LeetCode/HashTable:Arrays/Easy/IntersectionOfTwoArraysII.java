public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
        	numsMap.put(nums1[i], numsMap.containsKey(nums1[i]) ? numsMap.get(nums1[i]) + 1 : 1);
        }
        for (int i = 0; i < nums2.length; i++) {
        	if (numsMap.containsKey(nums2[i]) && numsMap.get(nums2[i]) > 0) {
        		intersection.add(nums2[i]);
        		numsMap.put(nums2[i], numsMap.get(nums2[i]) - 1);
        	}
        }
        int[] intersectionArray = new int[intersection.size()];
        int index = 0;
        for (Integer i : intersection) {
        	intersectionArray[index++] = i;
        }
        return intersectionArray;    
    }
}