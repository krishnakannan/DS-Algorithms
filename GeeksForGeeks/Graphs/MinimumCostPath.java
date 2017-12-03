import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/minimum-cost-path/0

class MinimumCostPath {

	class GraphNode {
		int label;
		int  distance;
		int val; 
		GraphNode(){};
		GraphNode(int label, int distance, int val) {
			this.label = label;
			this.distance = distance;
			this.val = val;
		}
	}
	
	public static void main (String[] args) {
		MinimumCostPath mcp = new MinimumCostPath();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[][] arr = new int[n][n];		    
		    for (int i = 0; i < arr.length; i++) {
		    	for (int j = 0; j < arr[0].length; j++) {
		    		arr[i][j] = in.nextInt();	
		    	}		        
		    }
			System.out.println(mcp.tracePath(arr));
			//mcp.printMatrix(arr);
 		}
	}

	//Simplified Dijkstra

	public Integer tracePath(int[][] arr) {
	
		//Declare and Initialize necessary DS
		Queue<GraphNode> gHeap = new PriorityQueue<>(new Comparator<GraphNode>(){
			public int compare(GraphNode a, GraphNode b) {
				return a.distance - b.distance;
			}
		});
		Queue<GraphNode> neighbourQueue = new LinkedList<>();		
		HashMap<Integer, GraphNode> nodesMap = new HashMap<>();
		Set<GraphNode> processedNodeSet = new HashSet<>();
		GraphNode source = new GraphNode(0, arr[0][0], arr[0][0]);
		GraphNode currentNode = null;
		int nodeCount = 0;
		// push all node into the heap;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0;  j < arr[0].length; j++) {
				if (i == 0 && j == 0) {
					nodesMap.put(nodeCount, source);	
					gHeap.add(source);
					nodeCount++;
					continue;
				}
				GraphNode node = new GraphNode(nodeCount, Integer.MAX_VALUE, arr[i][j]);
				nodesMap.put(nodeCount, node);	
				gHeap.add(node);
				nodeCount++;
			}
		}

		while (!gHeap.isEmpty()) {
			currentNode = gHeap.poll();
			processedNodeSet.add(currentNode);

			List<GraphNode> neighbours = getNeighbours(currentNode, nodesMap, arr.length, arr[0].length, processedNodeSet);
			for (GraphNode node : neighbours) {
				gHeap.remove(node);
				neighbourQueue.add(node);				
			}

			while (!neighbourQueue.isEmpty()) {
				GraphNode temp = neighbourQueue.poll();				
				temp.distance = temp.distance > temp.val + currentNode.distance ? temp.val + currentNode.distance : temp.distance;


				gHeap.add(temp);
			}
		}
		
		return nodesMap.get((arr.length * arr[0].length) - 1).distance;
	}

	//Little Math
	public List<GraphNode> getNeighbours(GraphNode currentNode, Map<Integer, GraphNode> map,
		 Integer maxRows, Integer maxCols, Set<GraphNode> processedNodeSet) {

		List<GraphNode> neighbours = new ArrayList<>();
		int currentNodeLabel = currentNode.label;		

		//Up
		if ((currentNodeLabel - maxCols) > 0 && !processedNodeSet.contains(map.get(currentNodeLabel - maxCols))) {
			neighbours.add(map.get(currentNodeLabel - maxCols));
		}
		//Down
		if ((currentNodeLabel + maxCols) < map.size() && !processedNodeSet.contains(map.get(currentNodeLabel + maxCols))) {
			neighbours.add(map.get(currentNodeLabel + maxCols));
		}
		//Left
		if ((currentNodeLabel % maxRows != 0) && !processedNodeSet.contains(map.get(currentNodeLabel - 1))) {
			neighbours.add(map.get(currentNodeLabel - 1));
		}
		//Right
		if ((currentNodeLabel % maxRows != (maxRows - 1)) && !processedNodeSet.contains(map.get(currentNodeLabel + 1))) {
			neighbours.add(map.get(currentNodeLabel + 1));
		}
		return neighbours;
	}
}