import java.util.*;
import java.lang.*;   
import java.io.*;

class BurstBalloons {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		BurstBalloons bb = new BurstBalloons();
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		long startTime = System.currentTimeMillis();
		System.out.println(bb.maxCoins(nums));
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Elapsed " + estimatedTime + " MS ");
	}

	int[][] dp;
	int count = 0;
	public int maxCoins(int[] nums) {
    	dp = new int[nums.length][nums.length];
    	
    	int res = getMaxCoins(nums, 0, nums.length - 1);
    	System.out.println("DPED " + count);
    	return res;
    }

    public int getMaxCoins(int[] nums, int start, int end) {
    	if (start > end) {
    		return 0;
    	}

    	if (dp[start][end] > 0) {
    		count++;
    		return dp[start][end];
    	}
    	int maxVal = Integer.MIN_VALUE;
    	for (int i = start; i <= end; i++) {
    		int val = getMaxCoins(nums, start, i - 1) + getCurrentBalloonValue(nums, i, start, end) + getMaxCoins(nums, i + 1, end);
    		maxVal = maxVal < val ? val : maxVal;
    	}
    	dp[start][end] = maxVal;
    	return dp[start][end];
    }

    public int getCurrentBalloonValue(int[] balloons, int index, int start, int end) {    	
    	int pIndex = start - 1;
    	int pVal;    	
    	int nIndex = end + 1;
    	int nVal;
    	if (pIndex < 0) {
    		pVal = 1;
    	} else {
    		pVal = balloons[pIndex];
    	}

    	if (nIndex >= balloons.length) {
    		nVal = 1;
    	} else {
    		nVal = balloons[nIndex];
    	}
    	
    	return pVal * balloons[index] * nVal;
    }
}

/*
	SLOWER SOLUTION MAP-STRING BASED DP - NO DC - USED BACKTRACKING 

	Map<String, Integer> dp = new HashMap<>();
	int count = 0;
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        balloons[0] = 1;
        balloons[balloons.length - 1] = 1;
        for (int i = 0, j = 1; i < nums.length; i++, j++) {
        	balloons[j] = nums[i];
        }
        String key = getKey(balloons);
        int res = getCoins(balloons, key, 0);
        System.out.println("DPED " + count);
        return res;
    }


    public int getCoins(int[] balloons, String key, int bursted) {
    	if (bursted == balloons.length - 2) {
    		return 0;
    	}
    	//String key = getKey(balloons);
    	if (dp.containsKey(key)) {
    		//count++;
    		return dp.get(key);
    	}

    	int maxCoins = Integer.MIN_VALUE;
    	for (int i = 1; i < balloons.length - 1; i++) {
    		if (balloons[i] < 0) {
    			continue;
    		}
    		int val = balloons[i];
    		int currentVal = getCurrentBalloonValue(balloons, i);
    		balloons[i] = -1;
    		String nextKey = key.substring(0, i) + "*" + key.substring(i + 1);
    		//System.out.println("Key " + key + " \n NextKey " + nextKey);
    		currentVal += getCoins(balloons, nextKey, bursted + 1);
    		balloons[i] = val;
    		maxCoins = maxCoins < currentVal ? currentVal : maxCoins;
    	}
    	dp.put(key, maxCoins);
    	return dp.get(key);
    }

    public int getCurrentBalloonValue(int[] balloons, int index) {    	
    	int pIndex = index - 1;
    	int nIndex = index + 1;
    	while (pIndex >= 0) {
    		if (balloons[pIndex] > 0) {
    			break;
    		}
    		pIndex--;
    	}
    	while (nIndex < balloons.length) {
    		if (balloons[nIndex] > 0) {
    			break;
    		}
    		nIndex++;
    	}
    	return balloons[pIndex] * balloons[index] * balloons[nIndex];
    }

    public String getKey(int[] balloons) {
    	StringBuilder key = new StringBuilder();
    	for (int i = 0; i < balloons.length; i++) {
    		key.append(balloons[i]);
    	}
    	return key.toString();
    }


*/