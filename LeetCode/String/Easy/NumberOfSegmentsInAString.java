public class Solution {
    public int countSegments(String s) {
        //NOT MY SOLN
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' ')) {
                count++;
            }
        }    
        return count;
        
    }
}