class Trie {
    
    class TrieNode {
        private TrieNode[] next;
        private boolean isEnd;
        public TrieNode() {
            next = new TrieNode[26];
        }

        public boolean containsKey(char ch) {
            return next[ch -'a'] != null;
        }
        public TrieNode get(char ch) {
            return next[ch -'a'];
        }
        public void put(char ch, TrieNode node) {
            next[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }

    TrieNode head = null;
    
    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode trav = head;
        char[] wArray = word.toCharArray();
        for (int i = 0; i < wArray.length; i++) {            
            if (!trav.containsKey(wArray[i])) {
                trav.put(wArray[i], new TrieNode());
            }
            trav = trav.get(wArray[i]);
        }
        trav.setEnd();
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode trav = head;
        char[] wArray = word.toCharArray();
        for (int i = 0; i < wArray.length; i++) {            
            if (!trav.containsKey(wArray[i])) {
                return false;
            }
            trav = trav.get(wArray[i]);
        }
        if (trav.isEnd()) {
            return true;    
        } else {
            return false;
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode trav = head;
        char[] wArray = prefix.toCharArray();
        for (int i = 0; i < wArray.length; i++) {            
            if (!trav.containsKey(wArray[i])) {
                return false;
            }
            trav = trav.get(wArray[i]);
        }
        return true;   
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */