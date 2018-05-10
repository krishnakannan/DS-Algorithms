import java.util.*;
import java.lang.*;   
import java.io.*;

class WordSquares {

	public static void main(String args[]) {
		WordSquares ws = new WordSquares();

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = in.next();
		}

		ws.wordSquares(words);
		for (List<String> square : ws.squares) {
			for (String word : square) {
				System.out.println(word);
			}
			System.out.println();			
		}		
	}

	List<List<String>> squares;

    public List<List<String>> wordSquares(String[] words) {
 		squares = new ArrayList<>();
 		buildTrie(words);
 		Set<String> wordSet = new HashSet<>();
        if (words.length == 0) {
            return squares;
        }
 		for (int i = 0; i < words.length; i++) {
 			wordSet.add(words[i]);
 		}        
        if (words[0].length() == 1) {
            for (String wordInSet : wordSet) {
                List<String> list = new ArrayList<>();
                list.add(wordInSet);
                squares.add(list);
            }
            return squares;
        }
 		for (String word : wordSet) {
 			char[][] formedGrid = new char[word.length()][word.length()];
 			for (int j = 0; j < word.length(); j++) {
 				formedGrid[0][j] = word.charAt(j);
 			} 	
 			
 			search(formedGrid, 1, 1);
 		}

 		return squares;       
    }

    public void search(char[][] formedGrid, int fx, int depthLevel) {    	
    	  	
    	if (fx >= formedGrid.length) {
    		squares.add(getStrings(formedGrid));
    		return;
    	}
    	
    	String prefix = getStartsWith(formedGrid, depthLevel);    	
    	List<String> nextLevelWords = getWordsWithPrefix(prefix.toCharArray());    	
    	for (String nextLevelWord : nextLevelWords) {
    		for (int j = 0; j < formedGrid[0].length; j++) {
    			formedGrid[depthLevel][j] = nextLevelWord.charAt(j);
    		}
    		search(formedGrid, fx + 1, depthLevel + 1);
    	}
    	
    }

    public List<String> getWordsWithPrefix(char[] prefix) {
    	List<String> words = new ArrayList<>();
    	TrieNode trav = root;
    	for (int i = 0; i < prefix.length; i++) {
    		if (trav.next[prefix[i] - 'a'] == null) {
    			return words;
    		}
    		trav = trav.next[prefix[i] - 'a'];
    	}
    	formWordsWithPrefix(prefix, trav, words, "");
    	return words;
    }

    public void formWordsWithPrefix (char[] prefix, TrieNode trav, List<String> words, String formed) {
    	if (trav == null) {
    		return;
    	}
    	
    	if (trav.isEnd) {
    		words.add(new String(prefix) + "" + formed);    		
    		return;
    	}

    	for (int i = 0; i < 26; i++) {
    		if (trav.next[i] != null) {
    			formWordsWithPrefix(prefix, trav.next[i], words, formed + trav.next[i].c);
    		}
    	}
    }

    public String getStartsWith(char[][] grid, int depth) {
    	StringBuilder s = new StringBuilder();
    	for (int i = 0; i < depth; i++) {
    		s.append(grid[i][depth]);
    	}    	
    	return s.toString();
    }

    public List<String> getStrings(char[][] formedGrid) {    	    	
    	int startIndex = 0;
    	List<String> grid = new ArrayList<>();
    	for (char[] formedWord : formedGrid) {
    		grid.add(new String(formedWord));
    	}
    	return grid;
    }

    class TrieNode {
    	char c;
    	TrieNode[] next;
    	boolean isEnd;
    	public TrieNode(char c) {
    		this.c = c;
    		this.next = new TrieNode[26];
    		this.isEnd = false;
    	}
    }

    TrieNode root = new TrieNode('*');

    public void buildTrie(String[] words) {
    	for (String word : words) {
    		addWordToTrie(word);
    	}
    }

    public void addWordToTrie(String wordString) {
    	char[] word = wordString.toCharArray();
    	TrieNode trav = root;
    	for (int i = 0; i < word.length; i++) {
    		if (trav.next[word[i] - 'a'] == null) {
    			trav.next[word[i] - 'a'] = new TrieNode(word[i]);
    		}
    		trav = trav.next[word[i] - 'a'];    		
    	}    	
    	trav.isEnd = true;
    }
}