class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.equals(B)) {
            Set<Character> charSet = new HashSet<>();
            for (int i = 0; i < A.length(); i++) {
                charSet.add(A.charAt(i));                
            }
            return charSet.size() < A.length();
        }
        
        if (A.length() != B.length()) {
            return false;
        }
        
        int first = -1;
        int second = -1;
        
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        
        return A.charAt(first) == B.charAt(second) && B.charAt(first) == A.charAt(second);
        
    }
}