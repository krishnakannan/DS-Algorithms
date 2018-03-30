class Solution {

	//Dijkstra's

	class City {
		Integer id;
		Integer minCostToSource;
        Map<Integer, Integer> costMap;
		public City(Integer id, Integer minCostToSource, Map<Integer, Integer> costMap) {
			this.id = id;
			this.minCostToSource = minCostToSource;
            this.costMap = costMap;
		}
	}

	class Route {
		Integer destination;
        Integer cost;		
		public Route (Integer destination, Integer cost) {
			this.destination = destination;
			this.cost = cost;
		}
	}


	Map<Integer, List<Route>> graph = new HashMap<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    	if (src == dst) {
            return 0;
        }
    	int minimumCost = Integer.MAX_VALUE;
    	City[] cities = new City[n];
    	boolean[] visited = new boolean[n];
		int hops = 0;

    	for (int[] flight : flights) {
    		if (!graph.containsKey(flight[0])) {
    			graph.put(flight[0], new ArrayList<>());
    		}
    		graph.get(flight[0]).add(new Route(flight[1], flight[2]));
    	}
                

    	Queue<City> pQueue = new PriorityQueue<City>(new Comparator<City>(){
    		public int compare (City a, City b) {
    			return a.minCostToSource - b.minCostToSource;
    		}
    	});

    	for (int i = 0; i < n; i++) {
    		cities[i] = new City(i, Integer.MAX_VALUE, new HashMap<>());
    		if (i == src) {
    			cities[i].minCostToSource = 0;
                cities[i].costMap.put(-1, 0);                
    		}
    		pQueue.add(cities[i]);
    	}

    	

    	while (!pQueue.isEmpty()) {    		
    		City current = pQueue.poll();                        
    		visited[current.id] = true;
    		List<Route> routesFromCurrent = graph.get(current.id);
            if (routesFromCurrent != null) {
                for (Route route : routesFromCurrent) {
                    if (!visited[route.destination]) {
                        pQueue.remove(cities[route.destination]);                        
                        for (Map.Entry<Integer, Integer> currentHopCost : current.costMap.entrySet()) {
                            int costToSource = current.minCostToSource + route.cost;
                            int prevHops = currentHopCost.getKey();             
                            if (!cities[route.destination].costMap.containsKey(prevHops + 1)) {
                                cities[route.destination].costMap.put(prevHops + 1, current.costMap.get(prevHops) + route.cost);    
                            } else {
                                int existingCost = cities[route.destination].costMap.get(prevHops + 1);
                                int currentCost = current.costMap.get(prevHops) + route.cost;
                                if (currentCost < existingCost) {
                                    cities[route.destination].costMap.put(prevHops + 1, currentCost);    
                                }
                            }
                            
                            if (cities[route.destination].minCostToSource > costToSource) {
                                cities[route.destination].minCostToSource = costToSource;                                
                            }                            
                        }                                                
                        pQueue.add(cities[route.destination]);	                        
                    }    			
                }            
            }
    	}


    	for (Map.Entry<Integer, Integer> costMapEntry : cities[dst].costMap.entrySet()) {
            if (costMapEntry.getKey() <= K) {
                minimumCost = minimumCost > costMapEntry.getValue() ? costMapEntry.getValue() : minimumCost;
            }
        } 

        

    	return minimumCost == Integer.MAX_VALUE ? -1 : minimumCost;

    }


}