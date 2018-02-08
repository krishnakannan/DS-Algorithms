import java.util.*;
import java.lang.*;
import java.io.*;

class MaxChunksToBeSorted {

	class Chunk {
		int fIndex;
		int eIndex;
		int max;
		int min;

		public Chunk(int fIndex, int eIndex, int max, int min) {
			this.fIndex = fIndex;
			this.eIndex = eIndex;
			this.max = max;
			this.min = min;
		}
	}

	public static void main(String args[]) {
		MaxChunksToBeSorted mx = new MaxChunksToBeSorted();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(mx.maxChunksToSorted(arr));
	}

	Stack<Chunk> stack = new Stack<>();

    public int maxChunksToSorted(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			int startIndex = i;
			int endIndex = i + 1;
			int min = arr[i];
			int max = arr[i];

			while (endIndex < arr.length && current > arr[endIndex]) {
				min = min > arr[endIndex] ? arr[endIndex] : min;
				max = max < arr[endIndex] ? arr[endIndex] : max;
				endIndex++;
			}
			Chunk newChunk = new Chunk(startIndex, endIndex, max, min);
			checkStack(newChunk);
		}


		return stack.size();
    }

    public void checkStack(Chunk newChunk) {
    	while (!stack.empty()) {    		
    		Chunk currentChunk = stack.pop();    		
    		if (newChunk.min < currentChunk.max) {
    			newChunk.fIndex = currentChunk.fIndex;
    			newChunk.min = currentChunk.min < newChunk.min ? currentChunk.min : newChunk.min;
    			newChunk.max = currentChunk.max > newChunk.max ? currentChunk.max : newChunk.max;
    		} else {
    			stack.push(currentChunk);
    			stack.push(newChunk);
    			return;
    		}
    	}
    	stack.push(newChunk);
    	return;
    }
}