import java.util.*;
import java.lang.*;   
import java.io.*;

class DecodeWaysII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		DecodeWaysII dw2 = new DecodeWaysII();
		System.out.println(dw2.numDecodings(s));
	}

    public int numDecodings(String s) {
        char[] string = s.toCharArray();
        long[] dp = new long[string.length + 1];
        //Dummy Head
        dp[0] = 1; 

        //At 0th Index there can be 2 options - either 'n' or '*';
        if (string[0] == '*') {
        	dp[1] = 9;
        } else {
        	dp[1] = string[0] == '0' ? 0 : 1;
        }        

        for (int i = 2; i < dp.length; i++) {
        	if (string[i - 1] != '0') {
        		dp[i] += getMulValue(s.substring(i - 1,i)) * dp[i - 1];        	
        	} 

        	if (string[i - 2] != '0') {
        		dp[i] += getMulValue(s.substring(i - 2,i)) * dp[i - 2];		        		
        	}

        	dp[i] %= (1000000000 + 7);
        	
        }
        return (int)dp[dp.length - 1];

    }

    public int getMulValue(String x) {    	
    	int count = 0;
    	if (x.length() == 1) {
    		if (x.equals("*")) {
	    		return 9;
	    	} else {
	    		return 1;
	    	}	
    	}     	
    	char[] xArray = x.toCharArray();
    	if (isNum(xArray)) {    		
    		int xVal = getInt(xArray);
    		if (xVal >= 10 && xVal <= 26) {
    			return 1;
    		} else {
    			return 0;
    		}
    	} else {    
    		if (xArray[0] == '*' && xArray[1] == '*') {
    			//Can Form 11 to 26 => 15
    			return 15;
    		} else if (xArray[0] == '*') {    			
    			for (int i = 1; i <= 9; i++) {
    				xArray[0] = (char)(i + '0');
    				int formedValue = getInt(xArray);    				
    				if (formedValue >= 10 && formedValue <= 26) {
    					count += 1;
    				}
    			}
    		} else {    			
    			for (int i = 1; i <= 9; i++) {
    				xArray[1] = (char)(i + '0');    				
    				int formedValue = getInt(xArray);    				
    				if (formedValue >= 10 && formedValue <= 26) {
    					count += 1;
    				}
    			}
    		}
    	}
    	return count;
    }

	public boolean isNum(char[] x) {			
		if (x.length == 1) {
			return x[0] >= '0' && x[0] <= '9';
		}
		return x[0] >= '0' && x[0] <= '9' && x[1] >= '0' && x[1] <= '9';
	}

	public int getInt(char[] c) {
		int val = 0;
		for (int i = 0; i < c.length; i++) {
			val *= 10;
			val += c[i] - '0';
		}
		return val;
	}
}