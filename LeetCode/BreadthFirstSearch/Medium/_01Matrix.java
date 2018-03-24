class Solution {
    public int[][] updateMatrix(int[][] matrix) {
 		for (int i = 0; i < matrix.length; i++) {
 			for (int j = 0; j < matrix[0].length; j++) {
 				matrix[i][j] = matrix[i][j] == 0 ? 0 : Integer.MAX_VALUE;
 			}
 		}

 		for (int i = 0; i < matrix.length; i++) {
 			for (int j = 0; j < matrix[0].length; j++) {
 				if (matrix[i][j] == 0) {
 					bfs(matrix, i, j, new boolean[matrix.length][matrix[0].length]);                   
                    print(matrix);
 				}	
 			}
 		}
        return matrix;
    }

    public void bfs(int[][] matrix, int row, int col, boolean[][] visited) {

    	Queue<int[]> bfsQ = new LinkedList<>();    	
    	bfsQ.add(new int[]{row, col});    	
        visited[row][col] = true;
        
    	while (!bfsQ.isEmpty()) {
    		int[] coord = bfsQ.poll();    		
            int r = coord[0];
            int c = coord[1];
            int distance = matrix[r][c] + 1;
            visited[r][c] = true;
            
            
            if (r < matrix.length - 1 && !visited[r + 1][c] && matrix[r + 1][c] >= distance) {
                matrix[r][c] = distance;
                bfsQ.add(new int[]{r + 1, c});                
            }
            
            if (r > 0 && !visited[r - 1][c] && matrix[r - 1][c] >= distance) {
                matrix[r][c] = distance;
                bfsQ.add(new int[]{r - 1, c});
            }
            
            if (c < matrix[0].length - 1 && !visited[r][c + 1] && matrix[r][c + 1] >= distance) {
                matrix[r][c] = distance;
                bfsQ.add(new int[]{r, c + 1});
            }
            
            if (c > 0 && !visited[r][c - 1] && matrix[r][c - 1] >= distance) {
                matrix[r][c] = distance;
                bfsQ.add(new int[]{r, c - 1});
            }            
    	}   
    }
    
    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
 			for (int j = 0; j < matrix[0].length; j++) {
 		        System.out.print(matrix[i][j] + " ");
 			}
            System.out.println();
 		}
        System.out.println();
    }


}