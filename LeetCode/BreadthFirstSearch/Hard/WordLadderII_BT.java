import java.util.*;
import java.lang.*;
import java.io.*;

class WordLadderII {

	public static void main(String args[]) {
		WordLadderII wl = new WordLadderII();
		Scanner in = new Scanner(System.in);
		String dictWord = "";
		int lineNumber = 1;		
		String beginWord = "";
		String endWord = "";
		List<String> wordList = new ArrayList<>();        
		try {
			InputStream is = new FileInputStream("cet.txt");
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));		        
			String line = buf.readLine();			
			while(line != null){
			   if (lineNumber == 1) {
					beginWord = line;

			   } else if (lineNumber == 2) {
					endWord = line;
			   } else {
					String[] words = line.split(" ");
					int i = 0;
					do {
						dictWord = words[i];
						wordList.add(dictWord);
						i++;
					} while(!dictWord.equals("0") && i < words.length);
			   }
			   lineNumber++;
			   line = buf.readLine();
			}
		} catch(IOException e) {

		}				
		wordList.remove("0");
		long startTime = System.nanoTime();						
		wl.findLadders(beginWord, endWord, wordList);
		for (List<String> list : wl.formedWords) {
			System.out.println(list);
		}
		System.out.println();
		System.out.println((System.nanoTime() - startTime)/(1000 * 1000) + " Milliseconds");
	}   
	
	Map<String, List<String>> graph = new HashMap<>();
	Set<String> visited = new HashSet<>();       
	Set<String> wordSet;
	List<List<String>> formedWords;
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		wordSet = new HashSet<>(wordList); 		
		createGraph(beginWord, endWord, wordList, wordSet);                        
		wordSet.add(beginWord);
		formedWords = new ArrayList<>();         
		ladderLength(beginWord, endWord, new ArrayList<>(), new HashSet<>());
		//System.out.println(formedWords);
		return formedWords;
	}
	
	public void ladderLength(String beginWord, String endWord, 
			List<String> current, Set<String> visited) {        
			
		// End Condition    
		if (beginWord.equals(endWord)) {
			current.add(beginWord);
			
			if (formedWords.isEmpty()) {
				formedWords.add(new ArrayList<>(current));    
			} else {                
				int size = formedWords.get(0).size();                
				if (current.size() < size) {
					formedWords.clear();
					formedWords.add(new ArrayList<>(current));
				} else if (current.size() == size) {
					formedWords.add(new ArrayList<>(current));
				}
			}      			
			current.remove(current.size() - 1);
			return;
		}
		
		Queue<String> neighborQueue = new LinkedList<>();                
		if (wordSet.contains(beginWord)) {
			neighborQueue.add(beginWord);                    
		} 

		while (!neighborQueue.isEmpty()) {
		
			String currentWord = neighborQueue.poll();
			current.add(currentWord);
			wordSet.remove(currentWord);

			for (String neighbor : graph.get(currentWord)) {
				if (!formedWords.isEmpty() && formedWords.get(0).size() <= current.size()) {                    
					break;
				} else {                    
					ladderLength(neighbor, endWord, current, visited);                        
				}                 
			}

			wordSet.add(currentWord);
			current.remove(currentWord);
		}           
	}

	/*
		Creating an Adjacency List - N Square if the wordList's length is N
	*/
	public void createGraph(String beginWord, String endWord, List<String> wordList, Set<String> wordSet) {    	
		//Calculate Begin's neighbors
		graph.put(beginWord, getNeighbors(beginWord, wordSet));
		//Form rest of the graph
		int size = wordSet.size();
		for (int i = 0; i < size; i++) {         
			graph.put(wordList.get(i), getNeighbors(wordList.get(i), wordSet));            
		}    
	}


	public List<String> getNeighbors(String currentWord, Set<String> wordSet) {
		char[] currentWordArray = currentWord.toCharArray();
		List<String> neighbors = new ArrayList<>();
		for (int i = 0; i < currentWordArray.length; i++) {
			for (char x = 'a'; x <= 'z'; x++) {
				char temp = currentWordArray[i];
				currentWordArray[i] = x;
				String newString = new String(currentWordArray);
				// System.out.println(newString);
				if (!currentWord.equals(newString)) {
					if (wordSet.contains(newString)) {
						neighbors.add(newString);
					}
				}
				currentWordArray[i] = temp;
			}
		}    	
		return neighbors;
	}    
}
