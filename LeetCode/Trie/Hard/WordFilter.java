class WordFilter {

	class FTrieNode {
		char c;
		FTrieNode[] next;
		boolean[] suffix;
		boolean isEnd;
		int weight;
		public FTrieNode(char c) {
			this.c = c;
			this.next = new FTrieNode[26];
			suffix = new boolean[26];
			this.isEnd = false;
			this.weight = 0;			
		}
	}

	FTrieNode fwdRoot;
	String[] words;

    public WordFilter(String[] words) {
    	fwdRoot = new FTrieNode('*');
    	this.words = words;
    	buildTries();
    }
    
    public int f(String prefix, String suffix) {
        if (prefix.length() == 0 && suffix.length() == 0) {
            return words.length - 1;
        }
        FTrieNode trav = fwdRoot;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < prefix.length(); i++) {
        	trav = trav.next[prefix.charAt(i) - 'a'];            
        	if (trav == null) {
        		return -1;
        	}
            builder.append(trav.c);
        }        
        return search(trav, suffix, builder.toString());
    }

    public void buildTries() {
    	for (int i = 0; i < words.length; i++) {
    		insertIntoFTrie(words[i], i);
    	}
    }

    public int search(FTrieNode root, String suffix, String formed) {        
    	if (root == null) {            
    		return -1;
    	}
        
        int maxWeight = -1;
        if (root.isEnd) {          
            maxWeight = formed.endsWith(suffix) ? root.weight : -1;
        }
        
    	FTrieNode[] children = root.next;
    	
    	for (int i = 0; i < children.length; i++) {
            int weight = -1;
            if (children[i] != null) {
                if (children[i].isEnd) {                        
                    String tempFormed = formed + "" + children[i].c;                    
                    int temp = tempFormed.endsWith(suffix) || suffix.endsWith(tempFormed) ? children[i].weight : -1;                    
                    maxWeight = temp > maxWeight ? temp : maxWeight;
                }
                boolean hasSuffix = true;
                for (int j = 0; j < suffix.length(); j++) {
                    if (!children[i].suffix[suffix.charAt(j) - 'a']) {
                        hasSuffix = false;
                        break;
                    }
                }
                if (hasSuffix) {
                    weight = search(children[i], suffix, formed + "" + children[i].c);
                }
            }    		
    		maxWeight = weight > maxWeight ? weight : maxWeight;
    	}

    	return maxWeight;
    }

    public void insertIntoFTrie(String wordString, int weight) {
    	char[] word = wordString.toCharArray();
    	FTrieNode trav = fwdRoot;
    	for (int i = 0; i < word.length; i++) {
    		if (trav.next[word[i] - 'a'] == null) {
    			trav.next[word[i] - 'a'] = new FTrieNode(word[i]);
    		}            
    		for (int j = 0; j < word.length; j++) {                             
    			trav.suffix[word[j] - 'a'] = true;
    		}
    		trav = trav.next[word[i] - 'a'];
    	}      
    	trav.isEnd = true;
    	trav.weight = weight > trav.weight ? weight : trav.weight;
    } 
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */