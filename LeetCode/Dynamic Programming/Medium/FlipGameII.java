class Solution {

	Map<String, Boolean> canWinMap = new HashMap<>();

    public boolean canWin(String s) {
        return play(s);
    }

    public boolean play(String s) {
        //System.out.println(s);
    	if (canWinMap.containsKey(s)) {
    		return canWinMap.get(s);
    	}

    	int sLength = s.length();
    	boolean canWin = false;
        
        for (int index = 0; index < sLength - 1; index++) {
            if (s.charAt(index) == '+' && s.charAt(index + 1) == '+') {
                String newString = s.substring(0, index) + "--" + s.substring(index + 2);        
                if (!play(newString)) {
                    canWinMap.put(s, true);
                    return true;
                } 			 			
            }
        }
    	canWinMap.put(s, false);
    	return false;
    }
}