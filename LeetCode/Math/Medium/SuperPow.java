import java.util.*;
import java.lang.*;
import java.io.*;

class SuperPow {

	public static void main(String a[]) {
		SuperPow sp = new SuperPow();
		Scanner in = new Scanner(System.in);
		int base = in.nextInt();
		int n = in.nextInt();
		int[] exponent = new int[n];
		for (int i = 0; i < n; i++) {
			exponent[i] = in.nextInt();
		}
		System.out.println(sp.superPow(base, exponent));
	}

    public int superPow(int base, int[] exponentArray) {
        List<Integer> values = new ArrayList<>();
        int exponent = getInteger(exponentArray);
        int num = 1;
        base = base % 1337;
        while (exponent > 0) {

        	if (exponent % 2 != 0) {
        		exponent--;
        		values.add(base);
        	}

        	base = (base * base) % 1337;
        	exponent /= 2;
        }

        for (Integer value : values) {
        	num = (num * value) % 1337;
        }

        return num;

    }

    /*
        Arriving at 1140.
        
        This is based on Euler totient function. Phi(n).
         
        The totient φ(n) of a positive integer n greater than 1 is defined to be the number of positive integers less than n that are coprime to n
        
        when n is a prime number (e.g. 2, 3, 5, 7, 11, 13), φ(n) = n-1.
        
        when m and n are coprime, φ(m*n) = φ(m)*φ(n).
        
        Given mod value is 1337 => Can be broken down to 7 * 191.
        
        7 and 191 are prime.
        
        φ(7*191) = φ(7)*φ(191) = 6 * 190 = 1140.
        
        According to Euler's theorem.
        
        a ^ b % k = a ^ (b % φ(k)) % k
        
        =>
        
        a ^ b % 1337 = a ^ (b % 1140) % 1337.
        
    */
    
    public int getInteger(int[] exponentArray) {
    	int num = 0;
    	for (int i = 0; i < exponentArray.length; i++) {
    		num *= 10;
    		num += exponentArray[i];
    		num = num % 1140;
    	}
    	return num;
    }
}