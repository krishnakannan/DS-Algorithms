import java.util.*;
import java.lang.*;
import java.io.*;

class WordLadderIII {

	public static void main(String args[]) {
		WordLadderIII wl = new WordLadderIII();
		Scanner in = new Scanner(System.in);
		String dictWord = "";
		int lineNumber = 1;     
		String beginWord = "";
		String endWord = "";
		List<String> wordList = new ArrayList<>();        
		try {
			InputStream is = new FileInputStream("nanny.txt");
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
		List<List<String>> formedPaths = wl.findLadders(beginWord, endWord, wordList);
		for (List<String> list : formedPaths) {
		    System.out.println(list);
		}
		System.out.println();
		System.out.println((System.nanoTime() - startTime)/(1000 * 1000) + " Milliseconds");
	}   

	
	Map<String, List<String>> graph = new HashMap<>();
	Map<String, Integer> wordDistance = new HashMap<>();
	Set<String> visited = new HashSet<>();       	
	List<List<String>> wordPaths;




	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {        		
		Set<String> wordSet = new HashSet<>(wordList);
		createGraph(beginWord, endWord, wordList, wordSet);                
		int shortestPath = shortestPath(beginWord, endWord, wordSet);		
		wordPaths = new ArrayList<>();
		tracePath(beginWord, endWord, wordSet, new ArrayList<>());
		return wordPaths;
	}

	//Depth First Search to trace the possible paths and Backtrack
	/*
		 Major optimization is a "Neighbor" is a Neighbor only if it separated by 1 edge.
		 This reduces the search paths drastically.
	*/
	
	public void tracePath(String beginWord, String endWord, Set<String> wordSet, List<String> formedWords) {
	    formedWords.add(beginWord);

	    if (endWord.equals(beginWord)) {
	       wordPaths.add(new ArrayList<>(formedWords));
	    } else {
	       for (String neighbor : graph.get(beginWord)) {            
	            if (wordDistance.get(neighbor) == wordDistance.get(beginWord) + 1) {
	                 tracePath(neighbor, endWord, wordSet, formedWords);
	            }
	        }
	    }         

	   formedWords.remove(formedWords.size() - 1);
	}


	//Breadth First Search for finding the shortest path
	public int shortestPath(String beginWord, String endWord, Set<String> wordSet) {        
                
        Set<String> visited = new HashSet<>();               
        Queue<String> bfsQ = new LinkedList<>();                        
        bfsQ.add(beginWord);                        
    	wordDistance.put(beginWord, 1);        
        while (!bfsQ.isEmpty()) {
        	String currentWord = bfsQ.poll();            
        	visited.add(currentWord);            
        	for (String neighbor : graph.get(currentWord)) {
        		if (!visited.contains(neighbor)) {
        			bfsQ.add(neighbor);
	        		wordDistance.put(neighbor, wordDistance.get(neighbor) > wordDistance.get(currentWord) ?
	        			wordDistance.get(currentWord) + 1 : wordDistance.get(neighbor));         
        		}
                visited.add(neighbor);
                if (neighbor == endWord) {
	                return wordDistance.get(endWord);
	            }
        	}
        	if (currentWord == endWord) {
                break;
            }
        }
        return wordDistance.get(endWord) == Integer.MAX_VALUE ? 0 : wordDistance.get(endWord);
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
            wordDistance.put(wordList.get(i), Integer.MAX_VALUE);
			graph.put(wordList.get(i), getNeighbors(wordList.get(i), wordSet));            
        }
        wordDistance.put(endWord, Integer.MAX_VALUE);
    	wordDistance.put(beginWord, 1);
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
