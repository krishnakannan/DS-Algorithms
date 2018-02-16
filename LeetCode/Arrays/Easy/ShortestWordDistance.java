class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {

    	Map<String, List<Integer>> map = new HashMap<>();
    	int shortestDistance = Integer.MAX_VALUE;
    	for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                map.put(words[i], new ArrayList<>());
                map.get(words[i]).add(i);
            }    		
    	}

    	List<Integer> w1IndexList = map.get(word1);
    	List<Integer> w2IndexList = map.get(word2);

    	for (Integer w1Index : w1IndexList) {
    		for (Integer w2Index : w2IndexList) {
    			int diff = diff (w1Index, w2Index);
    			shortestDistance = shortestDistance > diff ? diff : shortestDistance;
    		}
    	}

    	return shortestDistance;
    }

    public int diff(int a, int b) {
    	return a > b ? a - b : b - a;
    }
}