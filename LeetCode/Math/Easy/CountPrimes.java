public class Solution {
    public int countPrimes(int n) {
        
        boolean[] isPrime = new boolean[n];
       for (int i = 2; i < n; i++) {
          isPrime[i] = true;
       }
       // Loop's ending condition is i * i < n instead of i < sqrt(n)
       // to avoid repeatedly calling an expensive function sqrt().
       for (int i = 2; i * i < n; i++) {
          if (!isPrime[i]) continue;
          for (int j = i * i; j < n; j += i) {
             isPrime[j] = false;
          }
       }
       int count = 0;
       for (int i = 2; i < n; i++) {
          if (isPrime[i]) count++;
       }
       return count;
        // int count = 0;
        // List<Integer> prime = new ArrayList<>();
        // int originalLength;
        // boolean isPrime;
        // for (int i = 2; i < n; i++) {
        //     originalLength = prime.size();
        //     isPrime = true;
        //     for (Integer p : prime) {
        //         if ((p * p) <= i) {
        //             if (i % p == 0) {
        //                 isPrime = false;
        //                 break;
        //             }   
        //         } else {
        //             break;
        //         }
        //     }
        //     if (isPrime) {
        //         prime.add(i);
        //     }
        // }
        // return prime.size();   
    }
}