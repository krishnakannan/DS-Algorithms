import java.util.*;
import java.lang.*;
import java.io.*;

class BusRoutes {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		BusRoutes br = new BusRoutes();
		int[][] routes = new int[m][n];
		for (int i = 0; i < routes.length; i++) {
			for (int j = 0; j < routes[0].length; j++) {
				routes[i][j] = in.nextInt();
			}
		}
		int start = in.nextInt();
		int end = in.nextInt();
		System.out.println(br. numBusesToDestination(routes, start, end));
	}


	//Creating graph using buses as nodes instead of stops
	Map<Integer, List<Integer>> adjacencyList;

	List<Integer> sourceBuses = new ArrayList<>();
	List<Integer> destinationBuses = new ArrayList<>();
	boolean[] visited;
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes.length == 0 || routes[0].length == 0 || S == T) {
            return 0;
        }
        adjacencyList = new HashMap<>();
        createGraph(routes, S, T);
        // System.out.println(adjacencyList);
        // System.out.println(sourceBuses);
        // System.out.println(destinationBuses);
        
        visited = new boolean[routes.length];
        Queue<List<Integer>> bfsQ = new LinkedList<>();        
        int buses = 0;
        bfsQ.add(sourceBuses);
        boolean reachedDestination = false;
        while (!bfsQ.isEmpty()) {
        	List<Integer> polled = bfsQ.poll();
        	buses += 1;
        	for (Integer polledBus : polled) {
        		visited[polledBus] = true;
        		if (canReachDestination(polledBus)) {
        			reachedDestination = true;
        			break;
        		}
        	}            
            if (!reachedDestination) {                
                List<Integer> nextLevel = new ArrayList<>();
                for (Integer polledBus : polled) {
                    if (adjacencyList.containsKey(polledBus)) {
                        for (Integer neighbor : adjacencyList.get(polledBus)) {
                            if (!visited[neighbor]) {
                                nextLevel.add(neighbor);
                            }
                        }    
                    }                    
                }
                if (!nextLevel.isEmpty()) {
                    bfsQ.add(nextLevel);	
                }    
            } else {
                bfsQ.clear();
            }        	
        }

        return reachedDestination ? buses : -1;
    }

    public boolean canReachDestination(int bus) {        
        if (destinationBuses.contains(bus)) {
            return true;
        }
    	// List<Integer> canReachList = adjacencyList.get(bus);
    	// for (Integer canReach : canReachList) {
    	// 	if (destinationBuses.contains(canReach)) {
    	// 		return true;
    	// 	}
    	// }
    	return false;
    }

    public void createGraph(int[][] routesArray, int start, int end) {
    	Map<Integer, List<Integer>> busAndStops = new HashMap<>();
    	for (int i = 0; i < routesArray.length; i++) {    	
    		for (int j = 0; j < routesArray[i].length; j++) {
    			if (!busAndStops.containsKey(routesArray[i][j])) {
    				busAndStops.put(routesArray[i][j], new ArrayList<>());
    			}
                if (!busAndStops.get(routesArray[i][j]).contains(i)) {
                    busAndStops.get(routesArray[i][j]).add(i);    
                }
    			
    		}    		
    	}
    	sourceBuses = busAndStops.get(start);
    	destinationBuses = busAndStops.get(end);
        //System.out.println(busAndStops);
    	for (Map.Entry<Integer, List<Integer>> bsEntry : busAndStops.entrySet()) {
    		if (bsEntry.getValue().size() > 1) {
    			List<Integer> overlappingStops = bsEntry.getValue();
    			for (int i = 0; i < overlappingStops.size(); i++) {
    				if (!adjacencyList.containsKey(overlappingStops.get(i))) {
    					adjacencyList.put(overlappingStops.get(i), new ArrayList<>());
    				}
    				for (int j = 0; j < overlappingStops.size(); j++) {
    					if (i == j) {
    						continue;
    					}
    					adjacencyList.get(overlappingStops.get(i)).add(overlappingStops.get(j));
    				}
    			}
    		}
    	}
        //System.out.println(adjacencyList);
    }
}