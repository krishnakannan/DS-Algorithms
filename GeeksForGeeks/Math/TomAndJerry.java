import java.util.*;
import java.lang.*;
import java.io.*;

class OptimalStrategyTomJerry {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		OptimalStrategyTomJerry os = new OptimalStrategyTomJerry();
		while (--testcases >= 0) {
		    int n = in.nextInt();
			System.out.println(os.isTomWinner(n) ? 1 : 0);
 		}
	}

	public boolean isTomWinner(int i) {
		return i % 2 == 0 ? true : false;
	}
}