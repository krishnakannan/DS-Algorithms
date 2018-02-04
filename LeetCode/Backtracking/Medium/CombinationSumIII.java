import java.util.*;
import java.lang.*;
import java.io.*;

public class CombinationSumIII {	

	public static void main(String arfs[]) {
		CombinationSumIII cs = new CombinationSumIII();
		Scanner in = new Scanner(System.in);		
		int k = in.nextInt();
		int n = in.nextInt();
		System.out.println(cs.combinationSum3(k, n));

	}


	List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {        
        combine(k, 1, n, 0, new ArrayList<>());
        return combinations;
    }

    public void combine(int k, int currentIndex, int target, int currentSum, List<Integer> currentList) {
        
        if (currentIndex > 10) {
            return;
        }
        
        if (currentList.size() > k + 1) {
            return;
        } 

        if (currentSum > target) {
            return;
        }        

        if (currentList.size() == k && currentSum == target) {            
            combinations.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = currentIndex; i <= target; i++) {
            currentList.add(i);
            currentSum += i;
            combine(k, i + 1, target, currentSum, currentList);
            currentSum -= i;
            currentList.remove(currentList.size() - 1);         
        }   

    }
}