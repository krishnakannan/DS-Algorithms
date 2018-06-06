import java.util.*;
import java.lang.*;
import java.io.*;

class SimilarStringGroups {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] A = new String[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = in.next();
		}
		SimilarStringGroups ssg = new SimilarStringGroups();
		System.out.println(ssg.numSimilarGroups(A));
	}

	boolean[] visited;
    public int numSimilarGroups(String[] strings) {
        Set<String> set = new HashSet<>();
        for (String str : strings) {
            set.add(str);
        }
        strings = set.toArray(new String[set.size()]);
        visited = new boolean[strings.length];
        int groups = 0;
        for (int i = 0; i < strings.length; i++) {
        	if (!visited[i]) {
        		groups += 1;  
                visited[i] = true;
         		bfs(strings, strings[i]);        		
        	}
        }
        return groups;
    }

    public int bfs(String[] strings, String str) {
    	int groupSize = 0;
    	Queue<String> queue = new LinkedList<>();
    	queue.add(str);        
    	while (!queue.isEmpty()) {
    		String polled = queue.poll();    		
    		groupSize += 1;
    		for (int i = 0; i < strings.length; i++) {
    			if (!polled.equals(strings[i]) && !visited[i] && isSimilar(polled, strings[i])) {
                    visited[i] = true;
    				queue.add(strings[i]);
    			}
    		}
    	}
    	return groupSize;
    }

    public boolean isSimilar(String a, String b) {
    	int diffChars = 0;
    	for (int i = 0; i < a.length(); i++) {
    		if (a.charAt(i) != b.charAt(i)) {
    			diffChars += 1;
    		}
    	}
    	return diffChars == 2;
    }
}