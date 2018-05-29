import java.util.*;
import java.lang.*;
import java.io.*;

class MinimizeMaxDistanceToGasStation {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] stations = new int[n];
		for (int i = 0; i < stations.length; i++) {
			stations[i] = in.nextInt();
		}
		int K = in.nextInt();
		MinimizeMaxDistanceToGasStation mmdtgs = new MinimizeMaxDistanceToGasStation();
		System.out.println(mmdtgs.minmaxGasDist(stations, K));
	}

    public double minmaxGasDist(int[] stations, int K) {
        double start = 0d;
        double end = 10E8d;
 		
 		double minimumMaxDistance = binarySearch(stations, (double)K, start, end);
 		return minimumMaxDistance;
    }

    public double binarySearch(int[] stations, double k, double start, double end) {
    	
    	if (diff(start, end) <= 10E-6d) {
    		return start;
    	}
    	double middle = start + (end - start) / 2;    	
    	if (canFit(stations, k, middle)) {
    		return binarySearch(stations, k, start, middle);    		    		
    	} else {
    		return binarySearch(stations, k, middle, end);
    	}
    }

    public boolean canFit(int[] stations, double availableStations, double maxAllowedDifference) {
    	for (int i = 1; i < stations.length; i++) {
    		double inbetween = 1;
            //This is (N) log (RANGE)
    		double distance = (double)(stations[i] - stations[i - 1]);
    		if (distance > maxAllowedDifference) {
    			double stationsInBetween = Math.floor(distance / maxAllowedDifference);
    			availableStations -= stationsInBetween;
    		}
    		
            //This is (N + K) log (RANGE) - GOT TLE
    		// while (((double)(stations[i] - stations[i - 1]) / (inbetween)) > maxAllowedDifference && availableStations >= 0) {    			
    		// 	inbetween += 1;
    		// 	availableStations -= 1;
    		// }
    		
    		if (availableStations < 0) {    		
    			return false;
    		}
    	}    	
    	return true;
    }

    public double diff(double a, double b) {
    	return a > b ? a - b : b - a;
    }
}