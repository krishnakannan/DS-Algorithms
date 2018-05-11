import java.util.*;
import java.lang.*;   
import java.io.*;

class ZumaGame {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String board = in.next();
		String hand = in.next();
		ZumaGame zg = new ZumaGame();
		System.out.println(zg.findMinStep(board, hand));
		//System.out.println(zg.reduce("WWBBBWW"));
	}

	//BruteForce With minor optimizations. Passes all TC in OJ.

    public int findMinStep(String board, String hand) {
    	findMin(board, hand, 0);
		return minCost == 6 ? -1 : minCost;

    }

    Integer minCost = 6;

    public void findMin(String board, String hand, int currentCost) {    
    	//System.out.println("Board " + board + " Hand " + hand + " CurrentCost " + currentCost);
    	if (board.isEmpty()) {
    		minCost = minCost > currentCost ? currentCost : minCost;
    		return;
    	}

    	if (!board.isEmpty() && hand.isEmpty()) {
    		return;
    	}

    	if (currentCost >= minCost) {
    		return;
    	}

    	int minimumMost = currentCost;
    	int min = 10;
    	for (int i = 0; i < board.length(); i++) {
    		for (int j = 0; j < hand.length(); j++) {
    			if (board.charAt(i) == hand.charAt(j)) {
    				String[] newBoardAndHand = getNewBoardAndHand(board, hand, i, j);
                    if (currentCost >= minCost) {
                        return;
                    }
	    			findMin(newBoardAndHand[0], newBoardAndHand[1], currentCost + 1);
    			}  
                
    		}
    	}    	
    }

    public String[] getNewBoardAndHand(String board, String hand, int bIndex, int hIndex) {
    	String newBoard = board.substring(0, bIndex) + hand.charAt(hIndex) + board.substring(bIndex);

    	String newHand = hand.substring(0, hIndex) + hand.substring(hIndex + 1);

    	newBoard = reduce(newBoard);

    	return new String[]{newBoard, newHand};
    }

    public String reduce(String boardString) {    	
    	char[] board = boardString.toCharArray();
    	int left = 0;
    	int right = 0;
    	while (right < board.length) {
    		if (board[left] == board[right]) {
    			right += 1;
    		} else {
    			if (right - left >= 3) {
    				while (left < right) {
    					board[left] = '@';
    					left++;
    				}
    			}
    			left = right;
    			right = right + 1;
    		}
    	}
    	if (right - left >= 3) {
    		while (left < right) {
				board[left] = '@';
				left++;
			}
    	}
    	StringBuilder reducedString = new StringBuilder();
    	for (int i = 0; i < board.length; i++) {
    		if (board[i] != '@') {
    			reducedString.append(board[i]);
    		}
    	}

    	if (reducedString.length() == boardString.length()) {
    		return reducedString.toString();
    	} else {
    		return(reduce(reducedString.toString()));
    	}    	
    }
}