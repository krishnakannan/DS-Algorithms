import java.util.*;
import java.lang.*;
import java.io.*;

class CourseScheduleIII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] courses = new int[n][2];
		for (int i = 0; i < n; i++) {
			courses[i][0] = in.nextInt();
			courses[i][1] = in.nextInt();
		}
		CourseScheduleIII cs3 = new CourseScheduleIII();
		System.out.println(cs3.scheduleCourse(courses));
	}

    public int scheduleCourse(int[][] courses) {
        if (courses.length <= 1) {
            return courses.length;
        }
        Arrays.sort(courses, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        Queue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        int currentDay = 0;
        pQueue.add(courses[0][0]);
        
        currentDay = pQueue.peek();
        for (int i = 1; i < courses.length; i++) {
        	int tempCurrentDay = courses[i][0] + currentDay;
        	if (tempCurrentDay <= courses[i][1]) {
        		pQueue.add(courses[i][0]);
        		currentDay = tempCurrentDay;
        	} else {
        		if (courses[i][0] < pQueue.peek() && courses[i][0] + currentDay - pQueue.peek() <= courses[i][1]) {
        			currentDay -= pQueue.poll();
        			currentDay += courses[i][0];
                    pQueue.add(courses[i][0]);        			
        		}
        	}
        }

        return pQueue.size();
    }
}