/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/

//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1


class GfG
{
    int maxLen(int arr[], int n) {
    	Map<Integer, Integer> diffMap = new HashMap<>();
    	int maxLength = 0;    	
    	int val = arr[0];
    	diffMap.put(val, 0);
    	for (int i = 1; i < arr.length; i++) {
    		val += arr[i];
    		if (diffMap.containsKey(val)) {
    			maxLength = maxLength < i - diffMap.get(val) ? i - diffMap.get(val) : maxLength;
    		} else {
    			diffMap.put(val, i);
    		}
    	}
    	//System.out.println(diffMap);
    	return val == 0 ? arr.length : maxLength;
    }
}