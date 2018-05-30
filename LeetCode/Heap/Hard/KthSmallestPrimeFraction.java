class Solution {
    //Referred Soln
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return (A[a[0]] * A[b[1]]) - (A[b[0]] * A[a[1]]);
            }
        });
        for (int i = 1; i < A.length; i++) {
            pq.add(new int[]{0, i});
        }
        while (--K > 0) {
            int[] polled = pq.poll();
            polled[0] += 1;
            if (polled[0] < polled[1]) {
                pq.add(polled);
            }
        }
        
        int[] ans = new int[]{A[pq.peek()[0]], A[pq.peek()[1]]};
        
        return ans;
    }
}