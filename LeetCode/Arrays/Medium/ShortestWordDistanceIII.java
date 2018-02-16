class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
     
    	Map<String, List<Integer>> map = new HashMap<>();    	
    	for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                map.put(words[i], new ArrayList<>());
                map.get(words[i]).add(i);
            }    		
    	}
        
        
        int shortestDistance = Integer.MAX_VALUE;        
        List<Integer> w1IndexList = map.get(word1);
    	List<Integer> w2IndexList = map.get(word2);
        int w1Length = w1IndexList.size();
        int w2Length = w2IndexList.size();
        

        for(int i = 0, j = 0; i < w1Length && j < w2Length; ) {
            int w1Index = w1IndexList.get(i);
            int w2Index = w2IndexList.get(j);
            if (w1Index == w2Index) {
                i++;
                continue;
            }
            int diff = diff(w1Index, w2Index);
            if(w1Index < w2Index) {                
                i++;
            } else {                
                j++;
            }
            shortestDistance = shortestDistance > diff ? diff : shortestDistance;
        }       

    	return shortestDistance;
    }

    public int diff(int a, int b) {
    	return a > b ? a - b : b - a;
    }
}