import java.util.*;
import java.lang.*;
import java.io.*;

class AndroidUnlockPatterns {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		AndroidUnlockPatterns aup = new AndroidUnlockPatterns();
		int m = in.nextInt();
		int n = in.nextInt();
		System.out.println(aup.numberOfPatterns(m, n));
	}

	boolean[] visited;

    public int numberOfPatterns(int m, int n) {
    	visited = new boolean[10];
    	int pointA = getNum(0,0);
    	int pointB = getNum(0,1);
    	int pointC = getNum(1,1);

    	int countA = 0;
    	int countB = 0;
    	int countC = 0;
    	int totalCount = 0;
    	for (int i = m; i <= n; i++) {
    		countA = tracePattern(i - 1, pointA);
    		countB = tracePattern(i - 1, pointB);
    		countC = tracePattern(i - 1, pointC);

    		totalCount += (4 * countA) + (4 * countB) + countC;
    	}

    	return totalCount;

    }

    // FASTER ARRAY IMPLEMENTATION

    public int tracePattern(int movesLeft, int currentPoint) {
    	if (movesLeft == 0) {
    		return 1;
    	}
    	int currentValue = 0;
    	visited[currentPoint] = true;
    	int[] neighbors = getNeighbors(currentPoint);
    	for (Integer neighbor : neighbors) {
            if (neighbor != 0) {
                currentValue += tracePattern(movesLeft - 1, neighbor);    
            }    		
    	}
    	visited[currentPoint] = false;
    	return currentValue;
    }

    //Find a better way to do this function

    public int[] getNeighbors(Integer num) {
    	int[] neighbors = new int[10];
    	for (int i = 1; i <= 9; i++) {
    		if (!visited[i]) {
    			neighbors[i] = i;
    		}    		
    	}

    	neighbors[num] = 0;

    	if (num == 1) {
    		if (!visited[4]) neighbors[7] = 0; 
    		if (!visited[5]) neighbors[9] = 0;
    		if (!visited[2]) neighbors[3] = 0;
    	} else if (num == 3) {
    		if (!visited[6]) neighbors[9] = 0;
    		if (!visited[5]) neighbors[7] = 0;
    		if (!visited[2]) neighbors[1] = 0;
    	} else if (num == 7) {
    		if (!visited[4]) neighbors[1] = 0;
    		if (!visited[8]) neighbors[9] = 0;
    		if (!visited[5]) neighbors[3] = 0;
    	} else if (num == 9) {
    		if (!visited[5]) neighbors[1] = 0;
    		if (!visited[6]) neighbors[3] = 0;
    		if (!visited[8]) neighbors[7] = 0;
    	} else if (num == 2) {
    		if (!visited[5]) neighbors[8] = 0;
    	} else if (num == 4) {
    		if (!visited[5]) neighbors[6] = 0;
    	} else if (num == 6) {
    		if (!visited[5]) neighbors[4] = 0;
    	} else if (num == 8) {
    		if (!visited[5]) neighbors[2] = 0;
    	}
    	return neighbors;
    }


  
    public int getNum(int row, int col) {
    	int num = row * 3;
    	num += col;
    	num += 1;
    	return num;
    }
}


/*
		Slower HASHSET IMPLEMENTATION

		  public int tracePattern(int movesLeft, int currentPoint) {
    	if (movesLeft == 0) {
    		return 1;
    	}
    	int currentValue = 0;
    	visited[currentPoint] = true;
    	Set<Integer> neighbors = getNeighbors(currentPoint);
    	for (Integer neighbor : neighbors) {
    		currentValue += tracePattern(movesLeft - 1, neighbor);
    	}
    	visited[currentPoint] = false;
    	return currentValue;
    }

    //Find a better way to do this function

    public Set<Integer> getNeighbors(Integer num) {
    	Set<Integer> neighbors = new HashSet<>();
    	for (int i = 1; i <= 9; i++) {
    		if (!visited[i]) {
    			neighbors.add(i);	
    		}    		
    	}

    	neighbors.remove(num);

    	if (num == 1) {
    		if (!visited[4]) neighbors.remove(7);
    		if (!visited[5]) neighbors.remove(9);
    		if (!visited[2]) neighbors.remove(3);
    	} else if (num == 3) {
    		if (!visited[6]) neighbors.remove(9);
    		if (!visited[5]) neighbors.remove(7);
    		if (!visited[2]) neighbors.remove(1);
    	} else if (num == 7) {
    		if (!visited[4]) neighbors.remove(1);
    		if (!visited[8]) neighbors.remove(9);
    		if (!visited[5]) neighbors.remove(3);
    	} else if (num == 9) {
    		if (!visited[5]) neighbors.remove(1);
    		if (!visited[6]) neighbors.remove(3);
    		if (!visited[8]) neighbors.remove(7);
    	} else if (num == 2) {
    		if (!visited[5]) neighbors.remove(8);
    	} else if (num == 4) {
    		if (!visited[5]) neighbors.remove(6);
    	} else if (num == 6) {
    		if (!visited[5]) neighbors.remove(4);
    	} else if (num == 8) {
    		if (!visited[5]) neighbors.remove(2);
    	}
    	return neighbors;
    }



*/