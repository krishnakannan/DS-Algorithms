import java.util.*;
import java.lang.*;
import java.io.*;

class IncreasingSubsequences {
    

    public static void main(String arfs[]) {
        Scanner in = new Scanner(System.in);
        IncreasingSubsequences is = new IncreasingSubsequences();
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(is.findSubsequences(nums));
    }


    Set<List<Integer>> subsequences;
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        subsequences = new HashSet<>();
        dfs(nums, new ArrayList<>(), 0);
        return new ArrayList<>(subsequences);
    }
    
    public void dfs (int[] nums, List<Integer> formedSubsequence, int index) {                
        if (index == nums.length - 1) {            
            if (formedSubsequence.size() > 0 && nums[index] >= formedSubsequence.get(formedSubsequence.size() - 1)) {
                formedSubsequence.add(nums[index]);
                subsequences.add(new ArrayList<>(formedSubsequence));
                formedSubsequence.remove(formedSubsequence.size() - 1);
            }
            
            return;
        }
        
        for (int i = index; i < nums.length; i++) {            
            if (formedSubsequence.isEmpty()) {                
                formedSubsequence.add(nums[i]);                
                dfs(nums, formedSubsequence, i + 1);
                formedSubsequence.remove(formedSubsequence.size() - 1);
            } else if (nums[i] >= formedSubsequence.get(formedSubsequence.size() - 1)) {                
                formedSubsequence.add(nums[i]);
                subsequences.add(new ArrayList<>(formedSubsequence));
                dfs(nums, formedSubsequence, i + 1);                
                int removed = formedSubsequence.remove(formedSubsequence.size() - 1);
            }          
        }
    }
}