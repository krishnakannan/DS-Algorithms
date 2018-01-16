import java.util.*;
import java.lang.*;

class MonotoneIncreasing {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		MonotoneIncreasing mi = new MonotoneIncreasing();
		System.out.println(mi.monotoneIncreasingDigits(num));
	}

    public int monotoneIncreasingDigits(int num) {
    	if (num < 10) {
    		return num;
    	}
		int[] numArray = serialize(num);
		findMonotoneIncreasing(numArray);
		int val = deserialize(numArray);
		return val;
    }

    public void findMonotoneIncreasing(int[] numArray) {
    	int i = 0;
    	int j = 1;
    	while (i < j && i < numArray.length && j < numArray.length) {
    		if (numArray[i] < numArray[j]) {    			
    			j++;    			
    			i = j - 1;
    		} else if (numArray[i] == numArray[j]) {
    			j++;
    		} else if (numArray[i] > numArray[j]) {    			
    			numArray[i]--;
    			i++;
    			while (i < numArray.length) {
    				numArray[i] = 9;
    				i++;
    			}
    		}    		
    	}
    }

    public int[] serialize(int num) {
    	int length = (int) (Math.log10(num) + 1);    	
    	int[] numArray = new int[length];
    	int index = length - 1;
    	while (num > 0) {
    		numArray[index] = num % 10;
    		num = num / 10;
    		index--;
    	}
    	return numArray;
    }

    public int deserialize(int[] numArray) {    	    
    	int val = 0;    	
    	for (int i = 0; i < numArray.length; i++) {
    		val += numArray[i];
    		if (i < numArray.length - 1) {
    			val *= 10;	
    		}    		
    	}
    	return val;
    }
}