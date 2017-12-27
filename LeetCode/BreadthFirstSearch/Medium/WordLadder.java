import java.util.*;
import java.lang.*;
import java.io.*;

//Graph Solution

class WordLadder {

	public static void main(String args[]) {
		WordLadder wl = new WordLadder();
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
		System.out.println(wl.ladderLength(beginWord, endWord, wordList));
		System.out.println((System.nanoTime() - startTime)/(1000 * 1000) + " Milliseconds");
	}   

	Map<String, Integer> wordDistance = new HashMap<>();
	Map<String, List<String>> graph = new HashMap<>();
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {        
                
        Set<String> visited = new HashSet<>();       
        Set<String> wordSet = new HashSet<>(wordList);       
        Queue<String> neighbors = new LinkedList<>();                
        createGraph(beginWord, endWord, wordList, wordSet);                
        neighbors.add(beginWord);                
        while (!neighbors.isEmpty()) {
        	String currentWord = neighbors.poll();            
        	visited.add(currentWord);            
        	for (String bNeighbors : graph.get(currentWord)) {
        		if (!visited.contains(bNeighbors)) {
        			neighbors.add(bNeighbors);
	        		wordDistance.put(bNeighbors, wordDistance.get(bNeighbors) > wordDistance.get(currentWord) ?
	        			wordDistance.get(currentWord) + 1 : wordDistance.get(bNeighbors));         
        		}
                visited.add(bNeighbors);
                if (bNeighbors == endWord) {
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
