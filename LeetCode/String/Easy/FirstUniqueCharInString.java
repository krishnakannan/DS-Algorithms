public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> sMap = new HashMap<>();
        int sLen = s.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sLen; i++) {
        	sMap.put(s.charAt(i), sMap.containsKey(s.charAt(i)) ? -1 : i);
        }
        for (Map.Entry<Character, Integer> x : sMap.entrySet()) {
        	if (x.getValue() >= 0 && x.getValue() < min) {
        		min = x.getValue();
        	}
        }
        return min == Integer.MAX_VALUE ? -1 : min;    
    }
}