import java.util.*;
import java.lang.*;
import java.io.*;

public class MissingNumber {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		MissingNumber mn = new MissingNumber();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(mn.findMissingNumber(arr));
 		}

	}

	public int findMissingNumber(int[] nums) {
	    int sum = 0;
	    int asum = 0;
		for (int i = 0; i < nums.length; i++) {
		    sum += nums[i];
		    asum += (i + 1);
		}
		asum += nums.length + 1;
		return asum - sum;
	}
}