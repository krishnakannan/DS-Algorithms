import java.util.*;
import java.lang.*;
import java.io.*;

class Pow {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Pow p = new Pow();
		double x = in.nextDouble();
		int n = in.nextInt();
		System.out.println(p.myPow(x, n));
	}

    public double myPow(double x, int n) {
    	long pn = n;
        if (pn < 0) {
            x = 1 / x;
            pn = -pn;
        }
        double ans = 1;
        double cProd = x;
        for (long i = pn; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * cProd;
            }
            cProd  = cProd  * cProd ;
        }
        return ans;

    }
}