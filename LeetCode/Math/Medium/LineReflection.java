class Solution {
    public boolean isReflected(int[][] points) {
 		int min = Integer.MAX_VALUE;
 		int max = Integer.MIN_VALUE;
 		Set<String> set = new HashSet<>();

 		for (int[] point : points) {
 			min = point[0] < min ? point[0] : min;
 			max = point[0] > max ? point[0] : max;
            String str = point[0] + "|" + point[1];
 			set.add(str);
 		}
        //System.out.println(set);
 		int sum = min + max;
		
		for (int[] point : points) {
 			String str = (sum - point[0]) + "|" + (point[1]);
            //System.out.println(str);
 			if (!set.contains(str)) {
 				return false;
 			}
 		} 		

 		return true;
    }
}