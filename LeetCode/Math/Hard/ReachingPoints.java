import java.util.*;
import java.lang.*;
import java.io.*;

class ReachingPoints {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int sx = in.nextInt();
		int sy = in.nextInt();
		int tx = in.nextInt();
		int ty = in.nextInt();
		ReachingPoints rp = new ReachingPoints();
		System.out.println(rp.reachingPoints(sx, sy, tx, ty));
	}

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		if (tx == ty) {
			return tx == sx && sx == sy;
		}
		boolean processed;
		while ((tx > 0 && ty > 0) || (sx > 0 && sy > 0)) {	
			processed = false;
			while (tx >= sx && ty >= sy) {			
				//System.out.println("Start SX " + sx + " SY " + sy + " TX " + tx + " TY " + ty);
				if (tx >= ty) {
					tx = ty > 0 ? tx % ty : tx;
				} else {
					ty = tx > 0 ? ty % tx : ty;
				}							
				if (tx == sx && ty == sy) {
					return true;
				}
				processed = true;
				//System.out.println("End SX " + sx + " SY " + sy + " TX " + tx + " TY " + ty);
			}			
			if (!processed) {
				return false;
			}
			int temp = sx;
			sx = tx;
			tx = temp;
			temp = sy;
			sy = ty;
			ty = temp;
		}
		if ((tx == sx && ty == sy) || (tx == sy && ty == sx)) {
			return true;
		}
		return false;

    }
}