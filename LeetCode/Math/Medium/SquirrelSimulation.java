class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
 		
    	int totalDistanceCovered = 0;

    	//Find the nearest nut;
    	int distanceSaved = Integer.MIN_VALUE;    	
    	
    	
    	for (int[] nut : nuts) {
    		int squirrelToNut = getDistance(squirrel, nut);
            int treeToNut = getDistance(tree, nut);            
    		totalDistanceCovered += (2 * treeToNut);
    	    distanceSaved = max(distanceSaved, (treeToNut - squirrelToNut));
    	}    	
    	
        totalDistanceCovered -= distanceSaved;
        
    	return totalDistanceCovered;
    }

    public int max(int i, int j) {
        return i > j ? i : j;
    }
    
    public int getDistance(int[] source, int[] destination) {
    	int verticalDistance = diff(source[0], destination[0]);
    	int horizontalDistance = diff(source[1], destination[1]);
    	return verticalDistance + horizontalDistance;
    }

    public int diff(int a, int b) {
    	return a > b ? (a - b) : (b - a);
    }
}