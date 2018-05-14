import java.util.*;
import java.lang.*;   
import java.io.*;

class _24Game {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		_24Game _24g = new _24Game();
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		System.out.println(_24g.judgePoint24(nums));
	}

	 Solution {
    boolean solved = false;
	int count = 0;
    public boolean judgePoint24(int[] nums) {
        List<Double> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {        	
        	numsList.add((double)nums[i]);
        }
        generateEquation(numsList);        
        return solved;
    }



    public void generateEquation(List<Double> nums) {
    	
        if (nums.isEmpty()) {
            return;
        }
        
		if (nums.size() == 1) {        
			solved = Math.abs(24d - nums.get(0)) < 0.000001;
            return;
		}

		if (solved) {
			return;
		}

    	for (int i = 0; i < nums.size(); i++) {
    		for (int j = 0; j < nums.size(); j++) {
    			if (i != j) {
    				List<Double> newNums = new ArrayList<>();
    				for (int k = 0; k < nums.size(); k++) {
    					if (k != i && k != j) {
	                        newNums.add(nums.get(k));
	                    }
    				}
    				if (!solved) {
    					newNums.add(nums.get(i) + nums.get(j));

	    				generateEquation(newNums);

	    				newNums.remove(newNums.size() - 1);
    				}

    				if (!solved) {
    					newNums.add(nums.get(i) - nums.get(j));

	    				generateEquation(newNums);

	    				newNums.remove(newNums.size() - 1);
    				}

    				if (!solved) {
    					newNums.add(nums.get(i) * nums.get(j));

	    				generateEquation(newNums);

	    				newNums.remove(newNums.size() - 1);	
    				}

    				if (!solved) {
    					if (nums.get(j) > 0) {
	    					newNums.add(nums.get(i) / nums.get(j));

		    				generateEquation(newNums);

		    				newNums.remove(newNums.size() - 1);	
	    				}	
    				}
    				
    			}
    		}
    	}


    }
}