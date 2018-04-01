public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int len = s.length();
        int max = 0;
        while (i < len && j < len){
            if (list.contains(s.charAt(j))) {
                list.remove((Character)s.charAt(i++));
            } else {
                list.add(s.charAt(j++));
                max = max > (j - i) ? max : (j - i);
            }
        }
        return max;
    }
}