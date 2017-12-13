class Solution {
    public List<String> topKFrequent(String[] words, int k) {
 		
    	//Create a HashMap
    	Map<String, Integer> wordsMap = new HashMap<>();
    	for (String word : words) {
    		wordsMap.put(word, wordsMap.containsKey(word) ? wordsMap.get(word) + 1 : 1);
    	}

    	//Create a MinHeap
    	//Sorting Lexicographically if the values are same
    	Queue<Map.Entry<String, Integer>> wordsHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
    		public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue().equals(e2.getValue())) {
                    return e2.getKey().compareTo(e1.getKey());
                }
    			return e1.getValue() - e2.getValue();
    		}
    	});

    	//Iterate through map and put it in heap.
    	for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
    		wordsHeap.add(entry);
    		checkSize(wordsHeap, k);
    	}
        
    	List<String> wordList = Arrays.asList(new String[k]);        
    	//Get all Elements from Heap which contains top k freq words
    	while (!wordsHeap.isEmpty()) {
    		String poppedWord = wordsHeap.poll().getKey();            
    		wordList.set(--k, poppedWord);
    	}

    	return wordList;

    }

    public void checkSize(Queue<Map.Entry<String, Integer>> wordsHeap, int k) {
    	if (wordsHeap.size() > k) {
    		wordsHeap.poll();
    	}
    }
}