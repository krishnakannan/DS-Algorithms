import java.util.*;
import java.lang.*;
import java.io.*;

class PermutationsII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PermutationsII p = new PermutationsII();
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
        Arrays.sort(nums);
        used = new boolean[nums.length];
        permute(nums, 0, new ArrayList<>());
        return permutations;
    }

    public void permute(int[] nums, int index, List<Integer> currentPermutation) {
        System.out.println(currentPermutation);
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
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }            
        }
    }
}