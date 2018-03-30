import java.util.*;
import java.lang.*;
import java.io.*;

class MatchSticksToSquare {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
		MatchSticksToSquare mss = new MatchSticksToSquare();
		System.out.println(mss.makesquare(nums));
	}
    
    public boolean makesquare(int[] nums) {
        int perimeter = 0;
        Integer[] numsObjArr = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
        	perimeter += nums[i];
        	numsObjArr[i] = nums[i];
        }
        if (perimeter % 4 != 0 || nums.length == 0) {
        	return false;
        }
        int sideLength = perimeter / 4;
        Arrays.sort(numsObjArr, Collections.reverseOrder());
        int[] sides = new int[4];
        boolean canForm = canFormSquare(sides, 0, numsObjArr, sideLength);        
        return canForm;
    }

    public boolean canFormSquare(int[] sides, int index, Integer[] nums, int requiredLength) {
 
    	if (index == nums.length) {
    		if (sides[0] == requiredLength && sides[1] == requiredLength && sides[2] == requiredLength && sides[3] == requiredLength) {
    			return true;
    	    }
    	    return false;
    	}


    	for (int i = 0; i < 4; i++) {
    	    if (sides[i] + nums[index] > requiredLength) {
    	    	continue;
    	    }
    	    sides[i] += nums[index];
            if (canFormSquare(sides, index + 1, nums, requiredLength)) {
             return true;
            }
    	    sides[i] -= nums[index];
    	}

    	return false;
    }
}