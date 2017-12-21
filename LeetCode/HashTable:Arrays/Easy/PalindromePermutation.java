class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] sArray = s.toCharArray();
        int[] cMap = new int[128];
        for (int i = 0; i < sArray.length; i++) {
        	cMap[(int) sArray[i]]++;
        }
        boolean singleCharOccured = false;

        for (int i = 0; i < cMap.length; i++) {
        	if (cMap[i] % 2 != 0) {
        		if (!singleCharOccured) {
        			singleCharOccured = true;        			
        		} else {
        			return false;
        		}
        	}
        }      
        return true;
    }


/*

HASHMAP IMPLEMENTATION - Slower(Not Asymptotically) than Array Implementation

class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] sArray = s.toCharArray();
        Map<Character, Integer> cMap = new HashMap<>();
        for (int i = 0; i < sArray.length; i++) {
        	cMap.put(sArray[i], cMap.containsKey(sArray[i]) ? cMap.get(sArray[i]) + 1 : 1);
        }
        boolean singleCharOccured = false;

        for (Map.Entry<Character, Integer> entry : cMap.entrySet()) {
        	if (entry.getValue() % 2 != 0) {
        		if (!singleCharOccured) {
        			singleCharOccured = true;        			
        		} else {
        			return false;
        		}
        	}
        }
        return true;
    }
}

*/