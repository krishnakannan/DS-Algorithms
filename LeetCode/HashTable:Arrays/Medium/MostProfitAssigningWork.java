import java.util.*;
import java.lang.*;
import java.io.*;

class MostProfitAssigningWork {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int dn = in.nextInt();
		int[] difficulty = new int[dn];
		int[] profit = new int[dn];
		for (int i = 0; i < dn; i++) {
			difficulty[i] = in.nextInt();
			profit[i] = in.nextInt();
		}
		int wn = in.nextInt();
		int[] workers = new int[wn];
		for (int i = 0; i < workers.length; i++) {
			workers[i] = in.nextInt();
		}
		MostProfitAssigningWork mpaw = new MostProfitAssigningWork();
		System.out.println(mpaw.maxProfitAssignment(difficulty, profit, workers));
	}	

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> work = new TreeMap<>();        
        for (int i = 0; i < difficulty.length; i++) {
            if (!work.containsKey(difficulty[i]) || work.get(difficulty[i]) < profit[i]) {
                work.put(difficulty[i], profit[i]);    
            }        	
        }
        int best = 0;        
        for (Map.Entry<Integer, Integer> entry : work.entrySet()) {
        	if (best < entry.getValue()) {
        		best = entry.getValue();
        	}
        	entry.setValue(best);
        }
        int maxProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            Map.Entry<Integer, Integer> entry = work.floorEntry(worker[i]);
            if (entry != null) {
                maxProfit += entry.getValue();    
            }
        }
        return maxProfit;
    }
}