class MapSum {

	class TrieNode {
		char key;
		int val;
		Map<Character, TrieNode> next;

		public TrieNode(char key, int val) {
			this.key = key;
			this.val = val;
			next = new HashMap<>();
		}
	}

	TrieNode head;
	Map<String, Integer> keyVal;

    /** Initialize your data structure here. */
    public MapSum() {
    	//Dummy Head
        head = new TrieNode('*', 0);
        keyVal = new HashMap<>();
    }
    
    public void insert(String key, int val) {
    	if (keyVal.containsKey(key)) {
    		val = getNewVal(key, val);
    	} else {
            keyVal.put(key, val);
        }
        
        int keyLength = key.length();
        TrieNode trav = head;
        for (int i = 0; i < keyLength; i++) {
        	if (!trav.next.containsKey(key.charAt(i))) {
        		trav.next.put(key.charAt(i), new TrieNode(key.charAt(i), val));
        	} else {
        		TrieNode nextNode = trav.next.get(key.charAt(i));
        		nextNode.val += val;
        	}            
        	trav = trav.next.get(key.charAt(i));            
        }
    }
    
    public int sum(String prefix) {
        int value = 0;
        int pLength = prefix.length();
        TrieNode trav = head;
        for (int i = 0; i < pLength; i++) {                        
        	if (trav.next.containsKey(prefix.charAt(i))) {
        		value = trav.next.get(prefix.charAt(i)).val;
                trav = trav.next.get(prefix.charAt(i));
        	} else {
        		value = 0;
        		break;
        	}
            
        }
        return value;
    }

    public int getNewVal(String key, int cVal) {
    	int oVal = keyVal.get(key);
    	keyVal.put(key, cVal);
    	return cVal - oVal;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */