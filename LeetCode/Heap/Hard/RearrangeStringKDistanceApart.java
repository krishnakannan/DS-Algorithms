import java.util.*;
import java.lang.*;
import java.io.*;

class RearrangeStringKDistanceApart {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		RearrangeStringKDistanceApart raskda = new RearrangeStringKDistanceApart();
		String s = in.next();
		int k = in.nextInt();
		System.out.println(raskda.rearrangeString(s, k));
	}

	 Alphabet {
		char c;
		int count;
		int k;
		public Alphabet(char c, int count, int k) {
			this.c = c;
			this.count = count;
			this.k = k;
		}
	}

    public String rearrangeString(String s, int k) {
        if (k <= 1) {
            return s;
        }
        Alphabet[] alphabets = new Alphabet[26];
        for (int i = 0; i < alphabets.length; i++) {
        	alphabets[i] = new Alphabet((char)(i + 'a'), 0, 0);
        }
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
        	alphabets[str[i] - 'a'].count += 1;
        }
        Arrays.sort(alphabets, new Comparator<Alphabet>(){
        	public int compare(Alphabet a, Alphabet b) {
        		return b.count - a.count;
        	}
        });

        Queue<Alphabet> pQueue = new PriorityQueue<Alphabet>(new Comparator<Alphabet>(){
        	public int compare(Alphabet a, Alphabet b) {
        		if (a.k == b.k) {
        			return b.count - a.count;
        		}
        		return a.k - b.k;
        	}
        });

        for (int i = 0; i < 26; i++) {
        	if (alphabets[i].count > 0) {
        		alphabets[i].k = i;
        		pQueue.add(alphabets[i]);
        	}
        }

        StringBuilder builder = new StringBuilder();
        int[] lastKnown = new int[26];
        int index = 0;
        Arrays.fill(lastKnown, -100000);
        while (!pQueue.isEmpty()) {        	
        	Alphabet polled = pQueue.poll();            
            if (index - lastKnown[polled.c - 'a'] < k) {
                return "";
            } else {
                lastKnown[polled.c - 'a'] = index;
                index += 1;
            }
        	if (builder.length() == 0) {
        		builder.append(polled.c);
        		polled.count -= 1;
        		if (polled.count > 0) {
        			polled.k += k;
        			pQueue.add(polled);
        		}                
        	} else if (builder.length() > 0 && builder.charAt(builder.length() - 1) != polled.c) {
        		builder.append(polled.c);
        		polled.count -= 1;
        		if (polled.count > 0) {
        			polled.k += k;
        			pQueue.add(polled);
        		}
        	} else {        		
        		return "";
        	}
        }        
        return builder.toString();
    }
}