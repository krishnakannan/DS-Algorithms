class Solution {
    public int minSteps(int n) {
		if (n == 1) {
			return 0;
		}
        int[] arr = n > 3 ? new int[n + 1] : new int[4];
        int[] prime = new int[arr.length];
        prime[0] = arr[2] = 2;
        prime[1] = arr[3] = 3;        
        int primeIndex = 2;
       for (int i = 4; i <= n; i++) {       		
       		if (checkPrime(i)) {
       			arr[i] = i;
                prime[primeIndex] = i;
                primeIndex++;
                // System.out.println("Prime - " + i);
       		} else {                     
       			if ((double)i % 2d == 0d) {
       				arr[i] = 2 + arr[i/2];
       			} else if ((double)i % 3d == 0d) {
       				arr[i] = 3 + arr[i/3];
       			} else if ((double)i % 5d == 0d) {                                        
       				arr[i] = 5 + arr[i/5];
       			} else if ((double)i % 7d == 0d) {
       				arr[i] = 7 + arr[i/7];
       			} else {                    
                    int x = 4;                    
                    while (prime[x] > 0) {                                                                                       
                        if (i % prime[x] == 0) {
                            arr[i] = prime[x] + arr[i/prime[x]];                            
                            break;    
                        }
                        x++;
                    }
                }
       		}
       	}
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(prime[i] + ", ");
        // }
       	return n < 4 ? n : arr[n];
    }

    public boolean checkPrime(int num) {
    	double val = 1d;
    	while (val * val < num) {
    		val++;
    	}

    	for (double i = 2d; i <= val; i++) {
    		if ((double)num % i == 0d) {                
    			return false;
    		}
    	}
    	return true;
    }
}