class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int total = 0;
        Set<Integer> sum = new HashSet<>();
        for (int i = 0; i + 3 <= grid.length; i += 1) {
            for (int j = 0; j + 3 <= grid[0].length; j += 1) {
                sum.clear();
                //System.out.println("i " + i + " j " + j);
                for (int x = i, a = j; a < j + 3 && x < i + 3 && a < grid[0].length && x < grid.length; x++, a++) {
                    int rowSum = 0;
                    int colSum = 0;                    
                    for (int y = j, b = i; b < i + 3 && y < j + 3 && b < grid.length && y < grid[0].length; y++, b++) {                                                
                        if (grid[x][y] > 9 || grid[x][y] < 1) {
                            break;
                        } else if (grid[b][a] > 9 || grid[b][a] < 1) {
                            break;
                        }
                        rowSum += grid[x][y];
                        colSum += grid[b][a];
                    }
                    sum.add(rowSum);
                    sum.add(colSum);
                }
                sum.add(grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2]);
                sum.add(grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2]);
                if (sum.size() == 1) {
                    total += 1;
                }
            }
        }
        return total;
    }
}