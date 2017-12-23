import java.util.*;
import java.lang.*;
import java.io.*;


class WordBreakII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		WordBreakII wb = new WordBreakII();
		List<String> dict = new ArrayList<>();
		String dictWord = in.next();
		while (!dictWord.equals("0")) {
			dict.add(dictWord);
			dictWord = in.next();
		}
		String s = in.next();
		long startTime = System.nanoTime();
		System.out.println();		
		List<String> sentences = wb.wordBreak(s, dict);		
		System.out.println((System.nanoTime() - startTime)/(1000 * 1000) + " Milliseconds");
		System.out.println(sentences);		
	}

	Set<String> wordSet;
	HashMap<Integer, List<String>> dpMap = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
    	wordSet = new HashSet<String>(wordDict);    	
     	return wordBreak(s, 0);   
    }

    public List<String> wordBreak(String s, int sIndex) {    	
    	
    	if (dpMap.containsKey(sIndex)) {    		
    		return dpMap.get(sIndex);
    	}


    	List<String> generatedWords = new ArrayList<>();
    	
    	if (sIndex == s.length()) {
    		generatedWords.add(" ");
    		return generatedWords;
    	}
    	
    	int sLength = s.length();
    	
    	for (int i = sIndex; i < sLength; i++) {
    		if (dictContains(s.substring(sIndex, i + 1))) {
    			List<String> gen = wordBreak(s, i + 1);
    			for (String str : gen) {
	                generatedWords.add(s.substring(sIndex, i + 1) + (str.equals("") ? "" : " ") + str);
	            }                	    		
    		}
    		dpMap.put(sIndex, generatedWords);
    	}

    	return generatedWords;
    }


    public boolean dictContains(String s) {
    	return wordSet.contains(s);
    }



}


/*

	BACKTRACKING WITHOUT MEMOIZATION

	Set<String> wordSet;
	List<String> sentences;
    public List<String> wordBreak(String s, List<String> wordDict) {
    	wordSet = new HashSet<String>(wordDict);
    	sentences = new ArrayList<>();
     	wordBreak(s, new ArrayList<>(), new StringBuilder(), 0, s.length());   
     	return sentences;
    }

	public void wordBreak(String s, List<String> generatedWords, StringBuilder currentWord, int sIndex, int sLength) {
    	
    	if (sIndex == s.length()) {
    		if (dictContains(generatedWords.get(generatedWords.size() - 1))) {    			
    			sentences.add(generateSentence(generatedWords));    			
    			currentWord = new StringBuilder();
    			return;
    		} else {
    			return;
    		}
    	}

    	for (int i = sIndex; i < sLength; i++) {
    		currentWord.append(s.substring(sIndex, i + 1));    		    		
    		if (dictContains(currentWord.toString())) {    			
    			generatedWords.add(currentWord.toString());
    			wordBreak(s, generatedWords, new StringBuilder(), i + 1, sLength);
    			generatedWords.remove(generatedWords.size() - 1);
    		}
    		currentWord.setLength(0);
    	}
    }


    public boolean dictContains(String s) {
    	return wordSet.contains(s);
    }

    public String generateSentence(List<String> generatedWords) {
    	StringBuilder sBuilder = new StringBuilder();
    	for (String generatedWord : generatedWords) {
    		sBuilder.append(generatedWord);
    		sBuilder.append(" ");
    	}
    	sBuilder.setLength(sBuilder.length() - 1);
    	return sBuilder.toString();
    }

*/