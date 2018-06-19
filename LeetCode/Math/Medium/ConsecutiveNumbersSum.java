import java.util.*;
import java.lang.*;
import java.io.*;

class ConsecutiveNumbersSum {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ConsecutiveNumbersSum cns = new ConsecutiveNumbersSum();
		System.out.println(cns.consecutiveNumbersSum(N));
	}

    public int consecutiveNumbersSum(int N) {
    	int consecutiveNumbersSumCount = 0;
        int sqrt = (int)(Math.sqrt(N));        
        for (int i = 1; i <= sqrt; i++) {
        	if (N % i == 0) {
        		int j = N / i;
        		if (i % 2 != 0) {
        			consecutiveNumbersSumCount += 1;
        		}
        		if (i != j && j % 2 != 0) {
        			consecutiveNumbersSumCount += 1;	
        		}
        	}
        }	
        return consecutiveNumbersSumCount;
    }
}