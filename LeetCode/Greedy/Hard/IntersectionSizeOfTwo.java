import java.util.*;
import java.lang.*;
import java.io.*;

class IntersectionSizeOfTwo {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] intervals = new int[n][2];
		for (int i = 0; i < intervals.length; i++) {
			intervals[i][0] = in.nextInt();
			intervals[i][1] = in.nextInt();
		}
		IntersectionSizeOfTwo isot = new IntersectionSizeOfTwo();
		System.out.println(isot.intersectionSizeTwo(intervals));
	}

    public  int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
        	public int compare(int[] a, int[] b) {
        		if (a[1] == b[1]) {
        			return b[0] - a[0];
        		}
        		return a[1] - b[1];
        	}
        });

        int setSize = 2;        
        
        int[] currentInterval = new int[2];
        currentInterval[1] = intervals[0][1];
        currentInterval[0] = currentInterval[1] - 1;

        for (int i = 1; i < intervals.length; i++) {            
            if (intervals[i][0] <= currentInterval[1] && intervals[i][0] > currentInterval[0]) {
                setSize += 1;
                currentInterval[0] = currentInterval[1];
                currentInterval[1] = intervals[i][1];
                
            } else if (intervals[i][0] > currentInterval[1]) {
                setSize += 2;
                currentInterval[1] = intervals[i][1];
                currentInterval[0] = currentInterval[1] - 1;         		
        	} 
        }   
        return setSize;
    }    

       public void print(int[][] arr) {
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i][0] + ", " + arr[i][1] + " ");
    	}
    	System.out.println();
    }
}