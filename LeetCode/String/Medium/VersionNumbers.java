import java.util.*;
import java.lang.*;
import java.io.*;

class VersionNumbers {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String version1 = in.next();
		String version2 = in.next();
		VersionNumbers vn = new VersionNumbers();
		System.out.println(vn.compareVersion(version1, version2));
	}

    String[] v1;
    String[] v2;
    public int compareVersion(String version1, String version2) {
        processString(version1, version2);
        int index1 = 0;
        int index2 = 0;
        
        while (index1 < v1.length && index2 < v2.length) {            
        	int cValue = compare(v1[index1], v2[index2]);            
        	if (cValue == 0) {
        		index1++;
        		index2++;
        	} else if (cValue > 0) {
        		return 1;
        	} else if (cValue < 0) {
        		return -1;
        	}
        }

        return 0;
    }
    
    public void processString(String ver1, String ver2) {
        String[] t1 = ver1.split("\\.");        
        String[] t2 = ver2.split("\\.");                
        if (t1.length > t2.length) {
            v1 = new String[t1.length];
            v2 = new String[t1.length];
        } else if (t1.length < t2.length) {
            v1 = new String[t2.length];
            v2 = new String[t2.length];
        } else {
            v1 = new String[t1.length];
            v2 = new String[t2.length];
        }
        Arrays.fill(v1, "0");
        Arrays.fill(v2, "0");
        
        for (int i = 0; i < t1.length; i++) {
            v1[i] = t1[i];
        }
        for (int i = 0; i < t2.length; i++) {
            v2[i] = t2[i];
        }
    }
    
    public int compare(String a, String b) {        
    	Integer aVal = Integer.parseInt(a);
    	Integer bVal = Integer.parseInt(b);    	
    	return aVal - bVal;
    }
}