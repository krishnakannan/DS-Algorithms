//https://leetcode.com/problems/predict-the-winner/description/
//DP AND GAME THEORY(MINMAX)

class PredictWinner {
    int p1 = 0;
    int p2 = 0;
    public boolean PredictTheWinner(int[] nums) { 
        Integer[][] memo = new Integer[nums.length][nums.length];
        return play(nums, 0, nums.length - 1, memo) >= 0;
    }
    
    public int play(int[] nums, int s, int e, Integer[][] memo) {        
        if (s == e) {
            return nums[e];
        } 
        if (memo[s][e] != null) {
            return memo[s][e];            
        }
        int v1 = nums[s] - play(nums, s + 1, e, memo);
        int v2 = nums[e] - play(nums, s, e - 1, memo);
        memo[s][e] = max(v1, v2);        
        return memo[s][e];
    }
    
    public int max(int a, int b) {
        return a > b ? a : b;
    }
}