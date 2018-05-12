import java.util.*;
import java.lang.*;   
import java.io.*;

class TrappingRainWaterII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] heightMap = new int[m][n];
		for (int i = 0; i < heightMap.length; i++) {
			for (int j = 0; j < heightMap[0].length; j++) {
				heightMap[i][j] = in.nextInt();
			}
		}
		TrappingRainWaterII trw2 = new TrappingRainWaterII();
		System.out.println(trw2.trapRainWater(heightMap));
	}

    boolean visited[][];    
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        } else if (heightMap.length == 1 || heightMap[0].length == 1) {
            return 0;
        }
        
        visited = new boolean[heightMap.length][heightMap[0].length];
        
        int waterTrapped = fill(heightMap);
        
        return waterTrapped;

    }

    public int[][] neighborIndex = new int[][]{{-1,0}, {1,0}, {0, -1}, {0, 1}};


    public int fill(int[][] heightMap) {
        
        Queue<Cell> pQueue = new PriorityQueue<Cell>(new Comparator<Cell>(){
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });

        int waterTrapped = 0;

        //Add Border
        for (int i = 1; i < heightMap.length - 1; i++) {
            visited[i][0] = true;
            visited[i][heightMap[0].length - 1] = true;
            pQueue.add(new Cell(i, 0, heightMap[i][0]));
            pQueue.add(new Cell(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
        }

        for (int j = 0; j < heightMap[0].length; j++) {
            visited[0][j] = true;
            visited[heightMap.length - 1][j] = true;
            pQueue.add(new Cell(0, j, heightMap[0][j]));
            pQueue.add(new Cell(heightMap.length - 1, j, heightMap[heightMap.length - 1][j]));
        }


        while (!pQueue.isEmpty()) {
            Cell polledCell = pQueue.poll();
            for (int[] neighbor : neighborIndex) {
                int neighborX = neighbor[0] + polledCell.x;
                int neighborY = neighbor[1] + polledCell.y;
                if (neighborX >= 0 && neighborX < heightMap.length && neighborY >= 0 && neighborY < heightMap[0].length && !visited[neighborX][neighborY]) {
                    visited[neighborX][neighborY] = true;
                    if (polledCell.height >= heightMap[neighborX][neighborY]) {                        
                        waterTrapped += polledCell.height - heightMap[neighborX][neighborY];
                        pQueue.add(new Cell(neighborX, neighborY, polledCell.height));
                    } else {
                        pQueue.add(new Cell(neighborX, neighborY, heightMap[neighborX][neighborY]));
                    }
                }
            }
        }
        return waterTrapped;        
    }    

    public int max(int a, int b) {
        return a > b ? a : b;
    }


    class Cell {
        int x;
        int y;
        int height = 0;
        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public void printArray(int[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}