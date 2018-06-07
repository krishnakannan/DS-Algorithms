import java.util.*;
import java.lang.*;
import java.io.*;

class RaceCar {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int target = in.nextInt();
		RaceCar rc = new RaceCar();
		System.out.println(rc.racecar(target));
	}

	//412 MS

	HashSet<String> visited = new HashSet<>();
   	public int racecar(int target) {
        int position = 0;
        int speed = 1;
        int steps = 0;
        
        Queue<int[]> bfsQ = new LinkedList<>();
        bfsQ.add(new int[]{position, speed, steps});        
        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            for (int i = 0; i < size; i++) {
                int[] polled = bfsQ.poll();
                visited.add(polled[0] + "#" + polled[1]);
                if (polled[0] == target) {
                    return polled[2];
                }
                
                int accelerate = polled[0] + polled[1];
    	        int reverse = polled[0];    	
                if (accelerate == target) {
                    return polled[2] + 1;
                }
                if (reverse == target) {
                    return polled[2] + 1;
                }
                String accelerateString = accelerate + "#" + (polled[1] * 2);
                String reverseString = reverse + "#" + (polled[1] > 0 ? -1 : 1);
                if (accelerate > 0 && diff(target, accelerate) <= (target - 1) && !visited.contains(accelerateString)) {
                    bfsQ.add(new int[]{accelerate, polled[1] * 2, polled[2] + 1});    
                    visited.add(accelerateString);
                }
                if (reverse > 0 && diff(target, reverse) <= (target - 1) && !visited.contains(reverseString)) {
                    bfsQ.add(new int[]{reverse, polled[1] > 0 ? -1 : 1, polled[2] + 1});    
                    visited.add(reverseString);
                } 
            }        	
        }
        return -1;        
    }

    public int diff(int a, int b) {
    	return a > b ? a - b : b - a;
    }
}

//532 MS

// The implementation and asymtotic complexities are same. Reducing method calls and object creations. (This soln was accepted only once in LC)

//     public int racecar(int target) {
//         int position = 0;
//         int speed = 1;
//         int steps = 0;
//         Queue<int[]> bfsQ = new PriorityQueue<int[]>(new Comparator<int[]>(){
//         	public int compare(int[] a, int[] b) {
//         		if (diff(a[0], target) == diff(b[0], target)) {
//         			if (a[0] == b[0]) {
//         				return a[2] - b [2];
//         			}
//         			return a[0] - b[0];
//         		}
//         		return diff(a[0], target) - diff(b[0], target);        		
//         	}
//         });
//         //Queue<int[]> bfsQ = new LinkedList<>();
//         bfsQ.add(new int[]{position, speed, steps});
//         Map<Integer, Integer> stepsMap = new HashMap<>();
//         while (!bfsQ.isEmpty()) {
//         	int[] polled = bfsQ.poll();
//         	//System.out.println(Arrays.toString(polled));
//         	if (polled[0] == target) {
//         		return polled[2];
//         	}
//         	List<int[]> neighbors = getNeighbors(polled, target);
//         	for (int[] neighbor : neighbors) {
//         		if (!stepsMap.containsKey(neighbor[0]))	{
//         			stepsMap.put(neighbor[0], neighbor[1]);
//         			// bfsQ.add(neighbor);
//         		}
//         		//  else if (stepsMap.get(neighbor[0]) > neighbor[1]) {
//         		// 	stepsMap.put(neighbor[0], neighbor[1]);
//         		// 	bfsQ.add(neighbor);
//         		// }
//         		// if (neighbor[0] == target) {
//         		// 	return neighbor[2];
//         		// }
//         		bfsQ.add(neighbor);
//         	}
//         }

//         return -1;        
//     }

//     public List<int[]> getNeighbors(int[] current, int target) {
//     	int accelerate = current[0] + current[1];
//     	int reverse = current[0];    	
//     	List<int[]> neighbors = new ArrayList<>();
//         if (accelerate > 0 && diff(target, accelerate) <= target) {
//             neighbors.add(new int[]{accelerate, current[1] * 2, current[2] + 1});    
//         }
//     	if (reverse > 0 && diff(target, reverse) <= target) {
//             neighbors.add(new int[]{reverse, current[1] > 0 ? -1 : 1, current[2] + 1});    
//         }
//     	System.out.print(Arrays.toString(current) + " => " );
//     	for (int[] neighbor : neighbors) {
//     		System.out.print(" " + Arrays.toString(neighbor));
//     	}
//     	System.out.println();
//     	return neighbors;
//     }

//     public int diff(int a, int b) {
//     	return a > b ? a - b : b - a;
//     }
// }