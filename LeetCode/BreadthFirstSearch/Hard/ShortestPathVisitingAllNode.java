class Solution {

    Set<String> visited;

    public int shortestPathLength(int[][] graph) {
        visited = new HashSet<String>();
        Queue<Status> bfsQ = new LinkedList<>();
        int target = 0;        
        for (int i = 0; i < graph.length; i++) {
            int cVisited = 1 << i;
            target |= 1 << i;
            bfsQ.add(new Status(i, cVisited, 0));
            visited.add(i + "#" + cVisited);
        }

        while (!bfsQ.isEmpty()) {
            Status polled = bfsQ.poll();
            if (polled.visited == target) {
                return polled.level;
            }

            int[] neighbors = graph[polled.head];
            for (int i = 0; i < neighbors.length; i++) {
                int cVisited = polled.visited | (1 << neighbors[i]);
                if (!visited.contains(neighbors[i] + "#" + cVisited)) {
                    bfsQ.add(new Status(neighbors[i], cVisited, polled.level + 1));
                    visited.add(neighbors[i] + "#" + cVisited);
                    if (cVisited == target) {
                        return polled.level + 1;
                    }
                }

            }
        }

        return -1;

    }

    class Status {
        int head;
        int visited;
        int level;
        public Status (int head, int visited, int level) {
            this.head = head;
            this.visited = visited;
            this.level = level;
        }
    }
}