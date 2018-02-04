import java.util.*;
import java.lang.*;
import java.io.*;

class SubsetsII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		SubsetsII ss = new SubsetsII();
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();            
		}
		System.out.println(ss.subsetsWithDup(nums));
	}

	List<List<Integer>> subsetList = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		subsetList.add(new ArrayList<>());
		Arrays.sort(nums);
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
			while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				i++;
			}			
		}		
	}
}