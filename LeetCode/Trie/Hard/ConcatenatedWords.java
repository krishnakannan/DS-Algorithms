import java.util.*;
import java.lang.*;
import java.io.*;

class ConcatenatedWords {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String words[] = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = in.next();
		}
		ConcatenatedWords cw = new ConcatenatedWords();
		System.out.println(cw.findAllConcatenatedWordsInADict(words));
	}

	Set<String> repeatedMemo;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        repeatedMemo = new HashSet<>();
        buildTrie(words);
        List<String> concatenatedWords = new ArrayList<>();
        for (String word : words) {
            if (search(root, "", word, 0)) {
                concatenatedWords.add(word);
                //System.out.println("************ Word *************" + word + " is concatenated");
            } else {
                //System.out.println("************ Word *************" + word + " is not concatenated");
            }
        }
        //System.out.println(repeatedMemo);
        return concatenatedWords;
    }


    /*  SEARCHING TRIE */

    public boolean search(TrieNode trav, String prefix, String word, int repeats) {
        //System.out.println("Search char " + trav.c + " WORD " + new String(word) + " WordCOunt " + repeats);
        if (repeatedMemo.contains(word)) {
            return true;
        }

        if (word.length() == 0) {
            if (repeats <= 1) {
                return false;
            } else {                
                return true;
            }           
        }

        boolean isConcatenated = false;
        for (int i = 0; i < word.length(); i++) {
            if (trav.next[word.charAt(i) - 'a'] != null) {
                trav = trav.next[word.charAt(i) - 'a'];
                if (trav.isEnd) {
                    isConcatenated |= search(root,word.substring(0, i + 1), word.substring(i + 1, word.length()), repeats + 1);
                } 
            } else {
                break;
            }
        }
        if (isConcatenated) {                        
            repeatedMemo.add(prefix + word);                                    
        }

        return isConcatenated;
    }


    /* CREATING AND BUILDING TRIE */

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
                trav.next[word[i] - 'a'] =  new TrieNode(word[i]);
            }
            trav = trav.next[word[i] - 'a'];
        }
        trav.isEnd = true;
    }
}