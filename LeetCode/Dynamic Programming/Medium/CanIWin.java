import java.util.*;
import java.lang.*;
import java.io.*;

class CanIWin {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int max = in.nextInt();
		int desired = in.nextInt();
		CanIWin cw = new CanIWin();
		System.out.println(cw.canIWin(max, desired));
	}

	

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    	//Referred Speedup
        int sum = ((1 + maxChoosableInteger) * maxChoosableInteger) / 2;
        if (sum < desiredTotal) {
            return false;
        }            
        if (desiredTotal <= 0) {
            return true;  
        } 
        dp = new HashMap<>();
        char[] c = new char[maxChoosableInteger];
        Arrays.fill(c, 'N');
        String pool = new String(c);
        boolean res = canIWin(pool, desiredTotal, 0);            
        return res;
    }

    Map<String, Boolean> dp;    
    public boolean canIWin(String pool, int desired, int collected) {
    	System.out.print("Pool " +pool );    	
    	System.out.println("    Collected " + collected);
    	if (dp.containsKey(pool)) {    		
    		return dp.get(pool);
    	}

    	if (collected >= desired) {
    		dp.put(pool, false);
    		return dp.get(pool);
    	}

    	char[] poolArray = pool.toCharArray();

    	boolean res = true;    	
    	for (int i = 0; i < poolArray.length; i++) {
    		if (poolArray[i] == 'U') {
    			continue;
    		}
    		poolArray[i] = 'U';    		
    		collected += i + 1;
    		res = !canIWin(new String(poolArray), desired, collected);    		
    		collected -= i + 1;
    		poolArray[i] = 'N';
    		if (res == true) {    			
    			break;
    		}
    	}

    	dp.put(pool, res);
    	return dp.get(pool);

    }
}