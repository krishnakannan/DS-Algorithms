import java.util.*;
import java.lang.*;
import java.io.*;

class PushDominos {

	public static void main(String arg[]) {
		Scanner in = new Scanner(System.in);
		String dominos = in.next();
		PushDominos pd = new PushDominos();
		System.out.println(pd.pushDominoes(dominos));
	}

    public String pushDominoes(String dominosStr) {
    	if (dominosStr.length() <= 1) {
    		return dominosStr;
    	}
    	char[] dominos = dominosStr.toCharArray();
        char[] res = Arrays.copyOf(dominos, dominos.length);

        //Handle Left
        int left = 0;
        for (; left < dominos.length; left++) {
        	if (dominos[left] == 'R') {        		
        		break;
        	}        	
        }

        for (int i = left == dominos.length ? left - 1 : left; i >= 0; i--) {
        	if (dominos[i] == 'L') {        		
        		while (i >= 0) {
        			dominos[i] = 'L';
        			i -= 1;
        		}
        	}
        }

        //Handle Right
        int right = dominos.length - 1;
        for (; right >= 0; right--) {
        	if (dominos[right] == 'L') {
        		break;
        	}
        }

        for (int i = right == -1 ? 0 : right; i < dominos.length; i++) {
        	if (dominos[i] == 'R') {
        		while (i < dominos.length) {
        			dominos[i] = 'R';
        			i += 1;
        		}
        	}
        }

        //System.out.println(new String(dominos));

        right = left + 1;

        while (right < dominos.length) {
        	if (dominos[right] == '.') {
        		right += 1;
        	} else if (dominos[left] == 'R' && dominos[right] == 'R') {
        		int l = left;
        		int r = right;
        		while (l <= r) {
        			dominos[l] = 'R';
        			l += 1;
        		}
        		left = right;
        		right = left + 1;
        	} else if (dominos[left] == 'L' && dominos[right] == 'L') {
        		int l = left;
        		int r = right;
        		while (l <= r) {
        			dominos[l] = 'L';
        			l += 1;
        		}
        		left = right;
        		right = left + 1;
        	} else if (dominos[left] == 'R' && dominos[right] == 'L') {
        		int l = left;
        		int r = right;
        		while (l < r) {
        			dominos[l] = 'R';
        			dominos[r] = 'L';
        			l += 1;
        			r -= 1;        	
        		}
        		left = right;
        		right = left + 1;
        	} else if (dominos[left] == 'L' && dominos[right] == 'R') {
        		left = right;
        		right = left + 1;
        		continue;
        	} else {
        		left += 1;
        		right = left + 1;
        	}
        }

        return new String(dominos);
    }
}