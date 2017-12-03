import java.util.*;
import java.lang.*;
import java.io.*;

//USING DIJKSTRA's ALG

class ShortestPathUnweighted {

	public class Coord {
		int x;
		int y;
		private Coord(){};
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + x * y;	        
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {	    	
	    	final Coord other = (Coord) obj;
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        if (this.x == other.x && this.y == other.y) {
	            return true;
	        }
	        return false;
	    }
	}

	public class GraphNode {
		Coord label;
		int val;
		int distance;
		private GraphNode(){};
		public GraphNode(Coord label, int val, int distance) {
			this.label = label;
			this.val = val;
			this.distance = distance;
		}
	}

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		ShortestPathUnweighted shortestPath = new ShortestPathUnweighted();
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int m = in.nextInt();
		    int[][] arr = new int[n][m];
		    for (int i = 0; i < arr.length; i++) {
		    	for (int j = 0; j < arr[0].length; j++) {
		    		arr[i][j] = in.nextInt();	
		    	}		        
		    }		 
		    int destinationX = in.nextInt();
		    int destinationY = in.nextInt();
		    System.out.println(shortestPath.tracePath(arr, destinationX, destinationY));
 		}
	}

	public Integer tracePath(int[][] graph, int destinationX, int destinationY) {
		//No source to start
		if (graph[0][0] == 0){
			return -1;
		}
		//Init Required DS
		Queue<GraphNode> gHeap = new PriorityQueue<>(new Comparator<GraphNode>(){
			public int compare(GraphNode a, GraphNode b) {
				return a.distance - b.distance;
			}
		});
		Map<Coord, GraphNode> gMap = new HashMap<>();
		Queue<GraphNode> neighbours = new LinkedList<>();
		GraphNode source = new GraphNode(new Coord(0,0), graph[0][0], 0);
		Set<GraphNode> processedNodes = new HashSet<>();

		//Populate the HEAP
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if (i == 0 && j == 0) {
					gHeap.add(source);
					gMap.put(new Coord(i, j), source);
				} else {
					GraphNode newNode = new GraphNode(new Coord(i, j), graph[i][j], Integer.MAX_VALUE);
					gHeap.add(newNode);						
					gMap.put(new Coord(i, j), newNode);
				}
			}
		}

		//Process the HEAP
		while (!gHeap.isEmpty()) {
			GraphNode currentNode = gHeap.poll();
			if (currentNode.distance == Integer.MAX_VALUE) {
				//This means it is a Island
				break;
			} else if (currentNode.val == 0) {
				continue;
			}
			processedNodes.add(currentNode);
			getNeighbours(currentNode, neighbours, gMap, graph.length, graph[0].length, processedNodes);			

			while (!neighbours.isEmpty()) {
				GraphNode tempNode = neighbours.poll();				
				gHeap.remove(tempNode);
				tempNode.distance = tempNode.distance > tempNode.val + currentNode.distance ? tempNode.val + currentNode.distance : tempNode.distance;
				gHeap.add(tempNode);				
			}
		}
		
		int retVal = gMap.get(new Coord(destinationX, destinationY)).distance;
		return retVal == Integer.MAX_VALUE ? -1 : retVal;
	}

	public void getNeighbours(GraphNode currentNode, Queue<GraphNode> neighbours, Map<Coord, GraphNode> gMap, 
		Integer maxRows, Integer maxCols, Set<GraphNode> processedNodes) {
		Coord currentCoord = currentNode.label;
		int x = currentCoord.x;
		int y = currentCoord.y;

		if (x > 0 && gMap.get(new Coord(x - 1, y)).val > 0 
			&& !processedNodes.contains(gMap.get(new Coord(x - 1, y)))) {
			neighbours.add(gMap.get(new Coord(x - 1, y)));
		}

		if (y > 0 && gMap.get(new Coord(x, y - 1)).val > 0 
			&& !processedNodes.contains(gMap.get(new Coord(x, y - 1)))) {
			neighbours.add(gMap.get(new Coord(x, y - 1)));
		}

		if (x < maxRows - 1 && gMap.get(new Coord(x + 1, y)).val > 0 
			&& !processedNodes.contains(gMap.get(new Coord(x + 1, y)))) {
			neighbours.add(gMap.get(new Coord(x + 1, y)));
		}

		if (y < maxCols - 1 && gMap.get(new Coord(x, y + 1)).val > 0 
			&& !processedNodes.contains(gMap.get(new Coord(x, y + 1)))) {
			neighbours.add(gMap.get(new Coord(x, y + 1)));
		}
	}
}