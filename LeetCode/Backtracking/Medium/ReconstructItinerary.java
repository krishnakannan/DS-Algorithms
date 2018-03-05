class ReconstructItinerary {

List<String> finalRoute = new ArrayList<>();
    boolean reconstructed = false;
    public List<String> findItinerary(String[][] tickets) {                
        Map<String, List<String>> aList = new HashMap<>();
        int finalCount = 0;
        
        for (int i = 0; i < tickets.length; i++) {
        	if (!aList.containsKey(tickets[i][0])) {
        		aList.put(tickets[i][0], new ArrayList<>());                
        	}
        	finalCount++;
        	aList.get(tickets[i][0]).add(tickets[i][1]);
        }

        for (Map.Entry<String, List<String>> entry : aList.entrySet()) {
        	Collections.sort(entry.getValue());        	
        }        
        List<String> route = new ArrayList<>();
        route.add("JFK");
        backtrack(aList, route, "JFK", 0, finalCount);    
        return finalRoute;    
    }

    public void backtrack(Map<String, List<String>> aList, List<String> route, String currentCity, int currentLength, int finalLength) {
        
        if (currentLength == finalLength) {    			
                finalRoute.addAll(route);
    			reconstructed = true;    			
            return;
        }
        
    	if (!aList.containsKey(currentCity)) {            
    		return;
    	}
        

        List<String> destinations = aList.get(currentCity);
        for (int i = 0; i < destinations.size(); i++) {
        	if (!reconstructed) {
        		route.add(destinations.get(i));
        		List<String> newDestinations = new ArrayList<>(destinations);
        		newDestinations.remove(destinations.get(i));
        		aList.put(currentCity, newDestinations);
        		backtrack(aList, route, destinations.get(i), currentLength + 1, finalLength);
        		aList.put(currentCity, destinations);
        		route.remove(route.size() - 1);
        	} else {
        		return;
        	}
        }
    }
}
}