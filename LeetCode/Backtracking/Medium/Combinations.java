import java.util.*;
import java.lang.*;
import java.io.*;


class Combinations {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Combinations cb = new Combinations();
		int n = in.nextInt();
		int k = in.nextInt();
		System.out.println(cb.combine(n, k));
	}

	List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
        	nums[i] = i + 1;
        }
        combine(nums, 0, new ArrayList<>(), k);
        return combinations;
    }
    
    public void combine(int[] nums, int index, List<Integer> currentCombination, int limit) {

    	if (currentCombination.size() == limit) {
    		combinations.add(new ArrayList<>(currentCombination));
    		return;
    	}


    	for (int i = index; i < nums.length; i++) {
    		currentCombination.add(nums[i]);
    		combine(nums, i + 1, currentCombination, limit);
    		currentCombination.remove(currentCombination.size() - 1);
    	}
    }
}