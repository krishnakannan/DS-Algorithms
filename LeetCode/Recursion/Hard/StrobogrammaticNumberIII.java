import java.util.*;
import java.lang.*;   
import java.io.*;


class StrobogrammaticNumberIII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String low = in.next();
		String high = in.next();
		StrobogrammaticNumberIII sbn = new StrobogrammaticNumberIII();
		System.out.println(sbn.strobogrammaticInRange(low, high));
	}

	char[][] strobogrammaticPairs = new char[][]{{'0','0'}, {'1','1'}, {'6','9'}, {'8','8'}, {'9','6'}};

	int strobogrammaticNumbers = 0;
	boolean limitExceeded = false;

    public int strobogrammaticInRange(String l, String h) {
    	long low = getLong(l.toCharArray());
    	long high = getLong(h.toCharArray());
    	int lDigits = getDigits(low);
    	int hDigits = getDigits(high);
    	for (int i = lDigits; i <= hDigits; i++) {
    		formStrobogrammaticNumber(new char[i], 0, i - 1, low, high, lDigits, hDigits);
    	}
        return strobogrammaticNumbers;
    }

    public void formStrobogrammaticNumber(char[] formedSGNumber, int start, int end, long low, long high, int lDigits, int hDigits) {
    	if (start > end) {    		            
    		if (formedSGNumber.length > lDigits && formedSGNumber.length < hDigits) {                
    			strobogrammaticNumbers += 1;
    		} else {
                long formed = getLong(formedSGNumber);
    			if (formedSGNumber.length == lDigits) {
    				if (formed >= low && formed <= high) {                        
    					strobogrammaticNumbers += 1;
    				}
    			} else if (formedSGNumber.length == hDigits) {
    				if (formed <= high) {                        
    					strobogrammaticNumbers += 1;	
    				}
    			}
                
                if (lDigits == hDigits) {
                    if (formed > high) {
                        limitExceeded = true;
                    }
                }
    		}
    		return;
    	}

    	for (char[] strobogrammaticPair : strobogrammaticPairs) {
    		if (start == 0 && strobogrammaticPair[0] == '0' && formedSGNumber.length != 1) {
    			continue;
    		}
    		if (start == end && (strobogrammaticPair[0] == '6' || strobogrammaticPair[0] == '9')) {
    			continue;
    		}
    		formedSGNumber[start] = strobogrammaticPair[0];
    		formedSGNumber[end] = strobogrammaticPair[1];
    		if (!limitExceeded) {
    			formStrobogrammaticNumber(formedSGNumber, start + 1, end - 1, low, high, lDigits, hDigits);	
    		}    		
    	}
    }

    public long getLong(char[] num) {
    	long val = 0l;
    	for (int i = 0; i < num.length; i++) {
    		val *= 10;
    		val += num[i] - '0';
    	}
    	return val;
    }
    
    public int getDigits(long num) {
        return num == 0 ? 1 : (int) (Math.log10(num) + 1);
    }
}