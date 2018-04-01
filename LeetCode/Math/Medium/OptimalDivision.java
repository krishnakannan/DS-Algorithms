public class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        boolean started = false;
        for (int i = 0; i < nums.length; i++) {
            if (i == 1 && flag && nums.length > 2) {
                sb.append("(");
                flag = false;
                started = true;
            } 
            sb.append(nums[i]);
            if (i != nums.length - 1) {
                sb.append("/");
            }
        }
        if (started) {
            sb.append(")");    
        }
        
        return sb.toString();
    }
}