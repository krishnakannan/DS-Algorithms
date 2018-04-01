public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
		int mLength = magazine.length();
		int rLength = ransomNote.length();
        for (int i = 0; i < mLength; i++) {
			magazineMap.put(magazine.charAt(i), magazineMap.containsKey(magazine.charAt(i)) ? magazineMap.get(magazine.charAt(i)) + 1 : 1);
        }

        for (int i = 0; i < rLength; i++) {
        	if (magazineMap.containsKey(ransomNote.charAt(i)) && magazineMap.get(ransomNote.charAt(i)) > 0) {
        		magazineMap.put(ransomNote.charAt(i), magazineMap.get(ransomNote.charAt(i)) - 1);
        	} else {
        		return false;
        	}
        }
        
        return true;    
    }
}