import java.util.*;
import java.lang.*;   
import java.io.*;

class Candy {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ratings = new int[n];
		Candy c = new Candy();
		for (int i = 0; i < ratings.length; i++) {
			ratings[i] = in.nextInt();
		}
		System.out.println(c.candy(ratings));
	}

    public int candy(int[] ratings) {
    	if (ratings.length == 0) {
            return 0;
        }
        int[] fwd = new int[ratings.length];
        int[] rev = new int[ratings.length];
        fwd[0] = 1; //ratings[0];
        rev[rev.length - 1] = 1; //ratings[ratings.length - 1];        
        int fwdMin = 1;
        int revMin = 1;
        int totalCandies = 0;
        for (int i = 1, j = ratings.length - 2; i < ratings.length && j >= 0; i++, j--) {
        	if (ratings[i] > ratings[i - 1]) {
        		fwd[i] = fwd[i - 1] + 1;
         	} else {
         		fwd[i] = 1;
         	}
         	
         	if (ratings[j] > ratings[j + 1]) {
        		rev[j] = rev[j + 1] + 1;
         	} else {
         		rev[j] = 1;
         	}
        }
        
        print(fwd);
        print(rev);

        for (int i = 0; i < ratings.length; i++) {
        	totalCandies += fwd[i] > rev[i] ? fwd[i] : rev[i];
        }
        return totalCandies;
    }

    public void print(int[] aux) {
    	for (int i = 0; i < aux.length; i++) {
    		System.out.print(aux[i] + " "); 
    	}
    	System.out.println();
    }
}