class Solution {

	
	Map<Integer, Set<Integer>> aList;
	Map<Integer, Integer> indegrees;
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        
        aList = new HashMap<>();
        indegrees = new HashMap<>();
    	for (List<Integer> seq : seqs) {

    		int size = seq.size();
    		if (size == 1) {
    			if (!aList.containsKey(seq.get(0))) {
    				aList.put(seq.get(0), new HashSet<>());
    				indegrees.put(seq.get(0), 0);
    			}    			
    		} else {
    			for (int i = 1; i < size; i++) {
    				if (!aList.containsKey(seq.get(i - 1))) {
	    				aList.put(seq.get(i - 1), new HashSet<>());
	    				indegrees.put(seq.get(i - 1), 0);
	    			}	

	    			if (!aList.containsKey(seq.get(i))) {
	    				aList.put(seq.get(i), new HashSet<>());
	    				indegrees.put(seq.get(i), 0);
	    			}

	    			if (aList.get(seq.get(i - 1)).add(seq.get(i))) {
	    				indegrees.put(seq.get(i), indegrees.get(seq.get(i)) + 1);
	    			}
	    		}
    		}     		   		
    	}
        
    	Queue<Integer> bfsQ = new LinkedList<>();
    	for (Map.Entry<Integer, Integer> indegree : indegrees.entrySet()) {
    		if (indegree.getValue() == 0) {
    			bfsQ.add(indegree.getKey());
    		}
    	}

    	
    	int oIndex = 0;
    	while (!bfsQ.isEmpty()) {            
    		if (bfsQ.size() > 1) {                
	    		return false;
	    	}
    		int polled = bfsQ.poll();
    		if (oIndex >= org.length || polled != org[oIndex]) {                
    			return false;
    		}
    		oIndex++;
    		for (Integer neighbor : aList.get(polled)) {
    			indegrees.put(neighbor, indegrees.get(neighbor) - 1);                
    			if (indegrees.get(neighbor) == 0) {
    				bfsQ.add(neighbor);                    
    			}
    		}            
    	}
        
        
    	return oIndex == org.length && oIndex == aList.size();
    }
}