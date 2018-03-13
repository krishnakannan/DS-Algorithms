class Solution {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		
		/*
			Finding the leftmost point;
			Pre-Optimization
			Using concept - Sides are n and diagonal is n * Sqrt(2);
			Trick is to find the Sides and diagonal;
		*/
		
		int least = p1[0];
		least = p2[0] < least ? p2[0] : least;
		least = p3[0] < least ? p3[0] : least;
		least = p4[0] < least ? p4[0] : least;
		
		if (least == p2[0]) {
			int t1 = p1[0];
			int t2 = p1[1];
			p1[0] = p2[0];
			p1[1] = p2[1];
			p2[0] = t1;
			p2[1] = t2;
		}
		
		if (least == p3[0]) {
			int t1 = p1[0];
			int t2 = p1[1];
			p1[0] = p3[0];
			p1[1] = p3[1];
			p3[0] = t1;
			p3[1] = t2;
		}
		
		if (least == p4[0]) {
			int t1 = p1[0];
			int t2 = p1[1];
			p1[0] = p4[0];
			p1[1] = p4[1];
			p4[0] = t1;
			p4[1] = t2;
		}        
		
		double l1 = getLength(p1, p2);
		double l2 = getLength(p1, p3);
		double l3 = getLength(p1, p4);
		double l4 = 0d; 
		
		//System.out.println("L1 " + l1 + " L2 " + l2 + " L3 " + l3);
		
		if (l1 == l2 && l1 == l3) {
			return false;
		} else if (l1 == l2) {            
			l4 = getLength(p2, p3);
			if (dCompare(getRoundedDouble(l1 * Math.sqrt(2)), l3) && l3 == l4 && (p1[1] <= p4[1] || p1[0] <= p4[0])) {
				return true;
			}
		} else if (l1 == l3) {     
			l4 = getLength(p2, p4);
			if (dCompare(getRoundedDouble(l1 * Math.sqrt(2)), l2) && l2 == l4 && (p1[1] <= p3[1] || p1[0] <= p3[0])) {
				return true;
			}
		} else if (l2 == l3) {     
			l4 = getLength(p3, p4);
			if (dCompare(getRoundedDouble(l2 * Math.sqrt(2)), l1) && l1 == l4 && (p1[1] <= p2[1] || p1[0] <= p2[0])) {
				return true;
			}
		}

		return false;
	}    
	
	
	public boolean dCompare(double a, double b) {
		double x = Math.ceil(a * 100d);
		double y = Math.ceil(b * 100d);
		//System.out.println(" X " + x + " Y " + y);
		return x == y;
	}
	
	public double getRoundedDouble(double d) {
		return Math.round(d * 10000.0d) / 10000.0d;
	}
	
	public double getLength(int[] a, int[] b) {
		double x = Math.pow(b[0] - a[0], 2);
		double y = Math.pow(b[1] - a[1], 2);
		return getRoundedDouble(Math.sqrt(x + y)); 		
	}
}