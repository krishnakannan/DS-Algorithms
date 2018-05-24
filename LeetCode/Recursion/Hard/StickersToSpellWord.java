import java.util.*;
import java.lang.*;
import java.io.*;

class StickersToSpellWord {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] stickers = new String[n];
		for (int i = 0; i < stickers.length; i++) {
			stickers[i] = in.next();
		}
		String target = in.next();
		StickersToSpellWord stsw = new StickersToSpellWord();

		System.out.println(stsw.minStickers(stickers, target));
 	}

 	//Implementation is lengthy and performs exhaustive search. 
 	//No Backtracking, Only Recursion.

 	int minStickers = Integer.MAX_VALUE;
    
    public int minStickers(String[] stickers, String target) {
    	int[][] stickersCountUncompressed = new int[stickers.length][26];
    	int[] stickersTotalCount = new int[26];
    	int[] targetCount = new int[26];    	
    	Arrays.sort(stickers, new Comparator<String>(){
    		public int compare(String a, String b) {
    			return b.length() - a.length();
    		}
    	});
    	for (int i = 0; i < stickers.length; i++) {
    		char[] stickersArray = stickers[i].toCharArray();
    		for (int j = 0; j < stickersArray.length; j++) {
    			stickersCountUncompressed[i][stickersArray[j] - 'a'] += 1;
    			stickersTotalCount[stickersArray[j] - 'a'] += 1;
    		}
    	}


    	for (int i = 0; i < target.length(); i++) {    		
			targetCount[target.charAt(i) - 'a'] += 1;
    	}

    	if (!testPossibility(stickersTotalCount, targetCount)) {
    		return -1;
    	}

    	int[][] stickersCount = compress(stickers, stickersCountUncompressed);

    	search(stickersCount, targetCount, 0, 0);
    	return minStickers;

    }


    public void search(int[][] stickers, int[] target, int currentStickers, int r) {
    	    	
    	if (currentStickers >= minStickers) {
    		return;
    	}

    	if (hasReachedEnd(target)) {
    		minStickers = currentStickers;
    		return;
    	}


    	for (int i = r; i < stickers.length; i++) {
    		if (!overlaps(stickers[i], target)) {
    			continue;
    		}
    		int[] newTarget = minus(target, stickers[i]);
    		search(stickers, newTarget, currentStickers + 1, i);
    	}
    }

    public int[] minus(int[] target, int[] stickers) {    	
    	int[] newTarget = Arrays.copyOf(target, target.length);
    	for (int i = 0; i < 26; i++) {
    		newTarget[i] = newTarget[i] - stickers[i] < 0 ? 0 : newTarget[i] - stickers[i];
    	}
    	return newTarget;
    }

    public boolean hasReachedEnd(int[] array) {
    	for (int i = 0; i < 26; i++) {
    		if (array[i] > 0) {
    			return false;
    		}
    	}
    	return true;
    }

    public boolean testPossibility(int[] stickers, int[] target) {    	
    	for (int i = 0; i < 26; i++) {
    		if (target[i] > 0 && stickers[i] == 0) {
    			return false;
    		}
    	}
    	return true;
    }

    public boolean overlaps(int[] stickers, int[] target) {
    	for (int i = 0; i < 26; i++) {
    		if (target[i] > 0 && stickers[i] > 0) {
    			return true;
    		}
    	}
    	return false;
    }

    public void print(int[] array) {
    	for (int i = 0; i < 26; i++) {
    		if (array[i] > 0) {
    			System.out.print((char)(i + 'a') + " " + array[i] + ", ");
    		}
    		
    	}
    	System.out.println();
    }

    public int[][] compress(String[] stickerStrings, int[][] stickers) {    	
    	boolean[] accounted = new boolean[stickers.length];
        //System.out.println(stickerStrings.length);
    	List<int[]> compressed = new ArrayList<>();
    	for (int i = 0; i < stickers.length; i++) {
    		int[] first = stickers[i];    		    		
    		for (int j = i + 1; j < stickers.length; j++) {    			
    			int[] second = stickers[j];
    			if (isSubseq(first, second)) {        			
    				if (!accounted[j]) {
    					accounted[j] = true;
	    				if (stickerStrings[i].length() < stickerStrings[j].length()) {
	    					first = second;
	    				}
	    			}
    			}
    		}
    		if (!accounted[i]) {
    			compressed.add(first);	
    		}
    		accounted[i] = true;
    		
    	}
    	int[][] compressedArray = new int[compressed.size()][26];
    	int index = 0;
    	for (int[] compressedString : compressed) {
    		compressedArray[index] = Arrays.copyOf(compressedString, compressedString.length);
    		index += 1;
    	}    	
        //System.out.println(compressedArray.length);
    	return compressedArray;
    }

    //Second is a subsequence of first;
    public boolean isSubseq(int[] first, int[] second) {
    	for (int i = 0; i < 26; i++) {
    		if (first[i] < second[i]) {
    			return false;
    		}
    	}
    	return true;
    }
}