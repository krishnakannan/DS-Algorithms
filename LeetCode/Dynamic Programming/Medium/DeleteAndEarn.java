import java.util.*;
import java.lang.*;
import java.io.*;

class DeleteAndEarn {

	public static void main(String args[]) {
		DeleteAndEarn de = new DeleteAndEarn();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();			
		}
		System.out.println(de.deleteAndEarn(nums));
	}

    public int deleteAndEarn(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }            
            
            int maxLength = 0;        
            for (int i = 0; i < nums.length; i++) {
                maxLength = nums[i] > maxLength ? nums[i] : maxLength;
            }            
            
            
            int[] values = new int[maxLength];

            for (int i = 0; i < nums.length; i++) {
                values[nums[i] - 1] += nums[i];
            }

            int[] dp = new int[maxLength];

            dp[0] = values[0];        
            dp[1] = values[0] > values[1] ? values[0] : values[1];        
            if (maxLength > 2) {
                dp[2] = values[0] + values[2];    
            }
            
            for (int i = 3; i < maxLength; i++) {        	
                dp[i] = values[i] + dp[i - 2] > values[i] + dp[i - 3] ? values[i] + dp[i - 2] : values[i] + dp[i - 3];
            }

            return dp[dp.length - 2] > dp[dp.length - 1] ? dp[dp.length - 2] : dp[dp.length - 1];

    }
}