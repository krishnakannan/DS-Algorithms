class Solution {

	Map<String, List<String>> map = new HashMap<>();

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

    	if (words1.length != words2.length) {
    		return false;
    	}

     	for (String[] pair : pairs) {
     		if (!map.containsKey(pair[0])) {
     			map.put(pair[0], new ArrayList<>());
     		}
     		if (!map.containsKey(pair[1])) {
     			map.put(pair[1], new ArrayList<>());
     		}
     		map.get(pair[0]).add(pair[1]);
			map.get(pair[1]).add(pair[0]);
     	}   
    
        //System.out.println(dictionary);
        
     	for (int i = 0; i < words1.length; i++) {
     		if (!words1[i].equals(words2[i])) {
                if (map.containsKey(words1[i])) {
                    if (!map.get(words1[i]).contains(words2[i])) {
                        return false;
                    }
                } else {    
                    System.out.println(words1[i]);
                    return false;
                }
            }
     	}
 		return true;
    }
}