/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function below*/

//http://practice.geeksforgeeks.org/problems/maximum-subset-xor/1

class GfG
{
	public static int maxSubarrayXOR(int set[], int n) {

		int index = 0;
		for (int i = 32 - 1; i >= 0; i--)  {
			int maxInd = index;
			int maxEle = Integer.MIN_VALUE;

			for (int j = index; j < n; j++) {
				 if ((set[j] & (1<<i))!= 0 && set[j] > maxEle) {
				 	maxEle = set[j];
				 	maxInd = j;
				 }                
			}

			if (maxEle == Integer.MIN_VALUE) {
				continue;	
			}
			
			int temp = set[index];
			set[index] = set[maxInd];
			set[maxInd] = temp;			
			maxInd = index;

			
			for (int j = 0; j < n; j++) {			
				if ((j != maxInd) && ((set[j] & (1 << i)) != 0)) {					
					set[j] = set[j]^set[maxInd];
				}
			}

			
			index++;
		
		}
		
		int res = 0;
		for (int i = 0; i < n; i++) {
			res ^= set[i];	
		}						
	
		return res;

	}
}