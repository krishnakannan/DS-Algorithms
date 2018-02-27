import java.util.*;
import java.lang.*;
import java.io.*;

class NextClosestTime {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String time = in.next();
		NextClosestTime nc = new NextClosestTime();
		System.out.println(nc.nextClosestTime(time));
	}

	boolean[] timeEntry = new boolean[10];

    public String nextClosestTime(String time) {
        
        char[] tArray = time.toCharArray();
        for (int i = tArray.length - 1; i >= 0; i--) {
        	if (tArray[i] != ':') {
        		timeEntry[tArray[i] - '0'] = true;
        	}
        }

        int limit = 9;
        int reductionLimit = 4;

        char[] nArray = new char[5];
        for (int i = nArray.length - 1; i >= 0; i--) {
        	if (i == 2) {
        		nArray[i] = ':';
        		continue;
        	}

        	int next = getNext((int)(tArray[i] - '0'), limit);
        	nArray[i] = (char)(next + '0');

        	if (tArray[i] < nArray[i]) {
        		for (int x = i - 1; x >= 0; x--) {
        			nArray[x] = tArray[x];
        		}
        		break;
        	}

        	limit -= reductionLimit;
        	reductionLimit /= 2;
        }

        return new String(nArray);
    }

    public int getNext(int current, int limit) {
    	int next = timeEntry[0] ? 0 : timeEntry[1] ? 1 : 2;
    	for (int i = current + 1; i < 10 && i <= limit; i++) {
    		if (timeEntry[i]) {
    			next = i;
    		}
    	}
    	return next;
    }
}