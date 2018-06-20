import java.util.*;
import java.lang.*;
import java.io.*;

class AmbiguousCoordinates {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		AmbiguousCoordinates ac = new AmbiguousCoordinates();
		System.out.println(ac.ambiguousCoordinates(s));
	}

	Set<String> coords;

    public List<String> ambiguousCoordinates(String s) {
        coords = new HashSet<>();
        form(s.substring(1, s.length() - 1), ", ", 0);
        return new ArrayList<>(coords);
    }

    public void form(String s, String symbol, int depth) {

    	for (int i = 0; i < s.length(); i++) {
    		if ((i > 0 && s.charAt(i - 1) == '.') || (i < s.length() - 1 && s.charAt(i + 1) == '.') || s.charAt(i) == '.') {
    			continue;
    		}
    		String lStr = s.substring(0, i);
    		String rStr = s.substring(i, s.length());            
    		String newStr = lStr + "" + symbol + "" + rStr;    		
    		if (isValid(newStr)) {
    			//System.out.println("Adding " + newStr + " From " + s);
    			coords.add("(" + newStr + ")");    			
    		}
    		if (depth < 2) {
				form(newStr, ".", depth + 1);
			}
    	}
    }

    public boolean isValid(String s) {
    	String[] coord = s.split(",");
        coord[0] = coord[0].trim();
    	coord[1] = coord[1].trim();
    	if (coord.length != 2 || coord[0].length() == 0 || coord[1].length() == 0) {
    		return false;
    	}

    	if (coord[0].charAt(0) == '0') {
    		if (coord[0].length() > 1 && coord[0].charAt(1) != '.') {
    			return false;
    		}
    	}

    	int fDot = 0;
    	int sDot = 0;

    	for (int i = 0; i < coord[0].length(); i++) {
    		if (coord[0].charAt(i) == '.') {
    			fDot += 1;
    		}
    	}

    	for (int i = 0; i < coord[1].length(); i++) {
    		if (coord[1].charAt(i) == '.') {
    			sDot += 1;
    		}
    	}

    	if (sDot > 1 || fDot > 1) {
    		return false;
    	}

    	if (coord[0].charAt(0) == '.' || coord[1].charAt(0) == '.') {
    		return false;
    	}

    	if (coord[0].contains(".") && ((coord[0].charAt(coord[0].length() - 1) == '0') || (coord[0].charAt(coord[0].length() - 1) == '.'))) {
    		return false;
    	}

    	if (coord[1].charAt(0) == '0') {
    		if (coord[1].length() > 1 && coord[1].charAt(1) != '.') {
    			return false;
    		}
    	}

    	if (coord[1].contains(".") && ((coord[1].charAt(coord[1].length() - 1) == '0') || (coord[1].charAt(coord[1].length() - 1) == '.'))) {
    		return false;
    	}

    	return true;
    }
}