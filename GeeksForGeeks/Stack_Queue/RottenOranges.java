import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/rotten-oranges/0

class RottenOranges {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		RottenOranges oranges = new RottenOranges();
		while (--testcases >= 0) {
		    int n1 = in.nextInt();
		    int n2 = in.nextInt();		    
		    int[][] arr = new int[n1][n2];
		    for (int i = 0; i < arr.length; i++) {
		    	for (int j = 0; j < arr[0].length; j++) {
		    		arr[i][j] = in.nextInt();	
		    	}		        
		    }		 
		    System.out.println(oranges.getTime(arr));
 		}
	}

	public int getTime(int[][] arr) {
		Queue<Coord> rottenQueue = new LinkedList<>();
		Queue<Coord> temp = new LinkedList<>();
		int time = 0;

		//Init the queue
		for (int i = 0; i < arr.length; i++) {
	    	for (int j = 0; j < arr[0].length; j++) {
	    		if (arr[i][j] == 2){
	    			rottenQueue.add(new Coord(i,j));
	    		}	    		
	    	}		        
		}		 

		while (!rottenQueue.isEmpty()) {			
			Coord coord = rottenQueue.poll();
			int i = coord.x;
			int j = coord.y;			
			//[i-1,j], [i+1,j], [i,j-1], [i,j+1] 
			if (i > 0 && arr[i - 1][j] == 1) {
				arr[i - 1][j] = 2;
				temp.add(new Coord(i - 1, j));
			}
			if (i < arr.length - 1 && arr[i + 1][j] == 1) {
				arr[i + 1][j] = 2;
				temp.add(new Coord(i + 1, j));	
			}
			if (j > 0 && arr[i][j - 1] == 1) {
				arr[i][j - 1] = 2;
				temp.add(new Coord(i, j - 1));	
			}
			if (j < arr[0].length - 1 && arr[i][j + 1] == 1) {
				arr[i][j + 1] = 2;
				temp.add(new Coord(i, j + 1));	
			}
			if (rottenQueue.isEmpty()) {				
				time++;
				rottenQueue.addAll(temp);
				temp.clear();
			}
		}

		for (int i = 0; i < arr.length; i++) {
	    	for (int j = 0; j < arr[0].length; j++) {
	    		if (arr[i][j] == 1){
	    			return -1;
	    		}	    		
	    	}		        
		}		 

		return --time;
	}

	class Coord {
		int x;
		int y;
		Coord(){}
		Coord(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}