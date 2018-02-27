import java.util.*;
import java.lang.*;
import java.io.*;

class MagicalString {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		MagicalString ms = new MagicalString();
		System.out.println(ms.magicalString(n));
	}

    public int magicalString(int n) {
    	if (n <= 0) {
    		return 0;
    	}
    	if (n <= 3) {
    		return 1;
    	}
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;
        int lIndex = 2;
        int rIndex = 3;
        int count = 1;
        while (rIndex < n) {
        	int sCount = arr[lIndex];        	
        	int val = arr[rIndex - 1] == 1 ? 2 : 1;        	        	
        	
        	while (sCount > 0 && rIndex < n) {
        		arr[rIndex] = val;
        		count += val == 1 ? 1 : 0;
        		rIndex++;
        		sCount--;
        	}
        	lIndex++;
        	
        }
        
        return count;
    }
}