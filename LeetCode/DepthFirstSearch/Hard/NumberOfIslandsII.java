import java.util.*;
import java.lang.*;
import java.io.*;

class NumberOfIslandsII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int x = in.nextInt();
		int[][] positions = new int[x][2];
		for (int i = 0; i < positions.length; i++) {
			positions[i][0] = in.nextInt();
			positions[i][1] = in.nextInt();
		}
		NumberOfIslandsII noi2  = new NumberOfIslandsII();
		System.out.println(noi2.numIslands2(m, n, positions));
	}


	int[][] ocean;
	Map<Integer, List<int[]>> oceanMap;
	int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        ocean = new int[m][n];
        oceanMap = new HashMap<>();
        List<Integer> islandCount = new ArrayList<>();
        int island = 1;
        for (int[] position : positions) {
        	addLand(position, island);
        	island += 1;
        	islandCount.add(oceanMap.size());
        }
        return islandCount;
    }

    public void addLand(int[] position, int islandNumber) {    	
    	Set<Integer> islands = new HashSet<>();
    	fill(position[0], position[1],islandNumber, islands);
    	if (islands.size() == 0) {
    		if (!oceanMap.containsKey(islandNumber)) {
    			oceanMap.put(islandNumber, new ArrayList<>());	
    		}
    		oceanMap.get(islandNumber).add(position);
    	} else if (islands.size() == 1) {
    		for (Integer island : islands) {
    			oceanMap.get(island).add(position);
    		}
    	} else if (islands.size() > 1) {
    		List<int[]> tempList = new ArrayList<>();
    		for (Integer island : islands) {
    			tempList.addAll(oceanMap.get(island));
    			oceanMap.remove(island);
    		}	
    		oceanMap.put(islandNumber, new ArrayList<>());
    		oceanMap.get(islandNumber).addAll(tempList);
    		oceanMap.get(islandNumber).add(position);
    	}
    }

    public void fill(int x, int y, int currentNumber, Set<Integer> existingIslands) {    	

        int tempIslandNumber = -1;
    	if (x > 0 && ocean[x - 1][y] > 0) {
            tempIslandNumber = ocean[x - 1][y];
    		existingIslands.add(ocean[x - 1][y]);
    	}
    	if (y > 0 && ocean[x][y - 1] > 0) {
            tempIslandNumber = ocean[x][y - 1];
    		existingIslands.add(ocean[x][y - 1]);
    	} 
    	if (x < ocean.length - 1 && ocean[x + 1][y] > 0) {
            tempIslandNumber = ocean[x + 1][y];
    		existingIslands.add(ocean[x + 1][y]);
    	}
    	if (y < ocean[0].length - 1 && ocean[x][y + 1] > 0) {
            tempIslandNumber = ocean[x][y + 1];
    		existingIslands.add(ocean[x][y + 1]);
    	} 

    	if (existingIslands.size() == 0) {    		
    		ocean[x][y] = currentNumber;
    	} else if (existingIslands.size() == 1) {
    		ocean[x][y] = tempIslandNumber;
    		return;
    	}

    	ocean[x][y] = currentNumber;
    	floodFill(x, y, currentNumber);
    } 

    public void floodFill(int x, int y, int fillNumber) {
    	ocean[x][y] = fillNumber;
    	for (int[] dir : dirs) {
    		int nx = x + dir[0];
    		int ny = y + dir[1];
    		if (nx < 0 || nx >= ocean.length || ny < 0 || ny >= ocean[0].length) {
	    		continue;
	    	}	
	    	if (ocean[nx][ny] != fillNumber && ocean[nx][ny] != 0) {
	    		floodFill(nx, ny, fillNumber);
	    	}
    	}
    }
}