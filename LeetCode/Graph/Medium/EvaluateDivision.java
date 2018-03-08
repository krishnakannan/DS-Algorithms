/*

	Equations are given in the format A / B = k, where A and B are variables 
	represented as strings, and k is a real number (floating point number). 
	Given some queries, return the answers. If the answer does not exist, 
	return -1.0.

*/


//To Create a weighted un-directed graph

class Solution {


	class Edge {
		String source;
		String destination;
		double weight;

		public Edge(String source, String destination, double weight) { 
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}

	class Path {
		String currentNode;
		double valueSoFar;

		public Path(String currentNode, double valueSoFar) {
			this.currentNode = currentNode;
			this.valueSoFar = valueSoFar;
		}
	}

	//Adjacency List;
	Map<String, List<Edge>> aMap = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        createGraph(equations, values);
        double[] results = new double[queries.length];
        int index = 0;
        for (String[] query : queries) {
        	results[index] = breadthFirstSearch(query[0], query[query.length - 1]);
        	index++;
        }
        return results;
    }

    public double breadthFirstSearch(String source, String destination) {
                
    	if (!aMap.containsKey(source) || !aMap.containsKey(destination)) {            
    		return -1d;
    	}
        
    	if (source.equals(destination)) {
    		return 1d;
    	}

    	Queue<Path> bfsQ = new LinkedList<>();
 		Set<String> visited = new HashSet<>();   	
    	//Entry Point - Edge from no where to source;
    	bfsQ.add(new Path(source, 1d));

    	double value = -1d;

    	while (!bfsQ.isEmpty()) {
    		Path currentPath = bfsQ.poll(); 
    		visited.add(currentPath.currentNode);
    		List<Edge> nextEdges = aMap.get(currentPath.currentNode);
    		double valueSoFar = currentPath.valueSoFar;
    			
    		for (Edge edge : nextEdges) {
    			if (destination.equals(edge.destination)) {
    				return valueSoFar * edge.weight;
    			} else {
    				if (!visited.contains(edge.destination)) {
    					Path newPath = new Path(edge.destination, valueSoFar * edge.weight);
    					bfsQ.add(newPath);	
    				}    				
    			}
    		}
    	}
    	return value;
    }

    public void createGraph(String[][] equations, double[] values) {
    	for (int i = 0; i < equations.length; i++) {
    		String[] equation = equations[i];
    		double value = values[i];
    		String source = equation[0];
    		String destination = equation[1];
    		if (!aMap.containsKey(source)) {
    			aMap.put(source, new ArrayList<>());
    		}
    		if (!aMap.containsKey(destination)) {
    			aMap.put(destination, new ArrayList<>());
    		}
    		Edge toEdge = new Edge(source, destination, value);
    		Edge returnEdge = new Edge(destination, source, 1/value);
    		aMap.get(source).add(toEdge);
    		aMap.get(destination).add(returnEdge);
    	}
    }
}