import java.util.*;
import java.lang.*;   
import java.io.*;

class CitySkyline {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		CitySkyline csl = new CitySkyline();
		int buildingsCount = in.nextInt();
		int[][] buildings = new int[buildingsCount][3];
		for (int i = 0; i < buildings.length; i++) {
			buildings[i][0] = in.nextInt();
			buildings[i][1] = in.nextInt();
			buildings[i][2] = in.nextInt();
		}

		List<int[]> keyPoints = csl.getSkyline(buildings);
		for (int[] keyPoint : keyPoints) {
			System.out.print(keyPoint[0] + "," + keyPoint[1] + "  ");
		}
		System.out.println();
	}

	class Skyline {
		int x;
		int h;
		boolean isStart;
		public Skyline(int x, int h, boolean isStart) {
			this.x = x;
			this.h = h;
			this.isStart = isStart;
		}
	}

    public List<int[]> getSkyline(int[][] buildings) {
 		
    	List<int[]> keyPoints = new ArrayList<>();
    	Skyline[] skyline = new Skyline[buildings.length * 2];

    	for (int i = 0, j = 0; i < buildings.length; i++, j += 2) {
    		skyline[j] = new Skyline(buildings[i][0], buildings[i][2], true);
    		skyline[j + 1] = new Skyline(buildings[i][1], buildings[i][2], false);
    	}
    	print(skyline);
 		PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>(){
 			public int compare(Integer a, Integer b) {
 				return b - a;
 			}
 		});  
 		pQueue.add(0);
 		int maxHeight = 0;
 		
 		Arrays.sort(skyline, new Comparator<Skyline>(){
 			public int compare(Skyline a, Skyline b) {
 				if (a.x == b.x && a.isStart && b.isStart) {
					return b.h - a.h; 				
 				}
 				if (a.x == b.x && !a.isStart && !b.isStart) {
 					return a.h - b.h;
 				}
 				if (a.x == b.x && a.isStart && !b.isStart) {
 					return -1;
 				}
 				return a.x - b.x;
 			}
 		});
 		print(skyline);
 		List<int[]> silhouette = new ArrayList<>();

 		for (int i = 0; i < skyline.length; i++) {
 			if (skyline[i].isStart) {
 				pQueue.add(skyline[i].h);	
 			} else {
 				pQueue.remove(skyline[i].h);
 			} 		

 			System.out.println("Current " + skyline[i].x + " " + skyline[i].h + " PQUEUE " + pQueue.peek() + " MAXHEIGHT " + maxHeight); 

 			if (maxHeight != pQueue.peek()) {
 				if (skyline[i].isStart) {
					silhouette.add(new int[]{skyline[i].x, skyline[i].h});	
 				} else {
 					silhouette.add(new int[]{skyline[i].x, pQueue.peek()});	
 				} 				
 			} 
 			maxHeight = pQueue.peek();
 		}
 		return silhouette;
    }

    public void print(Skyline[] sk) {
    	for (Skyline skElement : sk) {
    		System.out.print("[" + skElement.x + "," + skElement.h + "," + (skElement.isStart ? " Start] " : " End] "));
    	}
    	System.out.println();
    }
}