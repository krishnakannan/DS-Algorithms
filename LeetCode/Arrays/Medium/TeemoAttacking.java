public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int timeSum = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
        	if (duration < timeSeries[i + 1] - timeSeries[i]) {
        		timeSum += duration;
        	} else {
        		timeSum += timeSeries[i + 1] - timeSeries[i];
        	}
        }
        
        timeSum = timeSeries.length > 0 ? timeSum + duration : timeSum;
        
        return timeSum;        
    }
}