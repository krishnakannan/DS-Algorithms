class Excel {

	class Cell {
		private int x;
		private int y;
		public int value;
		public boolean isFormula;
		public Cell(int x, int y, int value, boolean isFormula) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.isFormula = isFormula;
		}
		public List<Cell> broadcastChangesTo;		
	}

	Cell[][] sheet;

    public Excel(int H, char W) {
    	int rows = H;
		int cols = getCharIndex(W) + 1;       
		sheet = new Cell[rows][cols];
		for (int i = 0; i < sheet.length; i++) {
			for (int j = 0; j < sheet[0].length; j++) {
				sheet[i][j] = new Cell(i, j, 0, false);
				sheet[i][j].broadcastChangesTo = new ArrayList<>();
			}
		}  
    }
    
    public void set(int r, char c, int v) {
    	Cell current = sheet[r - 1][getCharIndex(c)];
        cleanBroadcastList(current); 
        current.isFormula = false;
        broadcastChanges(current, current.value, v);        
    }
    
    public int get(int r, char c) {        
        return sheet[r - 1][getCharIndex(c)].value;
    }
    
    public int sum(int r, char c, String[] strs) {
        Cell current = sheet[r - 1][getCharIndex(c)];
        current.isFormula = true;
        current.value = 0;
        expandSumFormula(current, strs);        
        return current.value;
    }

    public void expandSumFormula(Cell current, String[] strs) {    	
    	for (String str : strs) {
    		if (str.contains(":")) {
    			addCellRange(current, str);
    		} else {
    			addCell(current, str);
    		}            
    	}
    }

    public void addCellRange(Cell current, String str) {        
    	String[] range = str.split(":");
    	int sr = getInt(range[0], 1) - 1;
    	int sc = getCharIndex(range[0].charAt(0));
    	int er = getInt(range[1], 1) - 1;
    	int ec = getCharIndex(range[1].charAt(0));
    	for (int i = sr; i <= er; i++) {
    		for (int j = sc; j <= ec; j++) {
    			current.value += sheet[i][j].value;                
    			sheet[i][j].broadcastChangesTo.add(current);    			
    		}
    	}    	
    }

    public void addCell(Cell current, String str) {
    	int c = getCharIndex(str.charAt(0));
    	int r = getInt(str, 1) - 1;    	
    	current.value += sheet[r][c].value;        
    	sheet[r][c].broadcastChangesTo.add(current);    	
    }

    public int getInt(String str, int start) {
    	int size = str.length();
    	int val = 0;
    	while (start < size) {
    		val *= 10;
    		val += str.charAt(start) - '0';
    		start += 1;
    	}
    	return val;
    } 


    public void broadcastChanges(Cell current, int oldValue, int newValue) {
    	//Use BFS to propagate changes.
    	// There wont be any circular references;
    	Queue<Cell> bfsQ = new LinkedList<>();
    	bfsQ.add(current);
    	while (!bfsQ.isEmpty()) {
    		Cell polled = bfsQ.poll();
    		polled.value = polled.value - oldValue + newValue;
    		bfsQ.addAll(polled.broadcastChangesTo);
    	}
    }

    public void cleanBroadcastList(Cell cell) {
    	for (int i = 0; i < sheet.length; i++) {
    		for (int j = 0; j < sheet[0].length; j++) {
    			while (sheet[i][j].broadcastChangesTo.contains(cell)) {                    
    				sheet[i][j].broadcastChangesTo.remove(cell);                    
    			}
    		}
    	}
    }

    public int getCharIndex(char c) {
    	return (int)(c - 'A');
    }
    
    public void printSheet() {
        for (int i = 0; i < sheet.length; i++) {
            for (int j = 0; j < sheet[0].length; j++) {
                System.out.print((sheet[i][j].isFormula ? "f" : "v") + "" + sheet[i][j].value);
            }
            System.out.println();
        }
        System.out.println();
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */