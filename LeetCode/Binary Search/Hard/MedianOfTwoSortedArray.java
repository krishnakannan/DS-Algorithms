import java.util.*;
import java.lang.*;
import java.io.*;

//Implementation Reference - https://www.youtube.com/watch?v=LPFhl65R7ww

class MedianOfTwoSortedArray {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int[] nums1 = new int[n1];
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = in.nextInt();
		}
		int n2 = in.nextInt();
		int[] nums2 = new int[n2];
		for (int i = 0; i < nums2.length; i++) {
			nums2[i] = in.nextInt();
		}
		MedianOfTwoSortedArray mtsa = new MedianOfTwoSortedArray();
		System.out.println(mtsa.findMedianSortedArrays(nums1, nums2));
	}

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {    	
    	if (nums1.length <= nums2.length) {
    		return findMedian(nums1, nums2, 0, nums1.length);	
    	} else {
    		return findMedian(nums2, nums1, 0, nums2.length);
    	}        
    }

    public double findMedian(int[] nums1, int[] nums2, int left, int right) {
    	//System.out.println("Left " + left + " right " + right);
    	int partitionX = (left + right) / 2;
    	int partitionY = ((nums1.length + nums2.length + 1) / 2) - partitionX;
    	int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX -1];
    	int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY -1];
    	int minRightX = partitionX == nums1.length ? Integer.MAX_VALUE : nums1[partitionX];
    	int minRightY = partitionY == nums2.length ? Integer.MAX_VALUE : nums2[partitionY];
    	//System.out.println("MAXLEFTx " + maxLeftX + " MINRIGHTx " + minRightX + " MAXLEFTy " + maxLeftY + " MinRIGHTy " + minRightY) ;

    	if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
    		int partitionXSize = partitionX + partitionY;
    		int partitionYSize = nums1.length - partitionX + nums2.length - partitionY;
    		//System.out.println("partitionXSize " + partitionXSize + " partitionYSize " + partitionYSize);
    		if (partitionXSize == partitionYSize) {
    			return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
    		} else {
    			return (double) Math.max(maxLeftX, maxLeftY);
    		}
    	} else if (maxLeftX > minRightY) {
    		return findMedian(nums1, nums2, left, partitionX - 1);
    	} else if (maxLeftY > minRightX) {
    		return findMedian(nums1, nums2, partitionX + 1, right);
    	}
    	return 0d;    	
    }
}