public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char x = s.charAt(i);
            if ( ((int)x >= 65 && (int)x < 91) || ((int)x >= 97 && (int)x < 123) || ((int)x >= 48 && (int)x < 58)) {
                sb.append(x);
            }
        }
        int i = 0;
        int j = sb.length() - 1;
        System.out.println(sb.toString());
        while (j >= i) {
            if (Character.getNumericValue(sb.charAt(i)) != (Character.getNumericValue(sb.charAt(j)))) {
                return false;
            }
            j--;
            i++;
        }
        
        return true;
    }
}