//https://leetcode.com/problems/largest-divisible-subset/description/
class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {        	
        	for (int j = 0; j < i; j++) {
        		if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
        			dp[i] = dp[i] < dp[j] + 1 ? dp[j] + 1 : dp[i];
        		}
        	}
        }
        
        List<Integer> values = traceValues(nums, dp);
        Collections.reverse(values);
        return values;
    }

    public List<Integer> traceValues(int[] nums, int[] dp) {
    	int max = Integer.MIN_VALUE;
    	//Find Max
    	for (int i = 0; i < dp.length; i++) {         
    		max = max < dp[i] ? dp[i] : max;
    	}
        //System.out.println();
    	List<Integer> list = new ArrayList<>();
    	for (int i = dp.length - 1; max > 0 && i >= 0;  i--) {            
    		if (dp[i] == max) {
    			list.add(nums[i]);
    			max--;
    		}
    	}
    	return list;
    }
}