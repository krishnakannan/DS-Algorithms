import java.util.*;
import java.lang.*;   
import java.io.*;

class CreateMaximumNumber {

	public static void main(String args[]) {
		CreateMaximumNumber cmn = new CreateMaximumNumber();
		Scanner in = new Scanner(System.in);
		// int n1 = in.nextInt();
		// int[] nums1 = new int[n1];
		// for (int i = 0; i < nums1.length; i++) {
		// 	nums1[i] = in.nextInt();
		// }
		// int n2 = in.nextInt();
		// int[] nums2 = new int[n2];
		// for (int i = 0; i < nums2.length; i++) {
		// 	nums2[i] = in.nextInt();
		// }
		// int k = in.nextInt();
		// int[] maxNumber = cmn.maxNumber(nums1, nums2, k);
		// for (int n : maxNumber) {
		// 	System.out.print(n + " ");
		// }
		// System.out.println();
		

		int n = in.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		int k = in.nextInt();
		int[] output = cmn.removeKDigits(nums, k);
		for (int o : output) {
			System.out.print(o + " ");
		}
		System.out.println();
	}

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {       

    	int l1 = nums1.length;
    	int l2 = nums2.length;
    	int[] result = new int[k];
    	if (l1 + l2 == k) {
    		return mergeArrays(nums1, nums2, k);
    	} else {
    		for (int i = 0; i <= k; i++) {
    			if (i <= l1 && (k - i) <= l2) {
    				int[] max1 = removeKDigits(nums1, i);
    				int[] max2 = removeKDigits(nums2, k - i);
    				int[] max = mergeArrays(max1, max2, k);
    				if (isFirstArrayGreater(max, 0, result, 0)) {
    					result = max;
    				}    				
    			}
    		}
    	}
    	return result;
    }


    public int[] mergeArrays(int[] nums1, int[] nums2, int requiredSize) {
    	int[] output = new int[requiredSize];
    	int index1 = 0;
    	int index2 = 0;
    	int oIndex = 0;
    	while (oIndex < requiredSize) {
    		if (isFirstArrayGreater(nums1, index1, nums2, index2)) {
    			output[oIndex] = nums1[index1];
    			index1 += 1;
    		} else {
    			output[oIndex] = nums2[index2];
    			index2 += 1;
    		}
    		oIndex += 1;
    	}
    	return output;
    }

    public boolean isFirstArrayGreater(int[] nums1, int startIndex1, int[] nums2, int startIndex2) {

    	int l1 = nums1.length - startIndex1;
    	int l2 = nums2.length - startIndex2;
    	if (l1 <= 0) {
    		return false;
    	} else if (l2 <= 0) {
    		return true;
    	}
    	int len = Math.max(l1, l2);
    	for (int i = 0; i < len; i++) {
    		int d1 = startIndex1 + i < nums1.length ? nums1[startIndex1 + i] : 0;
    		int d2 = startIndex2 + i < nums2.length ? nums2[startIndex2 + i] : 0;
    		if (d1 != d2) {
    			return d1 > d2;
    		}
    	}
    	return true;
    }

    //This returns the largest K digits maintaining relative order
    public int[] removeKDigits(int[] nums, int requiredSize) {
    	int[] output = new int[requiredSize];    	
    	Stack<Integer> stack = new Stack<>();
    	for (int i = 0; i < nums.length; i++) {
    		while (!stack.empty() && stack.peek() < nums[i] && stack.size() + nums.length - i > requiredSize) {
    			stack.pop();    			
    		}
            if (stack.size() < requiredSize) {
                stack.push(nums[i]);    
            }
    		
    	}        
        
        int size = stack.size();

    	for (int i = 0; i < output.length; i++) {
    		output[requiredSize - i - 1] = stack.pop();
    	}
    	return output;
    }
}