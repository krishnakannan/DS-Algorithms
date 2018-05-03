import java.util.*;
import java.lang.*;   
import java.io.*;

class SmallestRectangleEnclosingBlackPixel {

	public static void main(String args[]) {
		SmallestRectangleEnclosingBlackPixel srebp = new SmallestRectangleEnclosingBlackPixel()
		Scanner in = new Scanner();
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] image = new int[m][n];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				image[i][j] = in.nextInt();
			}
		}
		int x = in.nextInt();
		int y = in.nextInt();
	}

	int topMost = Integer.MAX_VALUE;
	int leftMost = Integer.MAX_VALUE;
	int rightMost = Integer.MIN_VALUE;
	int bottomMost = Integer.MIN_VALUE;


    public int minArea(char[][] image, int x, int y) {
        topMost = x;
        bottomMost = x;
        rightMost = y;
        leftMost = y;
        dfs(image, x, y);
        int length = rightMost - leftMost + 1;
        int height = bottomMost - topMost + 1;        
        return length * height;
    }

    

    public void dfs(char[][] image, int x, int y) {
    	if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
    		return;
    	}

    	if (image[x][y] == '0') {
    		return;
    	}

        //System.out.println("x " + x + " y " + y);
        
    	if (x < topMost) {
    		topMost = x;
    	}
    	if (x > bottomMost) {
    		bottomMost = x;
    	}
    	if (y < leftMost) {
    		leftMost = y;
    	}
    	if (y > rightMost) {
    		rightMost = y;
    	}

    	image[x][y] = '0';
    	dfs(image, x + 1, y);
    	dfs(image, x - 1, y);
    	dfs(image, x, y + 1);
    	dfs(image, x, y - 1);
    }
}
}