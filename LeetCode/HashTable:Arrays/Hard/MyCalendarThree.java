import java.util.*;
import java.lang.*;
import java.io.*;

class MyCalendarThree {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		MyCalendarThree mc3 = new MyCalendarThree();
		long start = in.nextLong();
		long end = in.nextLong();
		while (start < Integer.MAX_VALUE && end < Integer.MAX_VALUE) {
			System.out.println(mc3.book((int)start, (int)end));
			start = in.nextLong();
			end = in.nextLong();
		}
	}

	

	TreeMap<Integer, Integer> tree;
    int highest;
    public MyCalendarThree() {
        tree = new TreeMap<>();
        highest = 0;
    }
    
    public int book(int start, int end) {

    	if (tree.size() == 0) {
    		tree.put(start, 1);
    		tree.put(end, -1);
    		return 1;
    	}    
        
    	tree.put(start, tree.getOrDefault(start, 0) + 1);
    	tree.put(end, tree.getOrDefault(end, 0) - 1);
    	int val = 0;	
    	for (Map.Entry<Integer, Integer> entry : tree.entrySet()) {
			val += entry.getValue();
			highest = highest < val ? val : highest;
    	}        
    	return highest;
    }
}