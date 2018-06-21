import java.util.*;
import java.lang.*;
import java.io.*;

class LongestMountainInArray {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = in.nextInt();
		}
		LongestMountainInArray lmia = new LongestMountainInArray();
		System.out.println(lmia.longestMountain(A));
	}

    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int left = 0;
        int center = left + 1;
        int right = center + 1;
        int longestMountain = Integer.MIN_VALUE;
        while (right < A.length) {
        	if (A[center] > A[left] && A[center] > A[right]) {
        		while (left > 0 && A[left] > A[left - 1]) {
        			left -= 1;
        		}
        		while (right < A.length - 1 && A[right] > A[right + 1]) {
        			right += 1;
        		}        		
        		int length = right - left + 1;

        		longestMountain = length > longestMountain ? length : longestMountain;
        		left = right;
        		center = left + 1;
        		right = center + 1;
        	} else {
        		left += 1;
        		center += 1;
        		right += 1;
        	}
        }

        int fLength = right - left + 1;        
        if (center == A.length - 1) {
            fLength = 0;
        }
        longestMountain = fLength > longestMountain ? fLength : longestMountain;
        return longestMountain == Integer.MIN_VALUE ? 0 : longestMountain;
    }
}