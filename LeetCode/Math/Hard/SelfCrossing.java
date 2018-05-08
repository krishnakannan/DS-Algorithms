import java.util.*;
import java.lang.*;   
import java.io.*;

class SelfCrossing {
    
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		SelfCrossing as = new SelfCrossing();
		int nums[] = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		System.out.println(as.isSelfCrossing(nums));		
	}

	//Referred Soln
    
	public boolean isSelfCrossing(int[] x) {
        if (x.length < 4) {
			return false;
        }   
        int i = 0;
        int base = 0;
        while ((i + 4) <= x.length) {
            if (x[i] - x[i + 2] >= 0 && x[i + 1] - x[i + 3] <= base) {
				return true;
            } else if (x[i + 1] - x[i + 3] > base) {
				base = 0;
            } else {
            	base = x[i];
            }   
            i++;
        }
        return false;
    }
}