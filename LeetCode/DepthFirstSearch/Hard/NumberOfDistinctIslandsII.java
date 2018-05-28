import java.util.*;
import java.lang.*;



class NumberOfIslandsII {

    public static void main(String arfs[]) {
        NumberOfIslandsII no = new NumberOfIslandsII();
        Scanner in = new Scanner(System.in);
        int rowSize = in.nextInt();
        int colSize = in.nextInt();
        int[][] grid = new int[rowSize][colSize];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        System.out.println(no.numDistinctIslands2(grid));
    }
    int[] coords = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    int landSize = 0;
    Map<int[][], Integer> map;
    Map<Integer, List<int[][]>> sizeMap;

    public int numDistinctIslands2(int[][] grid) {
        map = new HashMap<>();
        sizeMap = new HashMap<>();
        int[][] tempGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                tempGrid[i][j] = grid[i][j];
            }
        }
        int islandCount = 2;


        for (int i = 0; i < tempGrid.length; i++) {
            for (int j = 0; j < tempGrid[0].length; j++) {
                if (tempGrid[i][j] == 1) {
                    coords = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
                    landSize = 0;
                    traverse(tempGrid, i, j, islandCount);

                    int[][] candidateIsland = new int[coords[2] - coords[0] + 1][coords[3] - coords[1] + 1];
                    for (int x = coords[0], a = 0; x <= coords[2]; x++, a++) {
                        for (int y = coords[1], b = 0; y <= coords[3]; y++, b++) {
                            if (tempGrid[x][y] == islandCount) {
                                candidateIsland[a][b] = grid[x][y];
                            } else {
                                candidateIsland[a][b] = 0;
                            }
                        }
                    }
                    islandCount++;
                    if (sizeMap.containsKey(landSize)) {
                        boolean added = false;
                        for (int[][] origMatrix : sizeMap.get(landSize)) {
                            if (isRotated(origMatrix, candidateIsland) || isReflectedUpsideDown(origMatrix, candidateIsland) || isReflectedLaterally(origMatrix, candidateIsland)) {
                                int count = map.get(origMatrix);
                                count++;
                                map.put(origMatrix, count);
                                added = true;
                                break;
                            }
                        }
                        if (!added) {
                            sizeMap.get(landSize).add(candidateIsland);
                            map.put(candidateIsland, 1);
                        }
                    } else {
                        sizeMap.put(landSize, new ArrayList<>());
                        sizeMap.get(landSize).add(candidateIsland);
                        map.put(candidateIsland, 1);
                    }
                }
            }
        }
        return map.size();
    }


    //Return x1,y1,x2,y2
    public void traverse(int[][] tGrid, int x, int y, int count) {

        if (x < 0 || x >= tGrid.length || y < 0 || y >= tGrid[0].length) {
            return;
        }

        if (tGrid[x][y] == 0 || tGrid[x][y] == count) {
            return;
        }

        coords[0] = x < coords[0] ? x : coords[0];
        coords[1] = y < coords[1] ? y : coords[1];
        coords[2] = x > coords[2] ? x : coords[2];
        coords[3] = y > coords[3] ? y : coords[3];
        tGrid[x][y] = count;
        landSize++;
        traverse(tGrid, x - 1, y, count);
        traverse(tGrid, x, y - 1, count);
        traverse(tGrid, x + 1, y, count);
        traverse(tGrid, x, y + 1, count);

        return;

    }


    public boolean isRotated(int[][] origMatrix, int[][] matrix) {

        if (Arrays.deepEquals(origMatrix, matrix)) {
            return true;
        }

        int angle = 0;
        int[][] oldMatrix = matrix;
        //90 180 270
        while (angle < 3) {
            angle++;

            int totalRowsOfRotatedMatrix = oldMatrix[0].length; //Total columns of Original Matrix
            int totalColsOfRotatedMatrix = oldMatrix.length; //Total rows of Original Matrix

            int[][] rotatedMatrix = new int[totalRowsOfRotatedMatrix][totalColsOfRotatedMatrix];

            for (int i = 0; i < oldMatrix.length; i++) {
                for (int j = 0; j < oldMatrix[0].length; j++) {
                    rotatedMatrix[j][ (totalColsOfRotatedMatrix-1)- i] = oldMatrix[i][j];
                }
            }

            if (Arrays.deepEquals(origMatrix, rotatedMatrix)) {
                return true;
            } else if (isReflectedUpsideDown(origMatrix, rotatedMatrix)) {
                return true;
            } else if (isReflectedLaterally(origMatrix, rotatedMatrix)) {
                return true;
            }

            oldMatrix = rotatedMatrix;

        }

        return false;

    }

    public boolean isReflectedUpsideDown(int[][] origMatrix, int[][] mat) {

        int[][] temp = new int[mat.length][mat[0].length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Arrays.copyOf(mat[i], mat[i].length);
        }

        int start = 0;
        int end = temp.length - 1;
        while (start < end) {
            for (int i = 0; i < temp[0].length; i++) {
                int t = temp[start][i];
                temp[start][i] = temp[end][i];
                temp[end][i] = t;
            }
            start++;
            end--;
        }

        if (Arrays.deepEquals(origMatrix, temp)) {
            return true;
        }

        return false;
    }

    public boolean isReflectedLaterally(int[][] origMatrix, int[][] mat) {
        int[][] temp = new int[mat.length][mat[0].length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Arrays.copyOf(mat[i], mat[i].length);
        }

        int start = 0;
        int end = temp[0].length - 1;
        while (start < end) {
            for (int i = 0; i < temp.length; i++) {
                int t = temp[i][start];
                temp[i][start] = temp[i][end];
                temp[i][end] = t;
            }
            start++;
            end--;
        }


        if (Arrays.deepEquals(origMatrix, temp)) {
            return true;
        }

        return false;
    }
}