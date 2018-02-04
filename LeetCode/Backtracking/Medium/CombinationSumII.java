import java.util.*;
import java.lang.*;
import java.io.*;

public class CombinationSumII {	

	public static void main(String arfs[]) {
		CombinationSumII cs = new CombinationSumII();
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		int[] candidates = new int[length];		
		for (int i = 0; i < length; i++) {
			candidates[i] = in.nextInt();			
		}
		int target = in.nextInt();
		System.out.println(cs.combinationSum2(candidates, target));

	}


	List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combine(candidates, 0, target, 0, new ArrayList<>());
        return combinations;
    }

    public void combine(int[] candidates, int index, int target, int currentSum, List<Integer> currentList) {
    	
    	if (index > candidates.length) {
    		return;
    	}

    	if (currentSum > target) {
    		return;
    	}

    	if (currentSum == target) {
    		combinations.add(new ArrayList<>(currentList));
    		return;
    	}

    	for (int i = index; i < candidates.length; i++) {
    		currentList.add(candidates[i]);
    		currentSum += candidates[i];
    		combine(candidates, i + 1, target, currentSum, currentList);
    		currentSum -= candidates[i];
    		currentList.remove(currentList.size() - 1);
    		while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
    			i++;
    		}    		
    	}	

    }
}