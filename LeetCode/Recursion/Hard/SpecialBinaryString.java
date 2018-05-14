import java.util.*;
import java.lang.*;
import java.io.*;

class SpecialBinaryString {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		SpecialBinaryString sbs = new SpecialBinaryString();
		System.out.println(sbs.makeLargestSpecial(s));
	}

	//Based on hint from desc	
	public String makeLargestSpecial(String s) {    	
        return makeLargest(s);
    }



    //Recurse all the special string
    public String makeLargest(String s) {    	    	
    	if (s.isEmpty()) {
    		return s;
    	}
System.out.println(s);
    	
    	List<String> specialSubStrings = new ArrayList<>();
    	int level = 0;
    	int start = 0;
    	int end = 0;
    	for (int i = 0; i < s.length(); i++) {
    		end = i + 1;
    		level += s.charAt(i) == '1' ? 1 : -1;
    		if (level == 0) {
    			specialSubStrings.add("1" + makeLargest(s.substring(start + 1, end)) + "0");
    			start = i + 1;
    		}
    	}

    	Collections.sort(specialSubStrings, Collections.reverseOrder());

    	StringBuilder sBuilder = new StringBuilder();
    	for (String substring : specialSubStrings) {
    		sBuilder.append(substring);
    	}

    	return sBuilder.toString();
    }

    
}
