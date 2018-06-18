import java.util.*;
import java.lang.*;
import java.io.*;

class KSimilarity {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String A = in.next();
		String B = in.next();
		KSimilarity ks = new KSimilarity();
		System.out.println(ks.kSimilarity(A, B));
	}


	Map<String, Integer> memo;	
    int minSoFar = Integer.MAX_VALUE;
    public int kSimilarity(String A, String B) {
        memo = new HashMap<>();
        int res = dfs(A, B, 0, 0);
        //System.out.println(memo);
        return res;
    }

    public int dfs(String a, String b, int startIndex, int depth) {    	
    	//System.out.println("A " + a + " B " + b);
    	if (memo.containsKey(a)) {
    		return memo.get(a);
    	}
    	if (a.equals(b)) {
            minSoFar = depth;
    		return 0;
    	}
        
        if (depth >= minSoFar) {
            memo.put(a, 1000000000);
            return 1000000000;
        }

    	if (!check(a, b, startIndex)) {            
    		return 1000000000;
    	}

    	int minChanges = 1000000000;

    	for (int i = startIndex; i < a.length(); i++) {
    		for (int j = i + 1; j < a.length(); j++) {
    			char[] aArr = a.toCharArray();
    			char temp = aArr[i];
    			aArr[i] = aArr[j];
    			aArr[j] = temp;
                if (aArr[i] == b.charAt(i)) {
                    int changes = dfs(new String(aArr), b, i + 1, depth + 1) + 1;
    			    minChanges = changes < minChanges ? changes : minChanges;    
                }    			
    			aArr[j] = aArr[i];
    			aArr[i] = temp;
    		}
    	}
        
    	memo.put(a, minChanges);
    	return memo.get(a);
    }

    public boolean check(String a, String b, int index) {
    	for (int i = 0; i < index; i++) {
    		if (a.charAt(i) != b.charAt(i)) {
    			return false;
    		}
    	}
    	return true;
    } 
}