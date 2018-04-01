public class Solution {
    public boolean isPerfectSquare(int num) {
        long square = 1l;
        long n = 1l;

        while (num >= square) {
        	if (num == square) {
        		return true;
        	}
        	n++;
        	System.out.println(square);
        	square = n * n;
        }
        return false;   
    }
}