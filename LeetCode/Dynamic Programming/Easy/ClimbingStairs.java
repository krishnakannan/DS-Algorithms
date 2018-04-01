public class Solution {
    public int climbStairs(int n) {
        int first = 1;
        int second = 2;
        int third = 0;
        
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n > 2) {
            n -= 2;
            while (n-- > 0) {
                third = first + second;
                first = second;
                second = third;
            }    
        }
        
        
        return third;
    }
}