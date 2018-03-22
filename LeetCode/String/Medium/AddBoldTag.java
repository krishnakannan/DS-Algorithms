import java.util.*;
import java.lang.*;
import java.io.*;

class AddBoldTag {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		AddBoldTag abt = new AddBoldTag();
		String str = in.next();
		int dSize = in.nextInt();
		String[] dict = new String[dSize];
		for (int i = 0; i < dSize; i++) {
			dict[i] = in.next();
		}
		System.out.println(abt.addBoldTag(str, dict));
	}

    public String addBoldTag(String s, String[] dict) {
        List<int[]> occurences = new ArrayList<>();
        

        for (String pattern : dict) {
        	List<int[]> currentOccurences = KMP(s, pattern);
        	occurences.addAll(currentOccurences);
        }


		Collections.sort(occurences, new Comparator<int[]>(){
        	public int compare(int[] a, int[] b) {
        		return a[0] - b[0];
        	}
        });

		List<int[]> finalOccurences = mergeOverlappingIntervals(occurences);


		int index = 0;
		StringBuilder sBuilder = new StringBuilder();

		for (int[] occurence : finalOccurences) {			
			int before = occurence[0];
			int after = occurence[1];
			while (index < before) {
				sBuilder.append(s.charAt(index));
				index++;
			}
			sBuilder.append("<b>");
			while (index <= after) {
				sBuilder.append(s.charAt(index));
				index++;
			}
			sBuilder.append("</b>");
		}
        
        while (index < s.length()) {
            sBuilder.append(s.charAt(index));
            index++;
        }


		// for (int[] index : occurences) {
		// 	System.out.println(index[0] + " " + index[1]);
		// }
		// System.out.println();

		// for (int[] idx : finalOccurences) {
		// 	System.out.println(idx[0] + " " + idx[1]);
		// }
		// System.out.println();


        return sBuilder.toString();
    }


    public List<int[]> mergeOverlappingIntervals(List<int[]> intervals) {
    	List<int[]> fOccurences = new ArrayList<>();

    	int size = intervals.size();
        if (size == 0){
            return fOccurences;
        }
        
    	int[] prev = intervals.get(0);

    	for (int i = 1; i < size; i++) {
    		int[] current = intervals.get(i);
    		if (prev[1] >= current[0] || current[0] - 1 == prev[1]) {
    			prev[1] = prev[1] < current[1] ? current[1] : prev[1];
    		} else {
    			fOccurences.add(prev);
    			prev = current;
    		}
    	}

    	fOccurences.add(prev);

    	return fOccurences;

    }


    public List<int[]> KMP(String s, String p) {
        List<int[]> occurences = new ArrayList<>();
        if (p.length() == 0 || s.length() == 0) {
            return occurences;
        }
    	char[] pattern = p.toCharArray();
    	char[] string = s.toCharArray();
    	int[] prefixArray = getPrefixArray(pattern);
    	


    	int pIndex = 0;
    	int sIndex = 0;
    	while (sIndex < string.length) {
    		if (string[sIndex] == pattern[pIndex]) {
    			if (pIndex == pattern.length - 1) {    				    				
    				int end = sIndex;
    				int start = sIndex - pattern.length + 1; 
    				occurences.add(new int[]{start, end});
    				sIndex = start + 1;
    				pIndex = 0;
    				continue;
    			}
    			sIndex++;
    			pIndex++;
    		} else {
    			if (pIndex > 0) {
    				pIndex = prefixArray[pIndex - 1];
    			} else {
    				sIndex++;
    			}
    		}
    	}
    	return occurences;
    }

    public int[] getPrefixArray(char[] pattern) {
    	int[] prefixArray = new int[pattern.length];
    	if (pattern.length == 0) {
    		return prefixArray;
    	}

    	prefixArray[0] = 0;

    	int left = 0;
    	int right = 1;
    	while (right < pattern.length) {
    		if (pattern[right] == pattern[left]) {
    			prefixArray[right] = left + 1;
    			right++;
    			left++;
    		} else {
    			if (left > 0) {
    				left = prefixArray[left - 1];	
    			} else {
    				prefixArray[right] = 0;
    				right++;	
    			}    			
    		}
    	}
    	return prefixArray;
    }

}