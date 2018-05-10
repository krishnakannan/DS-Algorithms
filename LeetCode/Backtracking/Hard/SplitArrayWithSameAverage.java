import java.util.*;
import java.lang.*;   
import java.io.*;

class SplitArrayWithSameAverage {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		SplitArrayWithSameAverage sawsa = new SplitArrayWithSameAverage();
		int n = in.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = in.nextInt();
		}
		System.out.println(sawsa.splitArraySameAverage(A));
	}

	//Carefully/Manually tweaked the subarray splits. Can do better

	public boolean splitArraySameAverage(int[] A) {
        if (A.length == 1) {
            return false;
        }
        Arrays.sort(A);
    	double avg = 0d;
    	double sums = 0d;    	
    	for (int i = 0; i < A.length; i++) {
    		sums += A[i];
    	}
    	avg = sums / A.length;
        double temp = 0;    
        for (int i = 0; i < A.length - 1; i++) {
            temp += A[i];
            if (temp * 2 >= sums) {
                break;
            }
        }               
        if (sums - temp > temp) {
            return false;
        }        
        if (A.length <= 12) {
            return splitAndCalculate(A, 0d, 0, A.length - 1, 0d, avg);
        }
        int mid = A.length / 2;
        int fLow = 0;
        int fHigh = mid + 6;
        int sLow = mid - 6;
        int sHigh = A.length - 1;
        
    	
    	boolean can = splitAndCalculate(A, 0d, fLow, fHigh, 0d, avg) 
            || splitAndCalculate(A, 0d, sLow, sHigh, 0d, avg) ;
		return can;
    }

    public boolean splitAndCalculate(int[] nums, double sums, int startIndex, int endIndex, double addedCount, double targetAvg) {        
            
    	if (startIndex >= endIndex) {
    		return false;
    	}
    	boolean hasFound = false;

    	for (int i = startIndex; i <= endIndex; i++) {
    		if (!hasFound) {
    			sums += nums[i];    			
	    		addedCount += 1;
	    		double avg = sums / addedCount;
	    		//System.out.println("AVG " + avg + " TARGET " + targetAvg + " ADDEDSOFAR " + addedCount);
	    		if (avg == targetAvg && addedCount < nums.length) {
	    			return true;
	    		} else if (avg > targetAvg) {
                    continue;
	    			//return false;
	    		} else {
	    			hasFound = splitAndCalculate(nums, sums, i + 1, endIndex, addedCount, targetAvg);
	    		}
	    		addedCount -= 1;	    		
	    		sums -= nums[i];	
    		} else {
    			return hasFound;
    		}
    	}
 		return hasFound;
    }
}