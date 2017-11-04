import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/n-meetings-in-one-room/0

class NMeetingRooms {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		NMeetingRooms nm = new NMeetingRooms();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] start = new int[n];
		    int[] end = new int[n];
		    for (int i = 0; i < n; i++) {
		        start[i] = in.nextInt();
		    }
			for (int i = 0; i < n; i++) {
		        end[i] = in.nextInt();
		    }
		    List<Integer> meetings = nm.nMeetings(start, end);
		    for (Integer meeting : meetings) {
		    	System.out.print(meeting + " ");
		    }
		    System.out.println();
 		}		
	}



	public List<Integer> nMeetings(int[] start, int[] end) {
		int[] order = new int[start.length];
		for (int i = 0; i < order.length; i++) {
			order[i] = i + 1;
		}
		sort(start, end, order);
		List<Integer> meetings = new ArrayList<>();
		int endIndex = 0;
		meetings.add(order[0]);
		for (int i = 1; i < start.length; i++) {
			if (start[i] > end[endIndex]) {
				meetings.add(order[i]);
				endIndex = i;
			}
		}
		return meetings;
	}

	public void sort(int start[], int end[], int order[]) {
		for (int i = 0; i < start.length; i++) {
			for (int j = 0; j < end.length; j++) {
				if (end[i] > end[j] && i < j) {
					int sTemp = start[i];
					int eTemp = end[i];
					int oTemp = order[i];

					start[i] = start[j];
					end[i] = end[j];
					order[i] = order[j];

					start[j] = sTemp;
					end[j] = eTemp;
					order[j] = oTemp;
				}
			}
		}
	}

}