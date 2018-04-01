public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] charMap = new int[256];		

        int sLength = s.length();
        int pLength = p.length();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < pLength; i++) {
        	charMap[p.charAt(i)]++;
        }
        int left = 0, right = 0, count = p.length();
    	while (right < s.length()) {
        if (charMap[s.charAt(right++)]-- >= 1) {
        	count--; 
        }
        
        if (count == 0) {
        	list.add(left);
        }
    
        if (right - left == p.length() && charMap[s.charAt(left++)]++ >= 0) {
        	count++;	
        } 
    }

        return list;   
    }
}