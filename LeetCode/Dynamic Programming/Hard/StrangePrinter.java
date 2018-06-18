import java.util.*;
import java.lang.*;
import java.io.*;

class StrangePrinter {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		StrangePrinter sp = new StrangePrinter();
		System.out.println(sp.strangePrinter(s));
	}

	int[][] memo;

    public int strangePrinter(String s) {
        memo = new int[s.length()][s.length()];
        return count(s, 0, s.length() - 1);
    }

    public int count(String s, int start, int end) {

    	if (start > end) {
    		return 0;
    	}

    	if (memo[start][end] != 0) {
    		return memo[start][end];
    	}

    	int min = count(s, start + 1, end) + 1;
    	for (int i = start + 1; i <= end; i++) {
    		if (s.charAt(start) == s.charAt(i)) {
    			 min = min(min, count(s, start, i - 1) + count(s, i + 1, end));
    		}
    	}
    	memo[start][end] = min;
    	return memo[start][end];
    }

    public int min(int a, int b) {
    	return a > b ? b : a;
    }
}