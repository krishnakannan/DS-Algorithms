import java.util.*;
import java.lang.*;
import java.io.*;

class AlienDictionary {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = in.next();
		}
		AlienDictionary ad = new AlienDictionary();
		System.out.println(ad.alienOrder(words));
	}

	class Solution {
    Map<Character, Set<Character>> graph;
	Stack<Character> stack;
	boolean[] visited;
	boolean[] explored;


    public String alienOrder(String[] words) {
        graph = new HashMap<>();
        createGraph(words);
        //System.out.println(graph);
        visited = new boolean[26];
        explored = new boolean[26];
        stack = new Stack<>();
        boolean isCycle = false;
        for (int i = 0; i < 26; i++) {
        	if (graph.containsKey((char)(i + 'a'))) {
        		isCycle |= topSort((char)(i + 'a'));	
        	}
        	if (isCycle) {
        		return "";
        	}
        }
        StringBuilder sBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
        	sBuilder.append(stack.pop());
        }
        return sBuilder.toString();
    }

    public boolean topSort(char current) {
    	if (current == 'X') {
    		return false;
    	}
    	if (visited[current - 'a'] && !explored[current - 'a']) {
    		return true;
    	}

    	if (explored[current - 'a']) {
    		return false;
    	}

    	visited[current - 'a'] = true;
    	boolean isCycle = false;
    	for (Character neighbor : graph.get(current)) {
    		isCycle |= topSort(neighbor);
    		if (isCycle) {
    			return isCycle;
    		}
    	}

    	visited[current - 'a'] = false;
    	explored[current - 'a'] = true;
    	stack.add(current);

    	return isCycle;
    }


    public void createGraph(String[] words) {
    	List<List<Character>> wordsArray = new ArrayList<>();
    	int longest = 0;
    	for (String word : words) {    	    		
    		longest = longest < word.length() ? word.length() : longest;
    	}
    	for (int i = 0; i < longest; i++) {
    		List<Character> verticalTrav = new ArrayList<>();
    		for (int j = 0; j < words.length; j++) {
    			if (i < words[j].length()) {
    				verticalTrav.add(words[j].charAt(i));
    			} else {
    				verticalTrav.add('X');
    			}
    		}
    		wordsArray.add(verticalTrav);
    	}

    	int size = wordsArray.size();
    	List<Character> prevWord = null;    		
    	for (int i = 0; i < size; i++) {
    		List<Character> verticalWord = wordsArray.get(i);    		    		
    		//System.out.println(prevWord + " " + verticalWord);
    		int vSize = verticalWord.size();
    		for (int j = 1; j < vSize; j++) {
    			if (!graph.containsKey(verticalWord.get(j - 1))) {
    				graph.put(verticalWord.get(j - 1), new HashSet<>());
    			}
    			if ((prevWord == null || prevWord.get(j - 1) == prevWord.get(j)) && verticalWord.get(j - 1) != verticalWord.get(j)) {
    				graph.get(verticalWord.get(j - 1)).add(verticalWord.get(j));	
    			}
    			
    		}
    		prevWord = verticalWord;
    		//EmptySet for the leaf
    		if (!graph.containsKey(verticalWord.get(verticalWord.size() - 1))) {
    			graph.put(verticalWord.get(verticalWord.size() - 1), new HashSet<>());
    		}
    	}

    }
}