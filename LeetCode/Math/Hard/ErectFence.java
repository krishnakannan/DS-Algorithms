import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class ErectFence {

	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
  	}

  	Point[] points;

  	public static void main(String args[]) {
  		Scanner in = new Scanner(System.in);
  		int n = in.nextInt();
  		ErectFence ef = new ErectFence();
  		
  		ef.points = new Point[n];
  		
  		for (int i = 0; i < ef.points.length; i++) {
  			ef.points[i] = ef.new Point(in.nextInt(), in.nextInt());	
  		} 
  		
  		List<Point> fence = ef.outerTrees(ef.points);
  		ef.print(fence);
  		
  	}


  	//Implementation of Jarvis March Algorithm.
  	Point currentPoint;
    public List<Point> outerTrees(Point[] points) {
        if (points.length == 1) {
            List<Point> fence = new ArrayList<>();
            fence.add(points[0]);
            return fence;
        }
    	List<Point> fence = new ArrayList<>();
    	Point startingPoint = getStartingPoint(points);
    	currentPoint = startingPoint;
    	fence.add(startingPoint);
    	Point nextPoint = null;
	   	int lastAddSize = 0;
    	while (nextPoint == null || (nextPoint.x != startingPoint.x || nextPoint.y != startingPoint.y)) {
    		currentPoint = fence.get(fence.size() - 1);    		
    		List<Point> collinear = new ArrayList<>();
    		boolean isNextSet = false;
    		for (int i = 0; i < points.length; i++) {
    			Point potentialNextPoint = points[i];    			
    			if (potentialNextPoint.x == currentPoint.x && potentialNextPoint.y == currentPoint.y) {
    				continue;
    			}
    			if (!isNextSet) {
    				nextPoint = potentialNextPoint;
    				isNextSet = true;
    			} else {
    				int crossProduct = getCrossProduct(currentPoint, nextPoint, potentialNextPoint);    			
    				if (crossProduct > 0) {
    					nextPoint = potentialNextPoint;
    					collinear.clear();
    				} else if (crossProduct == 0) {
    					collinear.add(potentialNextPoint);
    				}                    
    			}    			
	    	}	
	    	if (collinear.isEmpty()) {	    		
	    		fence.add(nextPoint);    		
	    		lastAddSize = 1;
                nextPoint = fence.get(fence.size() - 1);
	    	} else {	    		
	    		collinear.add(nextPoint);
	    		Collections.sort(collinear, new Comparator<Point>(){
	    			public int compare(Point b, Point c) {
	    				Point a = currentPoint;
	    				int d1 = Math.abs((int)Math.sqrt(((b.x - a.x) * (b.x - a.x)) + ((b.y - a.y) * (b.y - a.y))));
	    				int d2 = Math.abs((int)Math.sqrt(((c.x - a.x) * (c.x - a.x)) + ((c.y - a.y) * (c.y - a.y))));
	    				return d1 - d2;
	    			}
	    		});	    		    		
	    		combineList(fence, collinear);
	    		lastAddSize = 0;
                nextPoint = collinear.get(collinear.size() - 1);
	    	}
            
    	}
    	while (--lastAddSize >= 0) {            
            fence.remove(fence.size() - 1);	
    	}    	
    	return fence;    	
    	
    }
    
    public void combineList(List<Point> fence, List<Point> collinear) {
        int fSize = fence.size();
        for (int i = 0; i < collinear.size(); i++) {
            boolean contains = false;
            for (int j = 0; j < fSize; j++) {
                if (collinear.get(i).x == fence.get(j).x && collinear.get(i).y == fence.get(j).y) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                fence.add(collinear.get(i));
            }
        }
    }

    // Just getting the left most point;
    public Point getStartingPoint(Point[] points) {
    	Point startingPoint = new Point(101, 101);
    	for (Point point : points) {
    		if (point.x < startingPoint.x) {
    			startingPoint.x = point.x;
    			startingPoint.y = point.y;
    		}
    	}
    	return startingPoint;
    }    


    /*
		First Vector - (a, b) Second Vector - (a, c)

		Point P is given by co-ordinates = (x, y);
        
        A vector between two points P1 and P2 is ((x2 - x1), (y2 - y1));
        
        So A vector is represented as (a, b);
        
        Cross Product between two vectors V1 and V2 of 2 dimension is 
        
        V1 x V2 = (a1 * b2) - (b1 * a2)
		
		We have two vectors. V1 - (a, b) V2 - (a, c);
		
		V1 = (a, b) with a = x1,y1 and b = x2,y2;

			V1 => ((x2 - x1), (y2 - y1));

		V2 = (a, c) with a = x1,y1 and c = x3,y3;

			V2 => ((x3 - x1), (y3 - y1));

		V1 x V2 = ((x2 - x1) * (y3 - y1)) - ((y2 - y1) * (x3 - x1));
				

		Vector V1 is on Left of V2 if the cross product is positive,
		 0 if collinear, negative if V1 is on right of V2

		Refer Right Hand Thumb rule;

    */
    public int getCrossProduct(Point a, Point b, Point c) {
    	int x1 = a.x;
    	int y1 = a.y;
    	int x2 = b.x;
    	int y2 = b.y;
    	int x3 = c.x;
    	int y3 = c.y;
    	return ((x2 - x1) * (y3 - y1)) - ((y2 - y1) * (x3 - x1));
    }

    public void print(List<Point> fence) {
    	for (Point point : fence) {
  			System.out.print("[" + point.x + ", " + point.y + "] ");	
  		} 
  		System.out.println();
    }

    public void print(Point point) {
    	System.out.println("[" + point.x + ", " + point.y + "]");	  		
    }
}