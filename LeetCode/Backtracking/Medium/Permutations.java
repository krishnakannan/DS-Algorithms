import java.util.*;
import java.lang.*;
import java.io.*;

class Permutations {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Permutations p = new Permutations();
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
		System.out.println(p.permute(nums));
	}

	boolean[] used;	
	List<List<Integer>> permutations = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        permute(nums, 0, new ArrayList<>());
        return permutations;
    }

    public void permute(int[] nums, int index, List<Integer> currentPermutation) {

    	if (index == nums.length) {
    		permutations.add(new ArrayList<>(currentPermutation));
    		return;
    	}

    	for (int i = 0; i < nums.length; i++) {
    		if (!used[i]) {
    			currentPermutation.add(nums[i]);
    			used[i] = true;
    			permute(nums, index + 1, currentPermutation);
    			used[i] = false;
    			currentPermutation.remove(currentPermutation.size() - 1);
    		}
    	}
    }
}