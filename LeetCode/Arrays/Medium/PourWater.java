import java.util.*;
import java.lang.*;
import java.io.*;

class PourWater {
    
    public static void main(String args[]) {
    	Scanner in = new Scanner(System.in);
    	PourWater pw = new PourWater();
    	int n = in.nextInt();
    	int[] h = new int[n];
    	for (int i = 0; i < n; i++) {
    		h[i] = in.nextInt();
    	}
    	int v = in.nextInt();
    	int k = in.nextInt();
    	int[] res = pw.pourWater(h, v, k);
    	for (int r : res) {
    		System.out.print(r + " ");
    	}
    	System.out.println();
    }

    public int[] pourWater(int[] heights, int units, int index) {
       if (heights == null || heights.length == 0 || V == 0) {
            return heights;
        }
        int targetIndex;
        while (units > 0) {
            targetIndex = index;
            for (int i = index - 1; i >= 0; i--) {
                if (heights[i] > heights[targetIndex]) {
                    break;
                } else if (heights[i] < heights[targetIndex]) {
                    targetIndex = i;
                }
            }
            if (targetIndex != index) {
                heights[targetIndex]++;
                V--;
                continue;
            }
            for (int i = index + 1; i < heights.length; i++) {
                if (heights[i] > heights[targetIndex]) {
                    break;
                } else if (heights[i] < heights[targetIndex]) {
                    targetIndex = i;
                }
            }
            heights[targetIndex]++;
            units--;
        }
        return heights;
    }

    
}