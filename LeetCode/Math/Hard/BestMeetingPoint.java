import java.util.*;
import java.lang.*;   
import java.io.*;

class BestMeetingPoint {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		BestMeetingPoint bmp = new BestMeetingPoint();
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] grid = new int[m][n];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		System.out.println(bmp.minTotalDistance(grid));
	}

	
    List<int[]> homesIndex;
    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        List<Integer> homesCols = new ArrayList<>();
        List<Integer> homesRows = new ArrayList<>();        
        homesIndex = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    homesRows.add(i);
                    homesCols.add(j);
                    homesIndex.add(new int[]{i, j});
                }
            }
        }       
        Collections.sort(homesRows);
        Collections.sort(homesCols);
        int medianRows = getMedian(homesRows);        
        int medianCols = getMedian(homesCols);        

        //System.out.println("MEDIAN " + median);
        
        
        int minDistance = 0;
        for (int[] homeIndex : homesIndex) {
            minDistance += getDistance(new int[]{medianRows, medianCols}, homeIndex);                               
        }        
        
        return minDistance;
    }

    public int getDistance(int[] source, int[] destination) {
        int xDistance = diff(source[0], destination[0]);
        int yDistance = diff(source[1], destination[1]);
        return xDistance + yDistance;
    }

    public int diff(int a, int b) {
        return a > b ? a - b : b - a;
    }

    public int getMedian(List<Integer> homes) {
        //System.out.println(homes);
        int size = homes.size();
        if (size % 2 != 0) {
            return homes.get(size / 2);
        } else {
            int first = homes.get((size / 2) - 1);
            int second = homes.get(size / 2);
            return (first + second) / 2;
        }
    }
}