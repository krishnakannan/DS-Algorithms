import java.util.*;
import java.lang.*;
import java.io.*;

class WordSearchII {

	public static void main(String args[]) {
		WordSearchII ws = new WordSearchII();
		Scanner in = new Scanner(System.in);
		//System.out.println("Enter row and col");
		int r = in.nextInt();
		int c = in.nextInt();
		char[][] board = new char[r][c];
		//System.out.println("Fill Board");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = in.next().charAt(0);
			}
		}
		//System.out.println("Enter Words count");
		int s = in.nextInt();
		String[] words = new String[s];
		//System.out.println("Enter Words");
		for (int i = 0; i < words.length; i++) {
			words[i] = in.next();
		}		
		List<String> found = ws.findWords(board, words);
		for (String word : found) {
			System.out.print(word + " ");
		}
		System.out.println();
	}


	class TrieNode {
		char ch;
		Map<Character, TrieNode> next;
		boolean isWord;
		public TrieNode(char ch) {
			this.ch = ch;
			this.isWord = false;
			next = new HashMap<>();
		}
		public TrieNode(char ch, boolean isWord) {
			this.ch = ch;
			this.isWord = isWord;
			this.next = new HashMap<>();
		}
	}

	TrieNode head;
	Set<String> found;
	boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {    	
        found = new HashSet<>();
        if (words.length == 0 || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>(found);
        }
        if ((int)board[0][0] == 0) {
            return new ArrayList<>(found);
        }
    	createTrie(words);
    	
    	visited = new boolean[board.length][board[0].length];

    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if (head.next.containsKey(board[i][j])) {
    				search(board, i, j, head.next.get(board[i][j]), new StringBuilder());    				
    			}
    			
    		}
    	}
    	return new ArrayList<>(found);
    }


    public void search(char[][] board, int r, int c, TrieNode trav, StringBuilder formed) {  
    	if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
    		return;
    	}
    	visited[r][c] = true;
    	formed.append(board[r][c]);

    	if (trav.isWord) {
    		found.add(formed.toString());
    	}

    	List<int[]> neighbors = getNeighbors(board, r, c);
    	for (int[] neighbor : neighbors) {    		
    		int nr = neighbor[0];
    		int nc = neighbor[1];
    		if (trav.next.containsKey(board[nr][nc])) {
    			search(board, nr, nc, trav.next.get(board[nr][nc]), formed);	
    		}     		
    	}
    	formed.setLength(formed.length() - 1);
    	visited[r][c] = false;
    }

    public List<int[]> getNeighbors(char[][] board, int r, int c) {
    	List<int[]> neighbors = new ArrayList<>();
    	
    	if (r > 0 && !visited[r - 1][c]) {
    		neighbors.add(new int[]{r - 1, c});
    	} 

    	if (c > 0 && !visited[r][c - 1]) {
    		neighbors.add(new int[]{r, c - 1});    	
    	}

    	if (c < board[0].length - 1 && !visited[r][c + 1]) {
    		neighbors.add(new int[]{r, c + 1});    		
    	}

    	if (r < board.length - 1 && !visited[r + 1][c]) {
    		neighbors.add(new int[]{r + 1, c});    		
    	}
    	return neighbors;
    }
    
    public void createTrie(String[] words) {
    	//Dummy Head
        head = new TrieNode('*');
        for (String word : words) {
        	TrieNode trav = head;
        	int length = word.length();
        	for (int i = 0; i < length; i++) {
        		if (!trav.next.containsKey(word.charAt(i))) {
        			trav.next.put(word.charAt(i), new TrieNode(word.charAt(i)));        			
        		}
        		trav = trav.next.get(word.charAt(i));
        	}
        	trav.isWord = true; 
        }
    }
}