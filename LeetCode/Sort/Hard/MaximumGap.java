import java.util.*;
import java.lang.*;   
import java.io.*;

class MaximumGap {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		MaximumGap mg = new MaximumGap();
		System.out.println(mg.maximumGap(nums));
	}

	//RADIX SORT BASED SOLUTION

	int[] output;
    public int maximumGap(int[] nums) {
       	output = Arrays.copyOf(nums, nums.length);
       	int maxDigits = 0;
       	for (int i = 0; i < nums.length; i++) {
       		int digits = getDigits(nums[i]);
       		maxDigits = maxDigits < digits ? digits : maxDigits;
       	}

       	for (int i = 0; i < maxDigits; i++) {
       		radixSort(i);
       	}

       	int maxGap = 0;

       	for (int i = 1; i < output.length; i++) {
       		int gap = output[i] - output[i - 1];
       		maxGap = maxGap < gap ? gap : maxGap;
       	}

       	return maxGap;
    }

    //Radix sort based on Counting Sort
    public void radixSort(int exp) {
    	List<Integer>[] buckets = (List<Integer>[])new List[10];

    	for (int i = 0; i < output.length; i++) {
    		int expVal = (int) (Math.pow(10, exp));
    		int index = ((output[i] / expVal) % 10);
    		if (buckets[index] == null) {
    			buckets[index] = new ArrayList<Integer>();
    		}
    		buckets[index].add(output[i]);
    	}

    	int oIndex = 0;
    	for (int i = 0; i < 10; i++) {
    		if (buckets[i] != null) {
    			for (Integer num : buckets[i]) {
    				output[oIndex] = num;
    				oIndex++;
    			}
    		}
    	}
    }

    public int getDigits(int num) {
    	return num == 0 ? 1 : (int)(Math.log10(num) + 1);
    }
}