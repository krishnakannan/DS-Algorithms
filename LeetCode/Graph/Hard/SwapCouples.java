import java.util.*;
import java.lang.*;   
import java.io.*;

class SwapCouples {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		SwapCouples sc = new SwapCouples();
		int n = in.nextInt();
		int[] row = new int[n];
		for (int i = 0; i < row.length; i++) {
			row[i] = in.nextInt();
		}
		System.out.println(sc.minSwapsCouples(row));
	}

	//Based on the HINT in the desc;
	class Couch {
		int couchNumber;
		int person1;
		int person2;
		public Couch(int couchNumber, int person1, int person2) {
			this.couchNumber = couchNumber;
			this.person1 = person1;
			this.person2 = person2;
		}	
	}

	boolean[] visited;

	Map<Integer, List<Couch>> graph;
	Map<Integer, Couch> location;

    public int minSwapsCouples(int[] row) {    	
    	graph = new HashMap<>();
    	location = new HashMap<>();
        Couch[] couches = new Couch[row.length / 2];    
        visited = new boolean[couches.length];
        for (int i = 0, j = 0; i < row.length; i += 2, j++) {
        	couches[j] = new Couch(j, row[i], row[i + 1]);
        	location.put(row[i], couches[j]);
        	location.put(row[i + 1], couches[j]);
        }

        //Create Graph


        for (Couch couch : couches) {
        	List<Couch> neighbors = new ArrayList<>();
        	neighbors.add(couch.person1 % 2 == 0 ? location.get(couch.person1 + 1) : location.get(couch.person1 - 1));
        	neighbors.add(couch.person2 % 2 == 0 ? location.get(couch.person2 + 1) : location.get(couch.person2 - 1));        	
        	graph.put(couch.couchNumber, neighbors);
        } 
        // printLocation();
        // printGraph();
        //Now the problem is simple, performing DFS and counting the number of steps needed to complete a circle and repeat it for all the circles. 
        int totalSwaps = 0;
        for (int i = 0; i < couches.length; i++) {
        	//System.out.println(Arrays.toString(visited));
        	totalSwaps += findCircle(couches, i, 0);        	
        	
        }
        return totalSwaps;
    }

    public int findCircle(Couch[] couches, int index, int steps) {    	
    	List<Couch> neighbors = graph.get(index);
    	visited[index] = true;
    	if (neighbors != null && !neighbors.isEmpty()) {
    		for (Couch neighbor : neighbors) {
	    		if (!visited[neighbor.couchNumber]) {    			
	    			return findCircle(couches, neighbor.couchNumber, steps + 1);
	    		}
	    	}
    	}    	

    	return steps;
    }

    public void printGraph() {
    	for (Map.Entry<Integer, List<Couch>> entry : graph.entrySet()) {
    		System.out.print(entry.getKey() + " -> [");    		
    		for (Couch couch : entry.getValue()) {
    			//System.out.print("[" + couch.person1 +", " + couch.person2 + "]");
    			System.out.print(couch.couchNumber + " ");
    		}
    		System.out.println("]");
    	}
    }

    public void printLocation() {
    	for (Map.Entry<Integer, Couch> entry : location.entrySet()) {
    		System.out.println(entry.getKey() + " is at couch [" + entry.getValue().couchNumber + "]");    		    		    		
    	}
    }
}