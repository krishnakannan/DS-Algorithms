/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the given function*/

//https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

class GfG {

	class Node {
		int label;
		int distance;
		//Node Index, weight
		Map<Integer, Integer> edges;
		private Node() {}; 
		public Node (int label, int distance) {
			this.label = label;
			this.distance = distance;
			this.edges = new HashMap<>();
		}
	}

  	public static void dijkstra(int graphMatrix[][], int src ,int V) {

  		GfG obj = new GfG();
  		//Convert Adjacency Matrix Representation to actual Graph Representation.  		
  		
  		Node[] graph = new Node[V];
  		obj.createGraphStructure(graphMatrix, graph, src, V);

  		//INIT Necessary DS
  		Queue<Node> gHeap = new PriorityQueue<>(new Comparator<Node>(){
  			public int compare(Node a, Node b) {
  				return a.distance - b.distance;
  			}
  		});  		
  		Set<Node> processedNode = new HashSet<>();

  		for (int i = 0; i < V; i++) {
  			gHeap.add(graph[i]);
  		}

  		while (!gHeap.isEmpty()) {
  			Node currentNode = gHeap.poll();
  			processedNode.add(currentNode);		
  			//Process and update the Neighbors
  			for (Map.Entry<Integer, Integer> edge : currentNode.edges.entrySet()) {
				Node neighbor = graph[edge.getKey()];
				if (!processedNode.contains(neighbor)) {
					gHeap.remove(neighbor);
					neighbor.distance = neighbor.distance > currentNode.distance + edge.getValue() ? 
											currentNode.distance + edge.getValue() : neighbor.distance;
					gHeap.add(neighbor);
				}
			}	
  		}

  		for (int i = 0; i < V; i++) {
  			System.out.print(graph[i].distance + " ");
  		}
	}

	public void createGraphStructure(int[][] graphMatrix, Node[] graph, int src, int V) {		
  		for (int i = 0; i < V; i++) {
  			graph[i] = new Node(i, Integer.MAX_VALUE);
  		}
  		for (int i = 0; i < V; i++) {
  			if (i == src) {
  				graph[i].distance = 0;
  			} else { 
  				graph[i].distance = Integer.MAX_VALUE;
  			}
  			for (int j = 0; j < V; j++) {
  				if (graphMatrix[i][j] > 0) {
  					graph[i].edges.put(j, graphMatrix[i][j]);	
  				}  				
  			}
  		}
	}
}