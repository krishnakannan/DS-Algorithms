import java.util.*;
import java.lang.*;
import java.io.*;

class PermutationSequence {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PermutationSequence ps = new PermutationSequence();
		int n = in.nextInt();
		int k = in.nextInt();
		System.out.println(ps.getPermutation(n, k));
	}

	List<Integer> nums = new ArrayList<>();

    public String getPermutation(int n, int k) {        
        int kTemp = k;
        StringBuilder sBuilder = new StringBuilder();
        int nFd = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
        	nums.add(i + 1);
        }

        while (k > 1) {
        	nFd = getFact(n - 1);

        	if (k == nFd) {
        		index = 0;
        	} else {
        		if (k % nFd == 0) {
        			index = (k / nFd) - 1;
        		} else {
        			index = k / nFd;
        		}
        	}              
        	sBuilder.append(getNum(index));
        	n--;
        	k = k % nFd;
        }

        int length = nums.size();
        if (kTemp % 2 == 0) {
        	
        	for (int i = length - 1; i >= 0; i--) {
	        	if (nums.get(i) != 0) {
	        		sBuilder.append(nums.get(i));
	        	}
	        }	
        } else {
        	for (int i = 0; i < length; i++) {
	        	if (nums.get(i) != 0) {
	        		sBuilder.append(nums.get(i));
	        	}
	        }
        }
        

        return sBuilder.toString();

    }

    public int getNum(int index) {    	
    	int num = nums.get(index);    	
    	nums.remove(index);
    	return num;
    }

    public int getFact(int n) {
    	int retVal = 1;
    	while (n > 1) {
    		retVal *= n;
    		n--;
    	}
    	return retVal;
    }
}
/*

13 [3, 1, 2, 4], 
14 [3, 1, 4, 2], 
15 [3, 2, 1, 4], 
16 [3, 2, 4, 1], 
17 [3, 4, 1, 2], 
18 [3, 4, 2, 1] 

*/