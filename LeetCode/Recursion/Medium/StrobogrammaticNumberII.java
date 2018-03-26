import java.util.*;
import java.lang.*;
import java.io.*;

class StrobogrammaticNumberII {


	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StrobogrammaticNumberII sgn = new StrobogrammaticNumberII();
		System.out.println(sgn.findStrobogrammatic(n));
	}
	
    char[][] strobogrammaticPairs = new char[][]{{'0','0'}, {'1','1'}, {'6','9'}, {'8','8'}, {'9','6'}};

	List<String> strobogrammaticNumbers;

    public List<String> findStrobogrammatic(int n) {
        strobogrammaticNumbers = new ArrayList<>();
        if (n == 1) {
            strobogrammaticNumbers.add("0");
        }
        formStrobogrammaticNumber(new char[n], 0, n - 1);
        return strobogrammaticNumbers;
    }

    public void formStrobogrammaticNumber(char[] formedSGNumber, int start, int end) {

    	if (start > end) {
    		strobogrammaticNumbers.add(new String(formedSGNumber));
    		return;
    	}

    	for (char[] strobogrammaticPair : strobogrammaticPairs) {

    		if (start == 0 && strobogrammaticPair[0] == '0') {
    			continue;
    		}

    		if (start == end && (strobogrammaticPair[0] == '6' || strobogrammaticPair[0] == '9')) {
    			continue;
    		}

    		formedSGNumber[start] = strobogrammaticPair[0];
    		formedSGNumber[end] = strobogrammaticPair[1];

    		formStrobogrammaticNumber(formedSGNumber, start + 1, end - 1);

    	}
    }
}