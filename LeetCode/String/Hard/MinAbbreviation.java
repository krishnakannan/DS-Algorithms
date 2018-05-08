import java.util.*;
import java.lang.*;   
import java.io.*;

class MinAbbreviation {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String target = in.next();
		int n = in.nextInt();
		String[] dict = new String[n];
		for (int i = 0; i < dict.length; i++) {
			dict[i] = in.next();
		}
		MinAbbreviation ma = new MinAbbreviation();
		System.out.println(ma.minAbbreviation(target, dict));
	}

	List<String> abbrs = new ArrayList<>();

    public String minAbbreviation(String target, String[] dictionary) {
        boolean isTargetLengthPresent = buildTrie(dictionary, target.length());
        if (!isTargetLengthPresent) {
        	return "" + target.length();
        }
	    
        for (int i = 1; i <= target.length(); i++) {
        	abbrs.clear();
        	generate(target, 0, "", 0, i);
        	for (String abbr : abbrs) {
        		char[] searchWord = generateSearchWord(abbr).toCharArray();
        		boolean isPresent = searchTrie(searchWord, 0, root);
        		if (!isPresent) {
        			return abbr;
        		}	
        	}        	
        }
        return null;
    }


	public void generate(String target, int i, String tmp, int abbr, int length) {
        if(i == target.length()) {
            if (length == 0 && abbr == 0) {
            	abbrs.add(tmp);
            }
            if (length == 1 && abbr != 0) abbrs.add(tmp + abbr);
            return;
        }
        if (length <= 0) return;
        char cur = target.charAt(i);
        generate(target, i + 1, abbr == 0 ? tmp + cur : tmp + abbr + cur, 0, abbr == 0 ? length - 1 : length - 2);
        generate(target, i + 1, tmp, abbr + 1, length);
    }

    public boolean buildTrie(String[] dictionary, int targetWordLength) {
    	boolean isTargetLengthPresent = false;
    	for (String word : dictionary) {
    		addWordToTrie(word);
    		if (word.length() == targetWordLength) {
    			isTargetLengthPresent = true;
    		}
    	}
    	return isTargetLengthPresent;
    }

    class TrieNode {
    	char c;
    	TrieNode[] next;
    	boolean isEnd = false;
    	public TrieNode(char c) {
    		this.c = c;
    		this.next = new TrieNode[26];
    	}
    }

    TrieNode root = new TrieNode('*');    

    public void addWordToTrie(String wordString) {
    	char[] word = wordString.toCharArray();
    	int index = 0;    	
    	TrieNode trav = root;    	
    	while (index < word.length) {
    		if (trav.next[word[index] - 'a'] == null) {
    			trav.next[word[index] - 'a'] = new TrieNode(word[index]);    			
    		}    		
    		trav = trav.next[word[index] - 'a'];
    		index += 1;
    	}
    	trav.isEnd = true;
    }

    public boolean searchTrie(char[] word, int index, TrieNode trav) {    	

    	if (trav == null) {
    		return false;
    	}

    	if (index == word.length) {
    		if (!trav.isEnd) {
    			return false;
    		} else {
    			return true;
    		}
    	}    	

    	boolean wordPresent = false;

    	if (word[index] == '$') {    		
    		for (int i = 0; i < 26; i++) {
    			if (trav.next[i] != null) {
    				word[index] = (char)(i + 'a');
    				wordPresent |= searchTrie(word, index + 1, trav.next[i]);	
    				word[index] = '$';
    				if (wordPresent) {
    					break;
    				}
    			}    			
    		}
    	} else {    		
    		if (trav.next[word[index] - 'a'] == null) {
    			return false;
    		} else {
    			wordPresent |= searchTrie(word, index + 1, trav.next[word[index] - 'a']);
    			if (wordPresent) {
					return wordPresent;
				}
    		}
    	}
    	return wordPresent;
    }

    public String generateSearchWord(String word) {
    	int len = word.length();
    	StringBuilder searchWord = new StringBuilder();
    	for (int i = 0; i < len; i++) {
    		if (i < len - 1) {
    			if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
    				if (word.charAt(i + 1) >= '0' && word.charAt(i + 1) <= '9') {
    					int num = getInt(word, i, ++i);
    					for (int x = 0; x < num; x++) {
	    					searchWord.append("$");
	    				}
    				} else {
						int num = getInt(word, i, i);
    					for (int x = 0; x < num; x++) {
	    					searchWord.append("$");
	    				}
    				}
    			} else {
    				searchWord.append(word.charAt(i));
    			}
    		} else {
    			if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
    				int num = getInt(word, i, i);    				
    				for (int x = 0; x < num; x++) {
    					searchWord.append("$");
    				}
    			} else {
    				searchWord.append(word.charAt(i));
    			}
			}	
    	}    	
    	return searchWord.toString();
    }

    public int getInt(String word, int startIndex, int endIndex) {
    	int val = 0;    	
    	for (int i = startIndex; i <= endIndex; i++) {
    		val *= 10;
    		val += (word.charAt(i) - '0');
    	}    	
    	return val;
    }
}