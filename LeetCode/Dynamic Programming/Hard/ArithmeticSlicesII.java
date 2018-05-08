import java.util.*;
import java.lang.*;   
import java.io.*;
class ArithmeticSlicesII {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		ArithmeticSlicesII as = new ArithmeticSlicesII();
		int num[] = new int[x];
		for (int i = 0; i < x; i++) {
			num[i] = in.nextInt();
		}
		System.out.println(as.numberOfArithmeticSlices(num));		
	}
    	
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        long output = 0;

        Map<Long, Long>[] dp = new Map[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - (long)A[j];                
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }                
                long sum = dp[j].getOrDefault(diff, 0l);
                long original = dp[i].getOrDefault(diff, 0l);
                dp[i].put(diff, original + sum + 1);
                output += sum;
            }
            
        }          
        return (int)output;        
	}     
}