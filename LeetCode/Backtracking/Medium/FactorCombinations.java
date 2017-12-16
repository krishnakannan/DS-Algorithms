import java.util.*;
import java.lang.*;
import java.io.*;


class FactorCombinations {

	List<List<Integer>> factors = new ArrayList<>();

	public static void main(String arfsp[]) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		FactorCombinations factors = new FactorCombinations();
		while (--testcases >= 0) {
		    int n = in.nextInt();		   
		    factors.getFactors(n);
 		}
	}


    public List<List<Integer>> getFactors(int n) {
    	if (n == 1) {
            return factors;
        }
        Integer[] factorArray = getFactorsArray(n);        
        calculateFactors(factorArray, n, 1, 0, new ArrayList<>());       	
       	for (List<Integer> list : factors) {       		
        	System.out.println(list);
        }
        return factors;
    }

    public boolean calculateFactors(Integer[] factorArray, int target, int currentValue, 
    		int index, List<Integer> currentFactors) {
    	if (currentValue > target) {
    		return false;
    	}

    	if (target % currentValue != 0) {
    		return false;
    	}

    	if (currentValue == target) {    		
    		factors.add(new ArrayList<>(currentFactors));
    		return true;
    	}

    	
    	for (int i = index; i < factorArray.length; i++) {
    		currentValue *= factorArray[i];
    		currentFactors.add(factorArray[i]);
    		boolean isPossible = calculateFactors(factorArray, target, currentValue, i, currentFactors);
    		currentFactors.remove(currentFactors.size() - 1);
    		currentValue /= factorArray[i];

    	}
    	return true;

    }

    public Integer[] getFactorsArray(int n) {
    	List<Integer> factorList = new ArrayList<>();
    	int sqrt = getSqrt(n);    	
    	for (int i = 2; i <= sqrt; i++) {
    		if (n % i == 0) {
    			factorList.add(i);
    			if (i != n/i) {    				
    				factorList.add(n/i);
    			}
    		}    		
    	}    
    	//System.out.println(factorList);
    	return factorList.toArray(new Integer[factorList.size()]);
    }

	public int getSqrt(int n) {
		int val = 1;
		while ((val * val) <= n) {
			val++;
		}
		if (val * val > n) {
			val--;
		}
		return val;
	}
}