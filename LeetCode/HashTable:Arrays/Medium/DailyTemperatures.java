class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
    	int[] higher = new int[temperatures.length];
        Arrays.fill(higher, Integer.MAX_VALUE);
		Map<Integer, TreeSet<Integer>> map = new HashMap<>();
		for (int i = 0; i < temperatures.length; i++) {
			if (map.containsKey(temperatures[i])) {
				map.get(temperatures[i]).add(i);
			} else {
				map.put(temperatures[i], new TreeSet<>());
				map.get(temperatures[i]).add(i);
			}
		}

		for (int i = 0; i < temperatures.length; i++) {
			int currentTemp = temperatures[i];            
			for (int t = currentTemp + 1; t <= 100; t++) {                
				if (map.containsKey(t)) {                 
					TreeSet<Integer> higherTempSet = map.get(t);	
					Integer higherThanCurrent = map.get(t).higher(i);
                    if (higherThanCurrent != null) {
                        int indexDiff = higherThanCurrent - i;
                        higher[i] = higher[i] > indexDiff ? indexDiff : higher[i];
                    }
				}				
			}
		}
        
        for (int i = 0; i < higher.length; i++) {
            higher[i] = higher[i] == Integer.MAX_VALUE ? 0 : higher[i];
        }

		return higher;
	}
}

/*

	Above Set based soln - 440 ms

	Stack Based - Official Soln - 75ms

	class Solution {
	    public int[] dailyTemperatures(int[] T) {
	        int[] ans = new int[T.length];
	        Stack<Integer> stack = new Stack();
	        for (int i = T.length - 1; i >= 0; --i) {
	            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
	            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
	            stack.push(i);
	        }
	        return ans;
	    }
	}

*/