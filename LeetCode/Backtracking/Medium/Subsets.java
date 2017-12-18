import java.util.*;
import java.lang.*;
import java.io.*;


class Subsets {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		Subsets subsetObj =  new Subsets();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
		    List<List<Integer>> subsets = subsetObj.subsets(arr);
		    for (List<Integer> subset : subsets) {
		    	System.out.println(subset);
		    }			
 		}
	}
	List<List<Integer>> subsetList = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
    	subsetList.add(new ArrayList<>());
    	getSubsets(nums, 0, new ArrayList<>());	
        
        return subsetList;
    }

    public void getSubsets(int[] nums, int currentIndex, List<Integer> currentList) {    	    	
    	
    	if (currentIndex == nums.length - 1) {
    		currentList.add(nums[currentIndex]);
    		subsetList.add(new ArrayList<>(currentList));
    		currentList.remove(currentList.size() - 1);
    		return;
    	}
    	
    	for (int i = currentIndex; i < nums.length; i++) {

    		currentList.add(nums[i]);
    		subsetList.add(new ArrayList<>(currentList));
    		getSubsets(nums, i + 1, currentList);
    		currentList.remove(currentList.size() - 1);
    	}
    	
    }
}