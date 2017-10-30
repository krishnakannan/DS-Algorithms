import java.util.*;
import java.lang.*;
import java.io.*;

class IsStrRotatedII {
	public static void main (String[] args) {
		IsStrRotatedII is = new IsStrRotatedII();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		
		while (--testcases >= 0) {
		    String str = in.next();		
		    String rStr = in.next();

		    System.out.println(is.isRotated(str, rStr) ? 1 : 0);
 		} 		
	}

	public boolean isRotated(String str, String rStr) {
		if (str.length() != rStr.length())
            return false;
      
        String clockwise = "";
        String anticlockwise = "";
        int len = str.length();
      
        // Initialize string as anti-clockwise rotation
        anticlockwise = anticlockwise +
                        rStr.substring(len - 2, len) +
                        rStr.substring(0, len - 2) ;
      
        // Initialize string as clock wise rotation
        clockwise = clockwise +
                    rStr.substring(2) +
                    rStr.substring(0, 2) ;
      
        // check if any of them is equal to string1
        return (str.equals(clockwise) ||
                str.equals(anticlockwise));
	}
}