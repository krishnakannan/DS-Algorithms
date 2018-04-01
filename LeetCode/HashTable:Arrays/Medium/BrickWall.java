class Solution {
    public int leastBricks(List<List<Integer>> wall) {
 		Map<Integer, Integer> brickMap = new HashMap<>();
 		int max = Integer.MIN_VALUE; 		
        int totalWallHeight = wall.size();
 		for (List<Integer> wallRow : wall) {
 			int len = 0;
            int size = wallRow.size();
            for (int i = 0; i < size - 1; i++) {
                len += wallRow.get(i);
                brickMap.put(len, brickMap.containsKey(len) ? brickMap.get(len) + 1 : 1);
            } 			
 		}
        
        //System.out.println(brickMap);
        
 		for (Map.Entry<Integer, Integer> entry : brickMap.entrySet()) {
 			if (max < entry.getValue()) { 				
 				max = entry.getValue();
 			}
            //System.out.println("MAX " + max);
 		}        

        return max < 0 ? totalWallHeight : totalWallHeight - max;
    }
}