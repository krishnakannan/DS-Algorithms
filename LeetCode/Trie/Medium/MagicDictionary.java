class MagicDictionary {

	class TrieNode {
		char ch;
		boolean isEnd;
		Map<Character, TrieNode> next;

		public TrieNode(char ch) {
			this.ch = ch;
			this.isEnd = false;
			next = new HashMap<>();
		}

		public TrieNode(char ch, boolean isEnd) {
			this.ch = ch;
			this.isEnd = isEnd;
			next = new HashMap<>();
		}
	}

	TrieNode head;

    /** Initialize your data structure here. */
    public MagicDictionary() {
    	// Dummy Head;
        head = new TrieNode('*');
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
    	head = new TrieNode('*');
        for (String word : dict) {
        	int wLen = word.length();
        	TrieNode trav = head;
        	for (int i = 0; i < wLen; i++) {
        		if (!trav.next.containsKey(word.charAt(i))) {        			
        			trav.next.put(word.charAt(i), new TrieNode(word.charAt(i)));	     			
        		}
        		trav = trav.next.get(word.charAt(i));
        	}
        	trav.isEnd = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {        
    	char[] wordArray = word.toCharArray();
        int index = 0;
        while (index < wordArray.length) {
        	char existing = word.charAt(index);
        	for (char x = 'a'; x <= 'z'; x++) {
        		if (x == existing) {
        			continue;
        		} else {
        			char temp = wordArray[index];
        			wordArray[index] = x;
                    //System.out.println(new String(wordArray));
        			if (find(wordArray)) {
        				return true;
        			}
        			wordArray[index] = temp;
        		}
	        }
            index++;
        }

        return false;
    }

    public boolean find(char[] word) {
    	TrieNode trav = head;
    	for (int i = 0; i < word.length; i++) {
    		if (trav.next.containsKey(word[i])) {
    			trav = trav.next.get(word[i]);
    		} else {
    			return false;
    		}
    	}
    	return trav.isEnd;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */