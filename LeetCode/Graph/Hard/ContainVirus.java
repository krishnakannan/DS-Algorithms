import java.util.*;
import java.lang.*;   
import java.io.*;

class ContainVirus {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();	
		int[][] grid = new int[m][n];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		ContainVirus cv = new ContainVirus();
	}

	int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

	class AffectedRegion {
		List<int[]> affectedRegion;
		List<int[]> riskAffecting;
		public AffectedRegion(List<int[]> affectedRegion, List<int[]> riskAffecting) {
			this.affectedRegion = affectedRegion;
			this.riskAffecting = riskAffecting;
		}
	}

	class Wall {
		boolean left;
		boolean right;
		boolean bottom;
		boolean top;
	}

	boolean[][] inspected;
    boolean[][] added;
	Wall[][] borderWall;	

    public int containVirus(int[][] grid) {
        inspected = new boolean[grid.length][grid[0].length];
        added = new boolean[grid.length][grid[0].length];
        borderWall = new Wall[grid.length][grid[0].length];
        for (int i = 0; i < borderWall.length; i++) {
        	for (int j = 0; j < borderWall[0].length; j++) {
        		borderWall[i][j] = new Wall();
        	}
        }
        List<AffectedRegion> affectedRegions = getListOfAffectedRegions(grid);
        int wallsBuilt = 0;

        PriorityQueue<AffectedRegion> pQueue = new PriorityQueue<AffectedRegion>(new Comparator<AffectedRegion>(){
        	public int compare(AffectedRegion a, AffectedRegion b) {
        		return b.riskAffecting.size() - a.riskAffecting.size();
        	}
        });

        pQueue.addAll(affectedRegions);

        while (!pQueue.isEmpty()) {
        	AffectedRegion regionToBeWalled = pQueue.poll();
        	wallsBuilt += buildWall(grid, regionToBeWalled);                        
        	affectedRegions.clear();
        	while (!pQueue.isEmpty()) {
        		AffectedRegion unWalled = pQueue.poll();
        		spread(grid, unWalled);        		
        	}
            for (int i = 0; i < grid.length; i++) {
                Arrays.fill(inspected[i], false);                
            }                    
            affectedRegions = getListOfAffectedRegions(grid);
            //print(grid);
            pQueue.addAll(affectedRegions);
        	
        }            
        //print(grid);
        return wallsBuilt;

    }

    public int buildWall(int[][] grid, AffectedRegion affectedRegion) {
    	
    	int wallsBuilt = 0;

    	for (int[] affectedLocation : affectedRegion.affectedRegion) {
    		int x = affectedLocation[0];
    		int y = affectedLocation[1];
            grid[x][y] = 2;
    		//Left
    		if (y > 0 && grid[x][y - 1] == 0) {
    			if (!borderWall[x][y - 1].right) {
    				borderWall[x][y - 1].right = true;
                    //System.out.println("Walled Off " + (x) + ", " + (y - 1) + " Right ");
    				wallsBuilt += 1;	
    			}    			
    		}

    		//Right
    		if (y < grid[0].length - 1 && grid[x][y + 1] == 0) {
    			if (!borderWall[x][y + 1].left) {
    				borderWall[x][y + 1].left = true;	
                    //System.out.println("Walled Off " + (x) + ", " + (y + 1) + " Left ");
    				wallsBuilt += 1;	
    			}    			
    		}

    		//Top
    		if (x > 0 && grid[x - 1][y] == 0) {
    			if (!borderWall[x - 1][y].bottom) {
    				borderWall[x - 1][y].bottom = true;
                    //System.out.println("Walled Off " + (x - 1) + ", " + (y) + " Bottom ");
    				wallsBuilt += 1;	
    			}    			
    		}

    		//Bottom
    		if (x < grid.length - 1 && grid[x + 1][y] == 0) {
    			if (!borderWall[x + 1][y].top) {
    				borderWall[x + 1][y].top = true;
                    //System.out.println("Walled Off " + (x + 1) + ", " + (y) + " Top ");
    				wallsBuilt += 1;
    			}    			
    		}
    	}            
    	return wallsBuilt;
    }

    public List<AffectedRegion> getListOfAffectedRegions(int[][] grid) {
    	List<AffectedRegion> affectedRegions = new ArrayList<>();
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == 1 && !inspected[i][j]) {
    				List<int[]> affectedRegion = new ArrayList<>();
    				List<int[]> riskAffecting = new ArrayList<>();                    
                    for (int x = 0; x < grid.length; x++) {                        
                        Arrays.fill(added[x], false);
                    }
    				scanRegion(grid, i, j, affectedRegion, riskAffecting);
    				affectedRegions.add(new AffectedRegion(affectedRegion, riskAffecting));                    
    			}
    		}
    	}
    	return affectedRegions;
    }

    public void scanRegion(int[][] grid, int x, int y, List<int[]> affectedRegion, List<int[]> riskAffecting) {

    	if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
    		return;
    	}

    	if (inspected[x][y]) {
    		return;
    	}
        if (grid[x][y] > 1) {
            return;
        }
        
    	if (grid[x][y] == 0) {
            if (!added[x][y]) {
                added[x][y] = true;
    		    riskAffecting.add(new int[]{x, y});    
            }            
    		return;
    	}

        inspected[x][y] = true;
    	affectedRegion.add(new int[]{x, y});
    	for (int[] direction : directions) {    		
    		scanRegion(grid, x + direction[0], y + direction[1], affectedRegion, riskAffecting);
    	}
    }

    public void spread(int[][] grid, AffectedRegion affectedRegion) {
    	List<int[]> nextLevel = new ArrayList<>();        
    	for (int[] riskAffecting : affectedRegion.riskAffecting) {
            
    		int x = riskAffecting[0];
    		int y = riskAffecting[1];
    		affectedRegion.affectedRegion.add(new int[]{x, y});
            
    		//Left
    		if (y > 0 && grid[x][y - 1] == 0) {
    			nextLevel.add(new int[]{x, y - 1});
    		}

    		//Right
    		if (y < grid[0].length - 1 && grid[x][y + 1] == 0) {
    			nextLevel.add(new int[]{x, y + 1});
    		}

    		//Top
    		if (x > 0 && grid[x - 1][y] == 0) {
    			nextLevel.add(new int[]{x - 1, y});
    		}

    		//Bottom
    		if (x < grid.length - 1 && grid[x + 1][y] == 0) {                
    			nextLevel.add(new int[]{x + 1, y});
    		}
            grid[x][y] = 1;
    	}        
        
    	affectedRegion.riskAffecting.clear();
    	affectedRegion.riskAffecting.addAll(nextLevel);
    }
    
    public void print(int[][] grid) {
        for (int i = 0; i < borderWall.length; i++) {
        	for (int j = 0; j < borderWall[0].length; j++) {
                System.out.print(grid[i][j] + " ");
        		if (borderWall[i][j].left) {
                    System.out.print("l");
                }
                if (borderWall[i][j].right) {
                    System.out.print("r");
                }
                if (borderWall[i][j].top) {
                    System.out.print("t");
                }
                if (borderWall[i][j].bottom) {
                    System.out.print("b");
                }
                System.out.print("\t");
        	}
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}