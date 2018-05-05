import java.util.*;
import java.lang.*;   
import java.io.*;

class PatchingArray {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PatchingArray pa = new PatchingArray();
		int x = in.nextInt();
		int[] nums = new int[x];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		int n = in.nextInt();
		System.out.println(pa.minPatches(nums, n));
	}

	//REFERRED SOLUTION
	// https://leetcode.com/problems/patching-array/solution/

	public int minPatches(int[] nums, int n) {
        int patches = 0;
        int i = 0;
        long currentMissing = 1;

        while (currentMissing <= n) {
            if (i < nums.length && nums[i] <= currentMissing) {
            	currentMissing += nums[i];
                i++;
            }                
            else {
                currentMissing += currentMissing;
                patches++;
            }
        }
        return patches;
    }
}