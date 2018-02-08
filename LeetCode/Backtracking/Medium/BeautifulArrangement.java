import java.util.*;
import java.lang.*;
import java.io.*;

class BeautifulArrangement {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		BeautifulArrangement ba = new BeautifulArrangement();
		System.out.println(ba.countArrangement(n));
	}

	int beautifulArrangementCount = 0;
	boolean[] used;

    public int countArrangement(int n) {
    	used = new boolean[n];
    	int[] array = new int[n];
    	arrange(array, 0);
        return beautifulArrangementCount;
    }

    public void arrange(int[] array, int index) {

    	if (index >= array.length) {
    		return;
    	}

    	if (index == array.length - 1) {
    		for (int i = 1; i <= array.length; i++) {
    			if (!used[i - 1]) {
    				array[index] = i;
    				if (divisibilityTest(index + 1, array[index])) {
		    			beautifulArrangementCount++;
		    			array[index] = 0;
		    			return;
		    		}
    			}
    		}
    		return;    		
    	}

    	for (int i = 1; i <= array.length; i++) {
			if (!used[i - 1]) {
				array[index] = i;
				if (divisibilityTest(index + 1, array[index])) {					
	    			used[i - 1] = true;
	    			arrange(array, index + 1);
	    			used[i - 1] = false;	    			
	    		}
	    		array[index] = 0;
			}
		}


    }


    public boolean divisibilityTest(int index, int number) {
    	return index % number == 0 || number % index == 0;
    }

}