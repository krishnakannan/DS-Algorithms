class Solution {

	/*
		There is a pattern

		row 1: 0
		row 2: 01
		row 3: 0110
		row 4: 01101001
		row 5: 0110100110010110

		if Row 1 is A
		then 
		Row 2 is Row1(Rev(Row1))

		We use this to see where K falls in the previous Row.

		If Current K exceeds the previous Row's size then calculate the new K.

		KNew is x positions from the last in the current; 

		Now after fitting it into the prev row. We have to flip it.

		If Current K doesnt exceed the previous Row's Size we just proceed with K

		Reach Level 2 and return;

	*/

    public int kthGrammar(int N, int K) {
        boolean value = recurse(N, K);
        return value ? 1 : 0;
    }


    public boolean recurse(int N, int K) {     
        
        if (N == 1) {
            return false;
        }
    	if (N == 2) {
    		return K == 1 ? false : true;
    	}

    	boolean value = false;

        int noOfElePrev = (int)Math.pow(2, (N - 2));
        int noOfEleCurr = (int)Math.pow(2, (N - 1));
        
    	if (K > noOfElePrev) { 
            int kFromLast = noOfEleCurr - K;            
    		value = recurse((N - 1),(noOfElePrev - kFromLast));            
            return !value;
    	} else {            
    		value = recurse((N - 1), K);            
            return value;
    	}
    }

}