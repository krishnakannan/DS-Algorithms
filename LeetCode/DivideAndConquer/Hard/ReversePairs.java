import java.util.*;
import java.lang.*;
import java.io.*;

class ReversePairs {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		ReversePairs rp = new ReversePairs();
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		System.out.println(rp.reversePairs(nums));
	}

	int importantPairCount = 0;

    public int reversePairs(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        long[] longNums = new long[nums.length];
        
        for (int i = 0; i < longNums.length; i++) {
            longNums[i] = (long)nums[i];
        }
    	//System.out.println("Original " + Arrays.toString(nums));
        mergeSort(longNums, 0, longNums.length - 1);        
        //System.out.println("Sorted " + Arrays.toString(nums));
        return importantPairCount;
    }

    public void mergeSort(long[] nums, int start, int end) {

    	if (start == end) {
    		return;
    	}

    	int mid = start + (end - start) / 2;

    	mergeSort(nums, start, mid);
    	mergeSort(nums, mid + 1, end);

    	merge(nums, start, mid, end);
    }

    public void merge(long[] nums, int start, int mid, int end) {
    	long[] temp = new long[end - start + 1];

    	int tIndex = 0;
    	int fIndex = start;
    	int sIndex = mid + 1;
        
    	int impIndex = start;

    	while (impIndex <= mid) {
    		if (nums[impIndex] <= 2 * nums[sIndex]) {
    			impIndex += 1;
    		} else {
                importantPairCount += mid - impIndex + 1;                
                break;
            }
    	}

    	while (fIndex <= mid && sIndex <= end) {
    		if (nums[fIndex] < nums[sIndex]) {
    			temp[tIndex] = nums[fIndex];
    			fIndex += 1;
    		} else{                                
    			temp[tIndex] = nums[sIndex];
    			sIndex += 1;    			
                while (impIndex <= mid) {
                    if (sIndex <= end && nums[impIndex] <= 2 * nums[sIndex]) {
                        impIndex += 1;
                    } else {
                        if (sIndex <= end) {
                            importantPairCount += mid - impIndex + 1;                    
                        }                   
                        break;
                    }
                }
    		}            
    		tIndex += 1;
    		
    	}
        
    	while (fIndex <= mid) {
    		temp[tIndex] = nums[fIndex];
    		tIndex += 1;
    		fIndex += 1;            
    	} 

    	while (sIndex <= end) {
    		temp[tIndex] = nums[sIndex];
    		tIndex += 1;
    		sIndex += 1;
            while (impIndex <= mid) {
                if (sIndex <= end && nums[impIndex] <= 2 * nums[sIndex]) {
                    impIndex += 1;
                } else {
                    if (sIndex <= end) {
                        importantPairCount += mid - impIndex + 1;                    
                    }                   
                    break;
                }
            }
    	}

    	for (int i = 0, j = start; i < temp.length && j <= end; i++, j++) {
    		nums[j] = temp[i];    		
    	}        
    }
}