import java.util.*;
import java.lang.*;
import java.io.*;


class ReplaceWords {
	TNode head;

	{
		head = new TNode();
	}

	class TNode{
		private TNode[] next;
		private boolean isWord = false;		

		public TNode() {
			this.next = new TNode[26];
		}

		public boolean containsKey(char ch) {
			return next[ch - 'a'] != null;
		}

		public TNode get(char ch) {
			return next[ch - 'a'];
		}

		public void put(char ch, TNode node) {
			next[ch - 'a'] = node;
		}

		public void setWord() {
			this.isWord = true;
		}

		public boolean isWord() {
			return isWord;
		}
	}
	

	public static void main(String args[]) {
		ReplaceWords replaceWordsObj = new ReplaceWords();	
		Scanner in = new Scanner(System.in);
		System.out.println("Enter no of Testcases");
		int testcases = in.nextInt();		
		while (--testcases >= 0) {			
			System.out.println("Enter the size of dict");
			int n = in.nextInt();
			String[] dict = new String[n];
			for (int i = 0; i < dict.length; i++) {
				dict[i] = in.next();
			}
			System.out.println("Enter the Sentence");
			in.nextLine();
			String sentence = in.nextLine();
			System.out.println(replaceWordsObj.replaceWords(Arrays.asList(dict), sentence));
		}
	}

	public String replaceWords(List<String> dict, String sentence) {    	    	
		createDictTrie(dict);
		String[] words = sentence.split(" ");
		List<String> newWords = new ArrayList<>();
		StringBuilder newSentence = new StringBuilder();    	
		for (String word : words) {    		
			String rootWord = findRootWord(word);
			if (rootWord.isEmpty()) {    			
				newWords.add(word);
			} else {
				newWords.add(rootWord);
			}
		}

		for (String word : newWords) {
			newSentence.append(word + " ");
		}
		newSentence.setLength(newSentence.length() - 1);
		return newSentence.toString();
	}

	public String findRootWord(String word) {
		StringBuilder rootWord = new StringBuilder();
		TNode trav = head;
		char[] wordArr = word.toCharArray();
		for (int i = 0; i < wordArr.length; i++) { 
			if (trav.containsKey(wordArr[i])) {    			    			
				rootWord.append(wordArr[i]);                    			
				trav = trav.get(wordArr[i]);
				if (trav.isWord()) {
					break;
				}
				
			} else {                  
				rootWord.setLength(0);
				break;
			}
		}
		return rootWord.toString();
	}

	public void createDictTrie(List<String> dict) {
		for (String word : dict) {
			TNode trav = head;
			char[] wordArr = word.toCharArray();            
			for (int i = 0; i < wordArr.length; i++) {    			                
				if (!trav.containsKey(wordArr[i])) {
						trav.put(wordArr[i], new TNode());
					}                                
				trav = trav.get(wordArr[i]);                                
			}               
			trav.setWord();            
		}       	
	}
}