import java.util.*;
import java.lang.*;
import java.io.*;

class RectanglePathII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] rectangles = new int[n][4];
		for (int i = 0; i < rectangles.length; i++) {
			for (int j = 0; j < rectangles[0].length; j++) {
				rectangles[i][j] = in.nextInt();
			}
		}
		RectanglePathII rp2 = new RectanglePathII();
		System.out.println(rp2.rectangleArea(rectangles));
	}

	public int rectangleArea(int[][] rectangles) {
        List<int[]> rectangeList = new LinkedList<>();
        int totalArea = 0;

        for (int i = 0; i < rectangles.length; i++) {
        	totalArea += processRectangles(rectangeList, rectangles[i]);
        	totalArea %= 1000000007;
        }

        return totalArea;

    }

    public long processRectangles(List<int[]> rectangeList, int[] currentRect) {
    	if (rectangeList.isEmpty()) {
    		rectangeList.add(currentRect);
    		return getArea(currentRect);
    	}

    	Iterator<int[]> iterator = rectangeList.iterator();
    	List<int[]> tempRectList = new LinkedList<>();
    	long area = 0;
    	while (iterator.hasNext()) {
    		int[] tempRect = iterator.next();
    		if (currentRect[0] <= tempRect[2] && currentRect[1] <= tempRect[3] && currentRect[2] >= tempRect[0] && currentRect[3] >= tempRect[1]) {
                area -= getArea(tempRect);
    			iterator.remove();                
    			if (tempRect[0] < currentRect[0]) {
    				tempRectList.add(new int[]{tempRect[0], tempRect[1], currentRect[0], tempRect[3]});
    			}
    			if (tempRect[3] > currentRect[3]) {
    				tempRectList.add(new int[]{Math.max(tempRect[0], currentRect[0]), currentRect[3], tempRect[2], tempRect[3]});
    			}
    			if (tempRect[1] < currentRect[1]) {
    				tempRectList.add(new int[]{Math.max(tempRect[0], currentRect[0]), tempRect[1], tempRect[2], currentRect[1]});
    			}
    			if (tempRect[2] > currentRect[2]) {
    				tempRectList.add(new int[]{currentRect[2], Math.max(tempRect[1], currentRect[1]), tempRect[2], Math.min(currentRect[3], tempRect[3])});
    			}
    		}
    	}
        
        tempRectList.add(currentRect);

    	for (int[] coords : tempRectList) {
    		rectangeList.add(coords);
    		area += getArea(coords);
    		area %= 1000000007;
    	}

    	return area;

    }

    public long getArea(int[] coords) {
    	long area = diff(coords[2], coords[0]) * diff(coords[3], coords[1]);
    	return area % 1000000007;
    }

    public long diff(int a, int b) {
    	return a > b ? (long)(a - b) : (long)(b - a);
    }
}