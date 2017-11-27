/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*You are required to complete below method */

//https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1

class GfG
{
    void countDistinct(int A[], int k, int n) {
		
		List<Integer> distinct = new ArrayList<>();
    	Map<Integer, Integer> map = new HashMap<>();
    	int windowSize = 0;
    	int index = 0;
    	while (index < A.length) {
    		windowSize = windowSize < k ? windowSize + 1 : windowSize;
    		map.put(A[index], map.containsKey(A[index]) ? map.get(A[index]) + 1 : 1);
			if (index - k >= 0) {
				map.put(A[index - k],  map.get(A[index - k]) - 1);
				if (map.get(A[index - k]) <= 0) {
					map.remove(A[index - k]);
				}
			} 			
    		if (windowSize == k) {    			
    			distinct.add(map.size());
    		}
    		index++;
    	}

    	for (Integer val : distinct) {
    		System.out.print(val + " ");
    	}
    	System.out.println();
    }
}
