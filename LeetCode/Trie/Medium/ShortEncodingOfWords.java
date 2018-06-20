import java.util.*;
import java.lang.*;
import java.io.*;

class ShortEncodingOfWords {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < words.length; i++) {
			words[i] = in.next();
		}
		ShortEncodingOfWords sew = new ShortEncodingOfWords();
		System.out.println(sew.minimumLengthEncoding(words));
	}

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });
        root = new TrieNode('*');
        int minimumLength = 0;
        for (String word : words) {
        	if (insertIntoTrie(word)) {
        		minimumLength += word.length() + 1;        		
        	}	
        }
        return minimumLength;
    }

    class TrieNode {
    	char c;
    	TrieNode[] next;
    	boolean isEnd;
    	public TrieNode(char c) {
    		this.c = c;
    		this.next = new TrieNode[26];
    	}
    }

    TrieNode root;

    public boolean insertIntoTrie(String word) {
    	boolean inserted = false;
    	TrieNode trav = root;
    	for (int i = word.length() - 1; i >= 0; i--) {
    		if (trav.next[word.charAt(i) - 'a'] == null) {
    			inserted = true;
    			trav.next[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
    		}
    		trav = trav.next[word.charAt(i) - 'a'];
    	}
    	trav.isEnd = true;
    	return inserted;
    }
}