//https://leetcode.com/problems/spiral-matrix/description/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {        
        List<Integer> out = new ArrayList<>();
        if (matrix.length == 0) {
            return out;
        }
        int iStart = 0;
		int jStart = 0;
		int iEnd = matrix.length - 1;
		int jEnd = matrix[0].length - 1;
		int x = 0; int y = 0;
		while (iStart <= iEnd && jStart <= jEnd) {
			x = jStart; 			
			while (x <= jEnd) {
                //System.out.println("1");
                out.add(matrix[iStart][x]);				
				x++;
			}
			iStart++;
			x = iStart;            
			while (x <= iEnd) {
                //System.out.println("2");
                out.add(matrix[x][jEnd]);				
				x++;	
			}
			jEnd--;
			x = jEnd;
            if (iStart > iEnd || jStart > jEnd) {
                break;
            }
			while (x >= jStart) {
                //System.out.println("3");
                out.add(matrix[iEnd][x]);				
				x--;	
			}
			iEnd--;
			x = iEnd;
			while (x >= iStart) {
                //System.out.println("4");
                out.add(matrix[x][jStart]);				
				x--;	
			}
			jStart++;
		}
        return out;
    }
}