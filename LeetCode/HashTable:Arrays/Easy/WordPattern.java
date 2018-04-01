public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String strArr[] = str.split(" ");
        int length = pattern.length();
        if (strArr.length != length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> revMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
        	if (map.containsKey(pattern.charAt(i))) {
        		if (!map.get(pattern.charAt(i)).equals(strArr[i])) {
        			return false;
        		}
        		continue;
        	} 
        	
        	if (revMap.containsKey(strArr[i])) {
        	    if (!revMap.get(strArr[i]).equals(pattern.charAt(i))) {
        			return false;
        		}
        		continue;
        	}
        	map.put(pattern.charAt(i), strArr[i]);
        	revMap.put(strArr[i], pattern.charAt(i));
        }
        return true;   
    }
}