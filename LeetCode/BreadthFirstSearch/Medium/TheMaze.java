class Solution {

	//This solution also covers extended version - The Maze II.

	Queue<int[]> bfsQ = new LinkedList<>();
	int[][] distance;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    	distance = new int[maze.length][maze[0].length];
    	int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};

    	for (int[] rowDistance : distance) {
    		Arrays.fill(rowDistance, Integer.MAX_VALUE);
    	}

    	distance[start[0]][start[1]] = 0;

		bfsQ.add(start); 

		while (!bfsQ.isEmpty()) {
            //printBFSQ();
			int[] currentPos = bfsQ.poll();
            
			for (int[] direction : directions) {
                int distanceCount = distance[currentPos[0]][currentPos[1]];                        
				int x = currentPos[0] + direction[0];
				int y = currentPos[1] + direction[1];                
				while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
					x += direction[0];
					y += direction[1];
					distanceCount++;
				}
                
                x -= direction[0];
                y -= direction[1];
                
				if (distance[x][y] > distanceCount) {
					distance[x][y] = distanceCount;
					bfsQ.add(new int[] {x, y});
				}
                
                if (distance[destination[0]][destination[1]] != Integer.MAX_VALUE) {
                    return true;
                }
			}

		}
        
        //printMatrix(distance);
        
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? false : true;
    }

    public void printBFSQ() {
        for (int[] element : bfsQ) {
            System.out.print("[" + element[0] + "," + element[1] + "], ");
        }
        System.out.println();        
    }
    
    public void printMatrix(int[][] maze) {
        
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

}