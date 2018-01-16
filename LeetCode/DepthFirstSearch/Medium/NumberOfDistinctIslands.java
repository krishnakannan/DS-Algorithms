import java.util.*;
import java.lang.*;

public class NumberOfDistinctIslands {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		NumberOfDistinctIslands numOfIslands = new NumberOfDistinctIslands();	    
	    int[][] arr = {{1,1,1,1},{1,0,1,0},{0,0,0,0},{0,1,1,1},{1,1,0,1}};
	    numOfIslands.numDistinctIslands(arr);
	}

	 Map<String, Integer> islandMap = new HashMap<>();

    public int numDistinctIslands(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					List<Integer> island = mapIsland(grid, i, j, new ArrayList<>());
					String key = getKey(island, grid[0].length);					
					islandMap.put(key, islandMap.containsKey(island) ? islandMap.get(key) + 1 : 1);
				}
			}
		}         
		return islandMap.size();
    }

    public List<Integer> mapIsland(int[][] grid, int row, int col, List<Integer> currentMapping) {
    	if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
    		return currentMapping;
    	}

    	if (grid[row][col] == 0) {
    		return currentMapping;
    	}

    	int loc = (row * grid[0].length) + (col + 1);
    	currentMapping.add(loc);
    	grid[row][col] = 0;
    	mapIsland(grid, row + 1, col, currentMapping);
    	mapIsland(grid, row, col + 1, currentMapping);
    	mapIsland(grid, row - 1, col, currentMapping);
    	mapIsland(grid, row, col - 1, currentMapping);

    	return currentMapping;
    }

    public String getKey(List<Integer> island, int modVal) {

    	//Finding TopLeft;
    	Collections.sort(island);
    	int smallest = island.get(0);
    	int smallestMod = Integer.MAX_VALUE;
    	int topLeft = 0;
    	for (Integer val : island) {
    		int mod = val % modVal;
            mod = mod == 0 ? modVal : mod;
    		if (mod < smallestMod) {
    			topLeft = val;
                smallestMod = mod;
    			if (val > smallest) {                    
    				while (topLeft > smallest) {
    					topLeft -= modVal;    					                        
    				}
    			}
    		}
    	}


    	StringBuilder sBuilder = new StringBuilder();    
    	for (Integer islandPoint : island) {
    		sBuilder.append(islandPoint - topLeft + 1);
    	}
    	return sBuilder.toString();
    }
}