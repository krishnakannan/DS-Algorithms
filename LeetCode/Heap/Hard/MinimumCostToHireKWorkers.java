import java.util.*;
import java.lang.*;   
import java.io.*;

class MinimumCostToHireKWorkers {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] wage = new int[n];
		int[] quality = new int[n];
		for (int i = 0; i < n; i++) {
			quality[i] = in.nextInt();
			wage[i] = in.nextInt();			
		}
		int k = in.nextInt();
		MinimumCostToHireKWorkers mcthkw = new MinimumCostToHireKWorkers();
		System.out.println(mcthkw.mincostToHireWorkers(quality, wage, k));
	}

	class Worker {
		double quality;
		double minimumWage;
		double efficiency;
		public Worker(int quality, int minimumWage) {
			this.quality = (double)quality;
			this.minimumWage = (double)minimumWage;
			this.efficiency = this.minimumWage / this.quality;
		}
	}

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[quality.length];        
        for (int i = 0; i < workers.length; i++) {
        	workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, new Comparator<Worker>(){
        	public int compare(Worker a, Worker b) {
                double diff = a.efficiency - b.efficiency;
                if (diff == 0d) {
                    return 0;
                } else if (diff > 0d) {
                    return 1;
                } else {
                    return -1;
                }        		
        	}
        });
        
        Queue<Worker> pQueue = new PriorityQueue<>(new Comparator<Worker>(){
        	public int compare(Worker a, Worker b) {
        		return (int)(b.quality - a.quality);
        	}
        });

        double minCost = Double.MAX_VALUE;
        double qualitySum = 0d; 

        for (Worker worker : workers) {
        	qualitySum += worker.quality;
        	pQueue.add(worker);

        	if (pQueue.size() > K) {
        		qualitySum -= pQueue.poll().quality;        		
        	}

        	if (pQueue.size() == K) {
        		minCost = Math.min(minCost, qualitySum * worker.efficiency);
        	} 
        }

        return minCost;
    }
}