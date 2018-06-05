import java.util.*;
import java.lang.*;
import java.io.*;

class SumOfDistancesInTree {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] edges = new int[n - 1][2];
		for (int i = 0; i < edges.length; i++) {
			edges[i][0] = in.nextInt();
			edges[i][1] = in.nextInt();
		}
		SumOfDistancesInTree sodit = new SumOfDistancesInTree();
		int[] result = sodit.sumOfDistancesInTree(n, edges);
		System.out.println(Arrays.toString(result));
	}

	int[] nodeCount;
	int[] result;
	Map<Integer, List<Integer>> graph;
	boolean[] visited;
	int rootCount = 0;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        visited = new boolean[n];
        nodeCount = new int[n];
        result = new int[n];
        if (n == 1) {
            return result; 
        }
        graph = new HashMap<>();
        for (int[] edge : edges) {
        	if (!graph.containsKey(edge[0])) {
        		graph.put(edge[0], new ArrayList<>());
        	}
        	if (!graph.containsKey(edge[1])) {
        		graph.put(edge[1], new ArrayList<>());
        	}
        	//Since it is undirected
        	graph.get(edge[0]).add(edge[1]);
        	graph.get(edge[1]).add(edge[0]);
        }        
        fillNodeCount(0, 0);                
        result[0] = rootCount;
        Arrays.fill(visited, false);
        visited[0] = true;     
        for (Integer child : graph.get(0)) {
        	computeDistances(child, 0, n);	
        }

        
        return result;
    }

    public void computeDistances(int current, int root, int n) {    	
    	if (visited[current]) {
    		return;
    	}
    	visited[current] = true;
    	if (isLeaf(current)) {    		
    		int rootsDistance = result[root];
    		int currentDistance = result[root] - nodeCount[current] + n - nodeCount[current];
    		result[current] = currentDistance;
    	}
    	int currentDistance = result[root] - nodeCount[current] + n - nodeCount[current];
		result[current] = currentDistance;
    	List<Integer> neighbors = graph.get(current);
    	if (neighbors.size() > 0) {    		
    		for (Integer neighbor : neighbors) {
    			computeDistances(neighbor, current, n);
    		}
    	}
    }

    public int fillNodeCount(int root, int depth) {
    	
    	if (visited[root]) {
    		return 0;
    	}
    	
    	visited[root] = true;
    	
    	if (isLeaf(root)) {
    		rootCount += depth;
    		nodeCount[root] = 1;
    		return 1;
    	}

    	int childNodeCount = 0;
    	List<Integer> neighbors = graph.get(root);
    	if (neighbors.size() > 0) {
    		for (Integer neighbor : neighbors) {
	    		childNodeCount += fillNodeCount(neighbor, depth + 1);
	    	}	
    	}
    	rootCount += depth;
    	nodeCount[root] = childNodeCount + 1;
    	return childNodeCount + 1;
    }

    public boolean isLeaf(int node) {
    	List<Integer> neighbors = graph.get(node);
    	if (neighbors.size() == 0) {
    		return true;
    	}
    	for (Integer neighbor : neighbors) {
    		if (!visited[neighbor]) {
    			return false;
    		}
    	}
    	return true;
    }
}