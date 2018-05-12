import java.util.*;
import java.lang.*;   
import java.io.*;

class MaxVacationDays {

	public static void main(String args[]) {
		MaxVacationDays mvd = new MaxVacationDays();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] flights = new int[n][n];
		for (int i = 0; i < flights.length; i++) {
			for (int j = 0; j < flights[0].length; j++) {
				flights[i][j] = in.nextInt();
			}
		}

		int w = in.nextInt();
		int[][] days = new int[n][w];
		for (int i = 0; i < days.length; i++) {
			for (int j = 0; j < days[0].length; j++) {
				days[i][j] = in.nextInt();
			}
		}

		System.out.println(mvd.maxVacationDays(flights, days));
	}

	int[][] memo;
    public int maxVacationDays(int[][] flights, int[][] days) {
        memo = new int[days.length][days[0].length];
        int[] flightsFromHere = flights[city];
        int maxVacationDaysHere = Integer.MIN_VALUE;
    	for (int i = 0; i < flightsFromHere.length; i++) {
    		if (flightsFromHere[i] == 1 || i == 0) {
    			int vacationThatCanBeTaken = dfs(flights, days, i, 1);
    			maxVacationDaysHere = vacationThatCanBeTaken > maxVacationDaysHere ? vacationThatCanBeTaken : maxVacationDaysHere;    			
    		}
    	}
    	return maxVacationDaysHere;
    }


    public int dfs(int[][] flights, int[][] days, int city, int week) {
    	if (week > days[0].length) {
    		return 0;
    	}

    	if (memo[city][week] != Integer.MIN_VALUE) {
    		return memo[city][week];
    	}

    	int maxVacationDaysHere = Integer.MIN_VALUE;
    	int[] flightsFromHere = flights[city];

    	for (int i = 0; i < flightsFromHere.length; i++) {
    		if (flightsFromHere[i] == 1 || i == city) {
    			int vacationThatCanBeTaken = dfs(flights, days, i, week + 1);
    			maxVacationDaysHere = vacationThatCanBeTaken > maxVacationDaysHere ? vacationThatCanBeTaken : maxVacationDaysHere;    			
    		}
    	}

    	maxVacationDaysHere += days[city][week];
    	memo[city][week] = maxVacationDaysHere[city][week];
    	return memo[city][week];

    }
}