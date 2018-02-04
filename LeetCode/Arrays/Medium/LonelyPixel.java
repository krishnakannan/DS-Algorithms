class Solution {
    public int findLonelyPixel(char[][] picture) {
		
    	boolean[] nonLonelyRows = new boolean[picture.length];
    	boolean[] nonLonelyCols = new boolean[picture[0].length];
    	int lonely = 0;
    	for (int i = 0; i < picture.length; i++) {
    		for (int j = 0; j < picture[0].length; j++) {
    			if (picture[i][j] == 'B' && isLonely(picture, i, j, nonLonelyRows, nonLonelyCols)) {
    				lonely++;
    			}
    		}
    	}

    	return lonely;
    }

    public boolean isLonely(char[][] picture, int row, int col, boolean[] nonLonelyRows, boolean[] nonLonelyCols) {

    	if (nonLonelyRows[row] || nonLonelyCols[col]) {
    		return false;
    	}

    	int blackInRow = 0;
    	int blackInCol = 0;

    	//Check Row
    	for (int i = 0; i < picture.length; i++) {
    		if (picture[i][col] == 'B') {
    			blackInRow++;
    		}
    	}

    	//Check Col
    	for (int j = 0; j < picture[0].length; j++) {
    		if (picture[row][j] == 'B') {
    			blackInCol++;
    		}
    	}

    	if (blackInRow > 1) {
    		nonLonelyRows[row] = true;
    	}

    	if (blackInCol > 1) {
    		nonLonelyCols[col] = true;
    	}

    	if (blackInRow > 1 || blackInCol > 1) {
    		return false;
    	}
    	return true;
    }
}