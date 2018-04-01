public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int rank = 1;
        int max = -1;
        int maxIndex = -1;
        String[] op = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	max = -1;
        	maxIndex = -1;
        	for (int j = 0; j < nums.length; j++) {
        		if (max < nums[j]) {
        			max = nums[j];
        			maxIndex = j;
        		}
        	}
        	nums[maxIndex] = -1;
        	if (rank == 1) {
        		op[maxIndex] = "Gold Medal";
        		rank++;
        	} else if (rank == 2) {
        		op[maxIndex] = "Silver Medal";
        		rank++;
        	} else if (rank == 3){
        		op[maxIndex] = "Bronze Medal";
        		rank++;
        	} else {
        		op[maxIndex] = Integer.toString(rank);
        		rank++;
        	}
        }
        return op;
    }
}