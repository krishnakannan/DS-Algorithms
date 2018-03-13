class Solution {

	Map<String, List<Character>> allowedMap = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        populateMap(allowed);
        
    	List<Set<Character>> bottomSet = new ArrayList<>();
    	for (Character c : bottom.toCharArray()) {
    		Set<Character> cSet = new LinkedHashSet<>();
    		cSet.add(c);
    		bottomSet.add(cSet);
    	}

        return buildPyramid(bottomSet, bottom.length());
    }

    public boolean buildPyramid(List<Set<Character>> current, int currentLevel) {
        
        //System.out.println(current);
        
    	if (currentLevel == 1) {    		
    		if (current.size() == 1) {
    			return true;
    		} else {
    			return false;
    		}
    	}

    	List<Set<Character>> nextLevel = new ArrayList<>();
    	int left = 0;
    	int right = left + 1;
    	int cSize = current.size();

    	while (right < cSize) {
    		Set<Character> first = current.get(left);
    		Set<Character> second = current.get(right);
    		Set<Character> child = new LinkedHashSet<>();
    		boolean containsChild = false;
            
            for (Character fc : first) {
                for (Character sc : second) {
                    String tempString = fc + "" + sc;                    
    				if (allowedMap.containsKey(tempString)) {
    					child.addAll(allowedMap.get(tempString));
    					containsChild = true;
    				}
                }
            }            
    		if (!containsChild) {
    			return false;
    		}
    		nextLevel.add(child);
    		left++;
    		right++;
    	}

    	return buildPyramid(nextLevel, currentLevel - 1);

    }



    public void populateMap(List<String> allowed) {
    	for (String allowedString : allowed) {
    		String substr = allowedString.substring(0, 2);
    		if (!allowedMap.containsKey(substr)) {
    			allowedMap.put(substr, new ArrayList<>());
    		}
    		allowedMap.get(substr).add(allowedString.charAt(2));
    	}        
    }
}