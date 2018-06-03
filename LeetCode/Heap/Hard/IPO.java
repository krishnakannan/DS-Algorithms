import java.util.*;
import java.lang.*;
import java.io.*;

class IPO {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int w = in.nextInt();
		int n = in.nextInt();
		int[] profits = new int[n];
		int[] capital = new int[n];
		for (int i = 0; i < profits.length; i++) {
			profits[i] = in.nextInt();
			capital[i] = in.nextInt();
		}
		IPO ipo = new IPO();
		System.out.println(ipo.findMaximizedCapital(k, w, profits, capital));
	}

        
    class Project {
        int capital;
        int profit;
        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
    
    public int findMaximizedCapital(int projectsToDo, int initialCapital, int[] profits, int[] capital) {
    	int total = profits.length;
        if (projectsToDo == 0 || profits.length == 0) {
            return initialCapital;
        }
        PriorityQueue<Project> pQueue = new PriorityQueue<>(new Comparator<Project>(){
            public int compare(Project a, Project b) {
                if (b.profit == a.profit) {
                    return a.capital - b.capital;
                }
                return b.profit - a.profit;
            }
        });
        
        for (int i = 0; i < total; i++) {
            pQueue.add(new Project(capital[i], profits[i]));
        }
        
        int currentCapital = initialCapital;
        while (--projectsToDo >= 0) {        	
        	List<Project> polledList = new ArrayList<>();        	
        	while (!pQueue.isEmpty()) {
                Project polled = pQueue.poll();
                if (polled.capital <= currentCapital) {
                    currentCapital += polled.profit;        
                    break;
                } else {
                    polledList.add(polled);
                }                
            }    
            pQueue.addAll(polledList);
        }
        return currentCapital;
    }

}