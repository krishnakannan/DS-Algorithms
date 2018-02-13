import java.util.*;
import java.lang.*;
import java.io.*;

class WiggleSort {

	public static void main(String args[]) {
		WiggleSort ws = new WiggleSort();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}

		ws.wiggleSort(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

	}

    public void wiggleSort(int[] nums) {
		boolean isInc = true;

		for (int i = 0; i < nums.length - 1; i++) {			
			if (isInc) {
				isInc = false;
				if (nums[i] > nums[i + 1]) {
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
				}
			} else {
				isInc = true;
				if (nums[i] < nums[i + 1]) {
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
				}
			}
		}
    }
}