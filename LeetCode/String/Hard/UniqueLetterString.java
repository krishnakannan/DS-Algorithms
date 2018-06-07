import java.util.*;
import java.lang.*;
import java.io.*;

class UniqueLetterString {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		UniqueLetterString uls = new UniqueLetterString();
		String s = in.next();
		System.out.println(uls.uniqueLetterString(s));
	}


	Map<Character, List<Integer>> indexMapping;
    public int uniqueLetterString(String S) {
        indexMapping = new HashMap<>();
        char[] string = S.toCharArray();
        for (int i = 0; i < string.length; i++) {
        	if (!indexMapping.containsKey(string[i])) {
        		indexMapping.put(string[i], new ArrayList<>());
        	}
        	indexMapping.get(string[i]).add(i);
        }
        //System.out.println(indexMapping);
        int total = 0;

        for (List<Integer> indexes : indexMapping.values()) {
        	int len = indexes.size();
        	for (int i = 0; i < len; i++) {
        		int prev = i == 0 ? -1 : indexes.get(i - 1);
        		int next = i == len - 1 ? string.length : indexes.get(i + 1);                
        		total += (indexes.get(i) - prev) * (next - indexes.get(i));        		
        	}
        }
        return total % 1000000007;
    }
}