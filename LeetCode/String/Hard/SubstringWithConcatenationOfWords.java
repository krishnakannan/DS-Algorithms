import java.util.*;
import java.lang.*;
import java.io.*;

class SubstringWithConcatenationOfWords {

	public static void main(String args[]) {
		SubstringWithConcatenationOfWords swcw = new SubstringWithConcatenationOfWords();
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = in.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = in.next();
		}
		System.out.println(swcw.findSubstring(s, words));
	}

	List<Integer> startPoints = new ArrayList<>();

    public List<Integer> findSubstring(String s, String[] words) {

    	if (s == null || s.isEmpty() || words.length == 0) {
    		return startPoints;
    	}

    	Map<String, Integer> map = new HashMap<>();
    	int totalWLength = 0;
    	for (String word : words) {
    		totalWLength++;
    		map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
    	}
    	int wLength = words[0].length();
    	totalWLength *= wLength;

    	int sLen = s.length();
    	for (int i = 0; i <= sLen - totalWLength; i++) {
    		//System.out.println(map);
    		countStartPoints(s, map, 0, words.length, i, wLength, i);
    	}

    	return startPoints;
    }


    public void countStartPoints(String s, Map<String, Integer> map, int formedWords, int totalWords, int currentIndex, int wLength, int startPoint) {


    	if (formedWords == totalWords) {
    		startPoints.add(startPoint);
    		return;
    	}

    	if (currentIndex + wLength > s.length()) {
    		return;
    	}

    	String nextWord = s.substring(currentIndex, currentIndex + wLength);

    	if (map.containsKey(nextWord) && map.get(nextWord) > 0) {
    		map.put(nextWord, map.get(nextWord) - 1);

    		countStartPoints(s, map, formedWords + 1, totalWords, currentIndex + wLength, wLength, startPoint);

    		map.put(nextWord, map.get(nextWord) + 1);
    	} else {
    		return;
    	}
    }
}