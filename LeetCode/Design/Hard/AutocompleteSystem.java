class AutocompleteSystem {

	String[] sentences;
	int[] times;
	TrieNode root;
	TrieNode traverser;
    StringBuilder mySentence;    
    int cNum = 0;

	class HotSentence {
		String sentence;
		int count;
		public HotSentence(String sentence, int count) {
			this.sentence = sentence;
			this.count = count;
		}
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            return this.sentence.equals(((HotSentence)o).sentence);
        }
        
        // @Override
        // public int hashCode() {
        //     int hash = 7;
        //     hash = 17 * hash + this.count * this.sentence.hashCode();
        //     return hash;
        // }
        
	}

	class TrieNode {
		char c;
		Map<Character, TrieNode> next;
		PriorityQueue<HotSentence> pQueue;
		boolean isEnd;
		public TrieNode(char c) {
			this.c = c;
			this.next = new HashMap<>();
			this.pQueue = new PriorityQueue<HotSentence>(new Comparator<HotSentence>(){
				public int compare(HotSentence a, HotSentence b) {
					if (a.count == b.count) {
						return a.sentence.compareTo(b.sentence);
					}
					return b.count - a.count;
				}
			});
		}
	}

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.sentences = sentences;
        this.times = times;
        this.root = new TrieNode('*');
        buildTrie();
        traverser = root;
        mySentence = new StringBuilder();
    }
    
    public List<String> input(char c) {
        
        if (c == '#') {
            traverser = root;
            modifyTrie(new HotSentence(mySentence.toString(), 1));
            mySentence.setLength(0);
            return new ArrayList<>();
        }
        mySentence.append(c);
        if (traverser == null) {
        	return new ArrayList<>();
        }

        if (traverser.next.containsKey(c)) {

        	traverser = traverser.next.get(c);        	
        	int len = traverser.pQueue.size() < 3 ? traverser.pQueue.size() : 2;
            List<String> hotSentences = new ArrayList<>();
        	List<HotSentence> tempList = new ArrayList<>();            
            int count = 0;
            while (!traverser.pQueue.isEmpty() && count < 3) {
                count += 1;
                HotSentence polled = traverser.pQueue.poll();
        		tempList.add(polled);
        		hotSentences.add(polled.sentence);
            }
        	traverser.pQueue.addAll(tempList);
            //Collections.reverse(hotSentences);
        	return hotSentences;
        } else {
        	traverser = null;
        	return new ArrayList<>();
        }

    }

    public void buildTrie() {
    	for (int i = 0; i < sentences.length; i++) {
    		insertIntoTrie(sentences[i], times[i]);
    	}
    }

    public void insertIntoTrie(String s, int count) {
    	char[] str = s.toCharArray();
    	TrieNode trav = root;
    	for (int i = 0; i < str.length; i++) {
    		if (!trav.next.containsKey(str[i])) {
    			trav.next.put(str[i], new TrieNode(str[i]));
    		}
    		trav = trav.next.get(str[i]);
    		trav.pQueue.add(new HotSentence(s, count));    		
    	}
    }
    
    public void modifyTrie(HotSentence s) {
    	char[] str = s.sentence.toCharArray();
    	TrieNode trav = root;
    	for (int i = 0; i < str.length; i++) {
    		if (!trav.next.containsKey(str[i])) {
    			trav.next.put(str[i], new TrieNode(str[i]));
    		}            
    		trav = trav.next.get(str[i]);    		
            if (trav.pQueue.contains(s)) {                
                modifyPQ(s, trav.pQueue);                
            } else {
                trav.pQueue.add(new HotSentence(s.sentence, s.count));                  
            }            
    	}
    }
    
    public void modifyPQ(HotSentence hSentence, PriorityQueue<HotSentence> pq) {
        List<HotSentence> tempList = new ArrayList<>();
        while (!pq.isEmpty()) {
            HotSentence polled = pq.poll();
            if (polled.equals(hSentence)) {                
                polled.count += 1;                
                tempList.add(polled);
                break;
            }
            tempList.add(polled);
        }
        pq.addAll(tempList);
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */