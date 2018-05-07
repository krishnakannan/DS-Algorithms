import java.util.*;
import java.lang.*;   
import java.io.*;

class WordAbbreviations {

	public static void main(String args[]) {
		WordAbbreviations wa = new WordAbbreviations();
		Scanner in = new Scanner(System.in);
		String input = in.next();
		List<String> dict = new ArrayList<>();
		while (!input.equals("done")) {
			dict.add(input);
			input = in.next();
		}
		System.out.println(wa.wordsAbbreviation(dict));
	}

    public List<String> wordsAbbreviation(List<String> dict) {
    	String[] output = new String[dict.size()];        
        populate(dict);
        //System.out.println(abbreviationsMap);       
        boolean[] added = new boolean[dict.size()];
        int index = 0;
        for (String wordString : dict) {        	            
        	char[] word = wordString.toCharArray();
        	int len = word.length - 2;        	
        	StringBuilder formed = new StringBuilder();
        	formed.append(word[0]);
        	TrieNode trav = root.next[word[0] - 'a'];   	
        	String ending = len + "" + word[word.length - 1];
            if (!added[index]) {
                for (int i = 1; i < word.length - 2; i++) {                    
                    if (trav.moreThanOnce.contains(ending)) {
                        formed.append(word[i]);
                        trav = trav.next[word[i] - 'a'];
                        len -= 1;
                        ending = len + "" + word[word.length - 1];
                    } else {
                        output[index] = formed.toString() + ending;
                        added[index] = true;
                        break;
                    }   
                }
            }        	
        	if (!added[index]) {                
        		output[index] = wordString;
        	}  
            index += 1;
        }


        return Arrays.asList(output);
    }

    class TrieNode {
    	char c;
    	TrieNode[] next;    	
        List<String> atleastOnce;
    	List<String> moreThanOnce;        
    	boolean isEnd;
    	public TrieNode(char c) {
    		this.c = c;
    		isEnd = false;
    		next = new TrieNode[26];
    		moreThanOnce = new LinkedList<>();
            atleastOnce = new LinkedList<>();
    	}
    }

    TrieNode root = new TrieNode('*');

    public void populate(List<String> dict) {
        int index = 0;
    	for (String wordString : dict) {
    		TrieNode trav = root;
    		char[] word = wordString.toCharArray();
    		int len = word.length - 2;
    		String ending = len + "" + word[word.length - 1];    		
    		for (int i = 0; i < word.length; i++) {    			
    			if (trav.next[word[i] - 'a'] == null) {
                    trav.next[word[i] - 'a'] = new TrieNode(word[i]);    				
    			}    			
    			trav = trav.next[word[i] - 'a'];
                
                if (trav.moreThanOnce.contains(ending)) {
                    //Do Nothing;
                } else if (trav.atleastOnce.contains(ending)) {
                    trav.moreThanOnce.add(ending);                                        
                    trav.atleastOnce.remove(ending);
                } else {                                        
                    trav.atleastOnce.add(ending);
                }
    			
    			len -= 1;
    			ending = len + "" + word[word.length - 1];    			
    		}
    		trav.isEnd = true;
            index += 1;
    	}
    }
}