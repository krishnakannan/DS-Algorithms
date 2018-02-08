class Solution {

	int[] blackCols;

    public int findBlackPixel(char[][] picture, int N) {
        Map<String, Integer> blackRows = new HashMap<>();
        blackCols = new int[picture[0].length];
        int count = 0;
        
        for (int i = 0; i < picture.length; i++) {
        	String currentRow = getString(picture, i, N);
        	blackRows.put(currentRow, 
        		blackRows.containsKey(currentRow) ? blackRows.get(currentRow) + 1 : 1);        	
        }

        for (Map.Entry<String, Integer> entry : blackRows.entrySet()) {
        	if (entry.getValue() == N) {
        		for (int j = 0; j < picture[0].length; j++) {
                    if (blackCols[j] == N && !entry.getKey().equals("") && entry.getKey().charAt(j) == 'B') {
                        count += N;
                    }
                }
        	}
        }
        return count;
    }

    public String getString(char[][] picture, int row, int N) {
    	StringBuilder sBuilder = new StringBuilder();
    	int bCount = 0;
    	for (int j = 0; j < picture[0].length; j++) {
    		if (picture[row][j] == 'B') {
    			blackCols[j]++;
    			bCount++;
    		}    		
    		sBuilder.append(picture[row][j]);
    	}

    	return bCount == N ? sBuilder.toString() : "";
    }
}