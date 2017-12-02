import java.util.*;
import java.lang.*;
import java.io.*;


/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/

//https://practice.geeksforgeeks.org/problems/josephus-problem/1

class Josephus{

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		Josephus jObj = new Josephus();
		while (--testcases >= 0) {
		    int n = in.nextInt();		   
			int k = in.nextInt();		   
			System.out.println(jObj.josephus(n, k));
 		}
	}
    public Integer josephus(int n, int k) {
        List<Integer> alive = new ArrayList<>();        
        for (int i = 0; i < n; i++) {
        	alive.add(i + 1);	
        }
        kill(alive, 0, k - 1);
        return alive.get(0);
    }

    public void kill(List<Integer> alive, int startPoint, int gap) {
    	
    	int alivePeople = alive.size();
    	if (alivePeople == 1) {
    		return;
    	}
    	int target = (startPoint + gap) % alivePeople;    	    	
    	//System.out.println("Alive " + alive + " Target = " + alive.get(target) + " startPoint = " + startPoint );
    	alive.remove(target);
    	kill(alive, target, gap);
    }
}
