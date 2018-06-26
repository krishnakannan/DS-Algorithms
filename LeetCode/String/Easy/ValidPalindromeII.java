class Solution {
    public boolean validPalindrome(String s) {
        int left = 0; 
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left += 1;
                right -= 1;
            } else {
                break;
            }
        }
        if (left > right) {
            return true;
        }
        return isPalindrome(s.substring(left + 1, right + 1)) || isPalindrome(s.substring(left, right));
    }
    
    public boolean isPalindrome(String s) {
        //System.out.println(s);
        int left = 0; 
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}