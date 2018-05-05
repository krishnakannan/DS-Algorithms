import java.util.*;
import java.lang.*;   
import java.io.*;

class PalindromicPairs {

	public static void main(String args[]) {
		PalindromicPairs pp = new PalindromicPairs();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < words.length; i++) {
			words[i] = in.next();			
		}
		System.out.println(pp.palindromePairs(words));
	}

	 TrieNode {
		char c;
		int wordIndex;
		boolean isEnd;
		TrieNode[] next;
		public TrieNode(char c) {
			this.c = c;			
			this.isEnd = false;
			next = new TrieNode[26];
		}
		public TrieNode(char c, int index, boolean isEnd) {
			this.c = c;
			this.wordIndex = index;			
			this.isEnd = isEnd;
			next = new TrieNode[26];
		}
	}

	TrieNode root;
	Set<List<Integer>> pairs;
    int emptyStringIndex = -1;
    public List<List<Integer>> palindromePairs(String[] words) {
        root = new TrieNode('*');
        buildTrie(words);
        pairs = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            getPalindromicPairs(words, words[i], i);
        }
        return new ArrayList<>(pairs);
    }
    
    

    public void getPalindromicPairs(String[] words, String wordString, int currentWordIndex) {
    	int length = wordString.length();
        if (wordString.isEmpty()) {
            for (int i = 0; i < words.length; i++) {
                if (i != currentWordIndex) {
                    if (isPalindrome(words[i])) {
                        List<Integer> pair1 = new ArrayList<>();
                        pair1.add(i);
                        pair1.add(currentWordIndex);
                        pairs.add(pair1);
                        List<Integer> pair2 = new ArrayList<>();
                        pair2.add(currentWordIndex);
                        pair2.add(i);
                        pairs.add(pair2);
                    }
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                String str1 = wordString.substring(0, i);
                String str2 = wordString.substring(i);            
                if (isPalindrome(str1)) {
                    String rev = new StringBuilder(str2).reverse().toString();
                    int searchResult = searchTrie(rev);
                    if (searchResult >= 0 && searchResult != currentWordIndex) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(searchResult);
                        pair.add(currentWordIndex);
                        pairs.add(pair);
                    }
                }

                if (isPalindrome(str2)) {
                    String rev = new StringBuilder(str1).reverse().toString();
                    int searchResult = searchTrie(rev);
                    if (searchResult >= 0 && searchResult != currentWordIndex) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(currentWordIndex);
                        pair.add(searchResult);
                        pairs.add(pair);
                    }
                }
            }   
        }        
    }

    public boolean isPalindrome(String wordString) {        
        char[] word = wordString.toCharArray();
        if (word == null) {
            word = wordString.toCharArray();
        }         
    	int left = 0;
    	int right = word.length - 1;        
    	while (left <= right) {
    		if (word[left] != word[right]) {
    			return false;
    		}
    		left++;
    		right--;
    	}
    	return true;
    }

    public int searchTrie(String wordString) {    	
        if (wordString.isEmpty()) {
            return emptyStringIndex;
        }
        char[] word = wordString.toCharArray();
    	TrieNode trav = root;
    	for (int i = 0; i < word.length; i++) {    		
    		if (trav.next[word[i] - 'a'] == null) {
    			return -1;
    		}
    		trav = trav.next[word[i] - 'a'];
    	}
    	if (trav == null || !trav.isEnd) {
    		return -1;
    	}
    	return trav.wordIndex;
    }

    public void buildTrie(String[] words) {
    	for (int i = 0; i < words.length; i++) {
    		addWordToTrie(words[i], i);
    	}
    }

    public void addWordToTrie(String wordString, int index) {
        if (wordString.isEmpty()) {
            emptyStringIndex = index;
            return;
        }
        char[] word = wordString.toCharArray();
    	TrieNode trav = root;
    	for (int i = 0; i < word.length; i++) {
    		if (trav.next[word[i] - 'a'] == null) {
    			trav.next[word[i] - 'a'] = new TrieNode(word[i]);    
    		}	
    		trav = trav.next[word[i] - 'a'];    		
    	}
    	trav.isEnd = true;
    	trav.wordIndex = index;
    }
}