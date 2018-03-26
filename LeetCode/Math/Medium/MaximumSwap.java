import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumSwap {

	public static void main(String argss[]) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		MaximumSwap ms = new MaximumSwap();
		System.out.println(ms.maximumSwap(num));
	}

    public int maximumSwap(int num) {
        
        char[] numArray = Integer.toString(num).toCharArray();

    	int[] suffixArray = new int[numArray.length];    	

    	suffixArray[suffixArray.length - 1] = numArray[numArray.length - 1] - '0';

    	for (int i = numArray.length - 2; i >= 0; i--) {
    		if (suffixArray[i + 1] > numArray[i] - '0') {
    			suffixArray[i] = suffixArray[i + 1];
    		} else {
    			suffixArray[i] = numArray[i] - '0';
    		}
    	}

    	for (int i = 0; i < numArray.length; i++) {
    		if (suffixArray[i] > (numArray[i] - '0')) {
    			//MaxFound    			
    			int maxIndex = i;
    			int maxNumber = suffixArray[i];
    			while (maxIndex < suffixArray.length - 1) {
    				if (suffixArray[maxIndex] == suffixArray[maxIndex + 1]) {    					
    					maxIndex++;    					
    				} else {
    					//This is the maxIndex;    					
    					char t = numArray[i];
    					numArray[i] = numArray[maxIndex];
    					numArray[maxIndex] = t;
    					return getInt(numArray);
    				}
    			}
    			char t = numArray[i];
				numArray[i] = numArray[maxIndex];
				numArray[maxIndex] = t;
				return getInt(numArray);    			
    		}
    	}

    	return num;
    } 	

    public int getInt(char[] num) {
    	int val = 0;
    	int index = 0;
    	while (index < num.length) {
    		val *= 10;
    		val += num[index] - '0';
    		index++;
    	}
    	return val;
    }

    
}