import java.util.*;
import java.lang.*;
import java.io.*;

class CutOffTrees {

	public static void main(String args[]) {
		CutOffTrees ct = new CutOffTrees();
		List<List<Integer>> forest = new ArrayList<>();
		try {
			InputStream is = new FileInputStream("cut.txt");
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));             
			String line = buf.readLine();           
			while(line != null){
				String[] trees = line.split(" ");			   				
				forest.add(new ArrayList<>());
				for (String treeString : trees) {
					Integer tree = Integer.parseInt(treeString);
					forest.get(forest.size() - 1).add(tree);
				}		  		   
			   line = buf.readLine();
			}
		} catch(IOException e) {

		}               
		//System.out.println(forest);
		long startTime = System.nanoTime();                     		
		System.out.println(ct.cutOffTree(forest));
		System.out.println((System.nanoTime() - startTime)/(1000 * 1000) + " Milliseconds");
	}
	
	class Point {
		int x;
		int y;
		int val;
		public Point(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	int walkLength = -1;
	Set<Point> visited = new HashSet<>();
	Queue<Point> pointsPQ;

    public int cutOffTree(List<List<Integer>> forest) {     	
     	pointsPQ = new PriorityQueue<Point>(new Comparator<Point>(){
     		public int compare(Point a, Point b) {
     			return a.val - b.val;
     		}
     	});
        Point[][] map = poltPoints(forest);
     	boolean isAllCutDown = walk(map, 0, 0);        
     	return isAllCutDown ? walkLength : -1;
    }

    public boolean walk(Point[][] map, int x, int y) {
    	walkLength = 0;
    	Point source = map[0][0];
        if (!pointsPQ.isEmpty() && pointsPQ.peek().equals(source)) {
            pointsPQ.poll();
        }
    	while (!pointsPQ.isEmpty()) {            
    		Point currentPoint = pointsPQ.poll();            
    		int walk = shortestPath(map, source, currentPoint);        
            if (walk == 0) {
                //System.out.println("Source " + source.val  + " Destination " + currentPoint.val);
                return false;
            }   
            walkLength += walk;
    		source = currentPoint;
    	}
        return true;
    }
    

    //Finding Shortest Path using BFS
    public int shortestPath(Point[][] map, Point source, Point destination) {
    	if (source.equals(destination)) {
    		return 0;
    	}

    	int distance = 0;    	
    	boolean[][] visited = new boolean[map.length][map[0].length];
    	//Set<Point> visited = new HashSet<>();               
        Queue<Point> bfsQ = new LinkedList<>();                        
        bfsQ.add(source);                        
    	

        while (!bfsQ.isEmpty()) {
        	int size = bfsQ.size();
        	for (int i = 0; i < size; i++) {
        		Point currentPoint = bfsQ.poll();
        		visited[currentPoint.x][currentPoint.y] = true;
	        	//visited.add(currentPoint);            
	        	for (Point neighbor : getNeighbors(currentPoint, map)) {	                
	        		if (!visited[neighbor.x][neighbor.y]) {
	        			bfsQ.add(neighbor);	        		
	                    //visited.add(neighbor);
	                    visited[neighbor.x][neighbor.y] = true;
	                    if (neighbor.equals(destination)) {
	                        return ++distance;
	                    }
	        		}                
	        	}       	
        	}        	
            distance++;
        }
        return 0;
    }

    public Point[][] poltPoints(List<List<Integer>> forest) {
    	int rows = forest.size();
    	int cols = forest.get(0).size();
    	Point[][] map = new Point[rows][cols];
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {    			
                Point point = new Point(i, j, forest.get(i).get(j));
                map[i][j] = point;
                if (point.val > 1) {                                        
                    pointsPQ.add(point);        			    
                }   			
    		}	
    	}
    	return map;
    }

    public List<Point> getNeighbors(Point point, Point[][] map) {
    	int x = point.x;
    	int y = point.y;

    	List<Point> neighbors = new ArrayList<>();

    	if (x > 0) {
    		if (map[x - 1][y].val > 1) {
    			neighbors.add(map[x - 1][y]);	
    		}    		
    	}

    	if (y > 0) {
    		if (map[x][y - 1].val > 1) {
    			neighbors.add(map[x][y - 1]);	
    		}    		
    	}

    	if (x < map.length - 1) {
    		if (map[x + 1][y].val > 1) {
    			neighbors.add(map[x + 1][y]);	
    		}    		
    	}

    	if (y < map[0].length - 1) {
    		if (map[x][y + 1].val > 1) {
    			neighbors.add(map[x][y + 1]);	
    		}    		
    	}

    	// Collections.sort(neighbors, new Comparator(){
    	// 	public int compare(Point a, Point b) {
    	// 		return a.val - b.val;
    	// 	}
    	// });
    	return neighbors;
    }
}