class Solution {
	
	
	/*
		DFS, BFS - Either results in StackOverflow or TLE
		Simple Algorithm;

		Keep deleteing the leaves;
		Nodes with only one entry in Adjacency List is Leaf.
		Keep deleting until you are left with either 1 or 2 nodes;
		those two / one are the roots
	*/
    
	Map<Integer, List<Integer>> aList;
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        aList = new HashMap<>();                
        //Create Adjacency List

        for (int[] edge : edges) {
        	if (!aList.containsKey(edge[0])) {
        		aList.put(edge[0], new ArrayList<>());
        	}

        	if (!aList.containsKey(edge[1])) {
        		aList.put(edge[1], new ArrayList<>());
        	}

        	aList.get(edge[0]).add(edge[1]);
        	aList.get(edge[1]).add(edge[0]);
        }        


        List<Integer> leaves = new ArrayList<>();
		for (Integer i = 0; i < n; i++) {
		    if (aList.get(i).size() == 1) {
		    	leaves.add(i);			    	
		    } 
		}
        
        
        while (n > 2) {
        	n -= leaves.size();

        	List<Integer> nLeaves = new ArrayList<>();

        	for (Integer leaf : leaves) {
        		Integer parent = aList.get(leaf).get(0);
        		aList.remove(leaf);
        		aList.get(parent).remove(leaf);
        		if (aList.get(parent).size() == 1) {
        			nLeaves.add(parent);
        		}
        	}

        	leaves = nLeaves;
        }

        return leaves;
        
    }


}