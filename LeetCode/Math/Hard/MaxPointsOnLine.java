/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

// N CUBE ALGORITHM - FINDING COLLINEARITY
class Solution {
    public int maxPoints(Point[] points) {
    	if (points.length < 3) {
    		return points.length;
    	}
    	List<Point> uniqPointsList = new ArrayList<>();
    	HashMap<String, Integer> pointsMap = new HashMap<>();
    	for (Point point : points) {
    		String p = point.x + "," + point.y;
    		if (!pointsMap.containsKey(p)) {
    			uniqPointsList.add(point);
    			pointsMap.put(p, 0);
    		}
    		pointsMap.put(p, pointsMap.get(p) + 1);
    	}

    	Point[] uniqPoints = new Point[uniqPointsList.size()];
    	uniqPoints = uniqPointsList.toArray(uniqPoints);
        
        if (uniqPoints.length < 3) {
    		int maxPoints = 0; 
            for (Point p : uniqPoints) {
                maxPoints += pointsMap.get(p.x + "," + p.y);
            }
            return maxPoints;
    	}

 		int maxPoints = 0;                
 		for (int i = 0; i < uniqPoints.length - 2; i++) {
 			for (int j = i + 1; j < uniqPoints.length - 1; j++) {
 				int pointsOnStLine = pointsMap.get(uniqPoints[i].x + "," + uniqPoints[i].y) + pointsMap.get(uniqPoints[j].x + "," + uniqPoints[j].y);
 				for (int k = j + 1; k < uniqPoints.length; k++) {
 					if (isCollinear(uniqPoints[i], uniqPoints[j], uniqPoints[k])) {
 						pointsOnStLine += pointsMap.get(uniqPoints[k].x + "," + uniqPoints[k].y);
            
 					}	
 				}
 				maxPoints = maxPoints < pointsOnStLine ? pointsOnStLine : maxPoints;
 			} 
 		}
 		
 		return maxPoints;
    }

    public boolean isCollinear(Point a, Point b, Point c) {        
    	long lhs = (long)(a.x - c.x) * (long)(a.y - b.y);
    	long rhs = (long)(a.x - b.x) * (long)(a.y - c.y);                
    	return lhs == rhs;
    }
}