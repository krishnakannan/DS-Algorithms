import java.util.*;
import java.lang.*;
import java.io.*;

class TrappingRainWater {
	public static void main (String[] args) {
		TrappingRainWater tr = new TrappingRainWater();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(tr.trapRainWater(arr));
 		}
	}

	public int trapRainWater(int[] height) {
		if (height.length == 0) {
            return 0;
        }
        int[] lArr = new int[height.length];
        int[] rArr = new int[height.length];                
        int cVal = 0;
        lArr[0] = height[0];
        rArr[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            lArr[i] = height[i] > lArr[i - 1] ? height[i] : lArr[i -1];
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rArr[i] = height[i] > rArr[i + 1] ? height[i] : rArr[i + 1];
        }
        for (int i = 0; i < height.length; i++) {
            int val = min(lArr[i], rArr[i]) - height[i];
            cVal += val;
        }
        return cVal;
    }
    public int min(int a, int b) {
        return a > b ? b : a; 
    }
}