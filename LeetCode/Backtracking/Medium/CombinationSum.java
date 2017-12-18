import java.util.*;
import java.lang.*;
import java.io.*;


class CombinationSum {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		CombinationSum csObj =  new CombinationSum();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
            int target = in.nextInt();
		    List<List<Integer>> combinationsList = csObj.combinationSum(arr, target);
		    for (List<Integer> combination : combinationsList) {
		    	System.out.println(combination);
		    }			
 		}
	}

	List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combine(candidates, target, new ArrayList<>(), 0, 0);
        return combinations;
    }


    public boolean combine(int[] candidates, int target, List<Integer> currentList, int currentIndex, int currentSum) {

    	if (currentSum == target) {
            combinations.add(new ArrayList<>(currentList));
            return true;
        }
        if (currentSum > target) {
            return false;
        }

    	for (int i = currentIndex; i < candidates.length; i++) {
            
            currentList.add(candidates[i]);
            currentSum += candidates[i];

            boolean canProceed = combine(candidates, target, currentList, i, currentSum);

            currentSum -= candidates[i];
            currentList.remove(currentList.size() - 1);


        }

        return true;
    }
}