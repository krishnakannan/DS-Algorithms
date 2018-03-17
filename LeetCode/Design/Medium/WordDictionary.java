class WordDictionary {

	class TrieNode {

		char val;
		boolean isEnd;
		Map<Character, TrieNode> next;

		public TrieNode(char val) {
			this.val = val;
			this.isEnd = false;
			next = new HashMap<>();
		}

		public TrieNode(char val, boolean isEnd) {
			this.val = val;
			this.isEnd = isEnd;
			next = new HashMap<>();
		}
	}

	TrieNode head;

    /** Initialize your data structure here. */
    public WordDictionary() {
    	//Dummy Head;
        head = new TrieNode('*', true);
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] wArray = word.toCharArray();
        TrieNode traverse = head;
        for (int i = 0; i < wArray.length; i++) {
        	if (!traverse.next.containsKey(wArray[i])) {
        		if (i == wArray.length - 1) {
        			traverse.next.put(wArray[i], new TrieNode(wArray[i], true));
        		} else {
        			traverse.next.put(wArray[i], new TrieNode(wArray[i]));	
        		}        		
        	}
        	traverse = traverse.next.get(wArray[i]);
        }	
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {        
        return search(word.toCharArray(), new char[0], 0, head);
    }

    public boolean search(char[] searchWord, char[] formedWord, int currentIndex, TrieNode currentNode) {

    	//End Condition
    	if (searchWord.length == formedWord.length) {
    		if (currentNode.isEnd) {
    			return true;
    		} else {
    			return false;
    		}
    	}

    	char currentChar = searchWord[currentIndex];
    	boolean isPresent = false;
    	if (currentChar == '.') {

    		for (Map.Entry<Character, TrieNode> entry : currentNode.next.entrySet()) {
    			char[] nextWord = getNextWord(formedWord, entry.getKey());
    			isPresent = search(searchWord, nextWord, currentIndex + 1, entry.getValue());

    			if (isPresent) {
    				return true;
    			}
    		}

    	} else {
    		if (currentNode.next.containsKey(searchWord[currentIndex])) {
    			char[] nextWord = getNextWord(formedWord, searchWord[currentIndex]);
    			isPresent = search(searchWord, nextWord, currentIndex + 1, currentNode.next.get(searchWord[currentIndex]));
    		} else {
    			return false;
    		}
    	}

    	return false || isPresent;

    }

    public char[] getNextWord(char[] formedWord, char lastChar) {
    	char[] nextWord = new char[formedWord.length + 1];
    	for (int i = 0; i < formedWord.length; i++) {
    		nextWord[i] = formedWord[i];
    	}
    	nextWord[nextWord.length - 1] = lastChar;
    	return nextWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */