import java.util.*;
import java.lang.*;
import java.io.*;


class RepeatedDNASequences {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		RepeatedDNASequences rds = new RepeatedDNASequences();
		System.out.println(rds.findRepeatedDnaSequences(s));
	}

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> dnaMap = new HashMap<>();        
        List<String> repeatedSequences = new ArrayList<>();
        if (s.length() <= 10) {
        	return repeatedSequences;
        }
        char[] sequenceArray = s.toCharArray();
        int lIndex = 0;
        int rIndex = 9;

        while (lIndex < sequenceArray.length && rIndex < sequenceArray.length) {
        	String sequence = new String(sequenceArray, lIndex, rIndex - lIndex + 1);
        	dnaMap.put(sequence, dnaMap.containsKey(sequence) ? dnaMap.get(sequence) + 1 : 1);
        	lIndex++;
        	rIndex++;
        }

        for (Map.Entry<String, Integer> entry : dnaMap.entrySet()) {
        	if (entry.getValue() > 1) {
        		repeatedSequences.add(entry.getKey());
        	}
        }

        return repeatedSequences;

    }
}