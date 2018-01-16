class Solution {
    Map<String, Integer> islandMap = new HashMap<>();

    public int numDistinctIslands(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {					
					String key = mapIsland(grid, i, j, new StringBuilder(), "");
                    //System.out.println(key);
					islandMap.put(key, islandMap.containsKey(key) ? islandMap.get(key) + 1 : 1);
				}
			}
		}       
        //System.out.println(islandMap);
		return islandMap.size();
    }

    public String mapIsland(int[][] grid, int row, int col, StringBuilder path, String from) {
    	if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
    		return path.toString();
    	}

    	if (grid[row][col] == 0) {            
    		return path.toString();
    	}
        
    	path.append(from);        
    	grid[row][col] = 0;
    	mapIsland(grid, row + 1, col, path, "d");
    	mapIsland(grid, row, col + 1, path, "r");
    	mapIsland(grid, row - 1, col, path, "u");
    	mapIsland(grid, row, col - 1, path, "l");
        path.append("b");
    	return path.toString();
    }
}