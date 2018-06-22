import java.util.*;
import java.lang.*;
import java.io.*;

class SplitIntoFibonacci {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		SplitIntoFibonacci sif = new SplitIntoFibonacci();
		System.out.println(sif.splitIntoFibonacci(s));
	}

	
    public List<Integer> splitIntoFibonacci(String s) {
 		//The sequence must have atleast 2 commas - 3 numbers;    	
 		if (s.length() < 3) {
 			return new ArrayList<>();
 		} 		
 		int size = s.length();
 		for (int i = 1; i < size - 1; i++) {
 			for (int j = i + 1; j < size; j++) {
 				String candidate = s.substring(0, i) + "," + s.substring(i, j) + "," + s.substring(j, size);
 				//System.out.println("Candidate " + candidate);
 				String[] candidateArray = candidate.split(",");
				if ((candidateArray[0].length() > 1 && candidateArray[0].startsWith("0")) || (candidateArray[1].length() > 1 && candidateArray[1].startsWith("0"))) {
					continue;
				}		
 				long first = getNum(candidateArray[0]);
 				long second = getNum(candidateArray[1]);
 				if (first > Integer.MAX_VALUE || second > Integer.MAX_VALUE) {
 					continue;
 				}

 				List<Integer> startList = new ArrayList<>();
 				startList.add((int)first);
 				startList.add((int)second);

 				List<Integer> fiboList = formSequence(startList, candidateArray[2]);
 				if (!fiboList.isEmpty()) {
 					return fiboList;
 				}
 			}
 		}
 		return new ArrayList<>();
    }

    public List<Integer> formSequence(List<Integer> fiboList, String s) {
    	int addVal = fiboList.get(fiboList.size() - 1) +fiboList.get(fiboList.size() - 2);

    	long val = 0l;
    	int index = 0;
    	boolean parsedWord = false;
    	while (index < s.length()) {
    		parsedWord = false;
    		val *= 10;
    		val += s.charAt(index) - '0';

    		if (val == addVal) {
    			addVal -= fiboList.get(fiboList.size() - 2);
    			addVal += val;
    			fiboList.add((int)val);
    			val = 0;
    			parsedWord = true;
    		} else if (val > addVal) {
    			return new ArrayList<>();
    		}

    		index += 1;
    	}

    	return !parsedWord ? new ArrayList<>() : fiboList;

    }

    public long getNum(String s) {
    	if (s.length() > 10) {
    		return Integer.MAX_VALUE + 1l;
    	}
    	long val = 0l;
    	int index = 0;
    	while (index < s.length()) {
    		val *= 10;
    		val += s.charAt(index) - '0';    		
    		index += 1;
    	}
    	return val;
    }

}