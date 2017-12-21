class Solution {

	class Pair {
		public int a;
		public int b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<int[]> pairs = new ArrayList<>();	
    	Queue<Pair> pairsHeap = new PriorityQueue<Pair>(new Comparator<Pair>(){
    		public int compare(Pair one, Pair two) {
    			int val1 = one.a + one.b;
    			int val2 = two.a + two.b;
    			if (val1 != val2) {
    				return val1 - val2;
    			} else {
    				return one.a - two.a; 
    			}
    		}
    	});



    	for (int i = 0; i < nums1.length; i++) {
    		for (int j = 0; j < nums2.length; j++) {
    			pairsHeap.add(new Pair(nums1[i], nums2[j]));
    		}
    	}

    	while (--k >= 0 && !pairsHeap.isEmpty()) {
    		int[] pair = new int[2];
    		pair[0] = pairsHeap.peek().a;
    		pair[1] = pairsHeap.peek().b;
    		pairsHeap.poll();
    		pairs.add(pair);
     	}
     	return pairs();

    }
}