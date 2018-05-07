import java.util.*;
import java.lang.*;   
import java.io.*;

class NonNegIntWithoutConsecutiveOnes {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		NonNegIntWithoutConsecutiveOnes nniwco = new NonNegIntWithoutConsecutiveOnes();
		System.out.println(nniwco.findIntegers(num));		
	}

    public int findIntegers(int num) {
    	int[] dp = new int[33];
    	dp[0] = 1;
    	dp[1] = 2;
    	for (int i = 2; i < dp.length; i++) {
    		dp[i] = dp[i - 1] + dp[i - 2];
    	}
    	char[] number = Integer.toBinaryString(num).toCharArray();
    	int count = 0;
    	int i = 0;
    	for (; i < number.length; i++) {
    		if (number[i] == '1') {
    			int rightDigits = number.length - i - 1;
    			count += dp[rightDigits];
    			if (i > 0 && number[i - 1] == '1') {
    				break;
    			}
    		}
    	}

    	if (i == number.length) {
    		count += 1;
    	}

    	return count;
    }
}