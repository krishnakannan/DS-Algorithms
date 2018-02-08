import java.util.*;
import java.lang.*;
import java.io.*;


class BeautifulArrangementII {

	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BeautifulArrangementII ba = new BeautifulArrangementII();
        int n = in.nextInt();        
        int k = in.nextInt();
        int[] nums = ba.constructArray(n, k);
        for (int i = 0; i < nums.length; i++) {
        	System.out.print(nums[i] + " ");	
        }
        System.out.println();
        
    }

    public int[] constructArray(int n, int k) {
        int firstArrangement = k + 1;
        int next = k;
        int nums = new int[n];
        boolean isAddition = true;
        for (int i = 0; i < firstArrangement; i++) {
        	if (i == 0) {
        		nums[i] = 1;
        	} else {
        		if (isAddition) {
        			nums[i] = nums[i - 1] + next;
        			isAddition = false;
        		} else {
        			nums[i] = nums[i - 1] - next;
        		}
        		next--;
        	}
        }

        for (int i = firstArrangement; i < nums.length; i++) {
        	nums[i] = i + 1;
        }

        return nums;
    }
}



3
2
4
3
4
4
5
2
10
3
9
1
9 
8