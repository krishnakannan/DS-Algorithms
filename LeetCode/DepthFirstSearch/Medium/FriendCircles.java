class Solution {

    
     public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
//  public int findCircleNum(int[][] matrix) { 
//     	int circles = 0;
//         for (int i = 0; i < matrix.length; i++) {
//         	for (int j = 0; j < matrix[0].length; j++) {
//         		if (matrix[i][j] == 1) {
//         			processCircle(matrix, i, j);
//         			circles++;
//         		}
//         	}
//         }
//         return circles;
//     }


//     //Adjacency Matrix is a Symmetric Matrix

//     public void processCircle(int[][] matrix, int r, int c) {        
//     	// //Self
//     	matrix[r][r] = 0;
        
//         //System.out.println("R " + r + " C " + c);

//     	for (int i = r < c ? r : c; i < matrix[r].length; i++) {
//     		if (matrix[r][i] == 1 || matrix[i][r] == 1) {
//     			matrix[r][i] = 0;
//     			matrix[i][r] = 0;
//                 //System.out.println("R " + r + " C " + i);
//     			processCircle(matrix, i, r);
//     		}
//     	}
//     }
// }