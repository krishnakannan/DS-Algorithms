class Solution {
    
    //Using Dijkstra's
    
    Map<Integer, List<Edge>> graph;
    boolean visited[];
    class Node {
        int id;
        int shortestDistanceToSource;
        public Node(int id) {
            this.id = id;            
            this.shortestDistanceToSource = Integer.MAX_VALUE;
        }
    }
    
    class Edge {
        Node node;
        int weight;
        public Edge(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        } 
    }
    
    public int networkDelayTime(int[][] times, int N, int K) {
        Node[] nodes = new Node[N];
        visited = new boolean[N];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        
        graph = new HashMap<>();    
        for (int[] time : times) {
            if (!graph.containsKey(time[0])) {
                graph.put(time[0], new ArrayList<>());
            }
            graph.get(time[0]).add(new Edge(nodes[time[1] - 1], time[2]));
        }                        
        
        Queue<Node> pQueue = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node a, Node b) {
                return a.shortestDistanceToSource - b.shortestDistanceToSource;
            }
        });
        
        //printDistance(nodes);
        
        nodes[K - 1].shortestDistanceToSource = 0;        
        
        for (int i = 0; i < nodes.length; i++) {
            pQueue.add(nodes[i]);
        }                    
        
        while (!pQueue.isEmpty()) {                        
            Node currentNode = pQueue.poll();
            visited[currentNode.id - 1] = true;
            List<Edge> neighbors = graph.get(currentNode.id);            
            if (neighbors != null) {
                for (Edge connectingEdge : neighbors) {
                    Node neighbor = connectingEdge.node;
                    if (!visited[neighbor.id - 1]) {
                        pQueue.remove(neighbor);                
                        neighbor.shortestDistanceToSource = (currentNode.shortestDistanceToSource + connectingEdge.weight) < neighbor.shortestDistanceToSource ? (currentNode.shortestDistanceToSource) + connectingEdge.weight : neighbor.shortestDistanceToSource;                            
                        pQueue.add(neighbor);                      
                    }                                         
                }               
            }            
            //printDistance(nodes);
        }
        
        int maxDistance = 0;
        
        for (Node node : nodes) {
            if (node.shortestDistanceToSource == Integer.MAX_VALUE) {
                return -1;
            }
            maxDistance = node.shortestDistanceToSource > maxDistance ? node.shortestDistanceToSource : maxDistance;
        }
        
        return maxDistance;
    }  
    
    public void printDistance(Node[] nodes) {
        for (Node node : nodes) {
            System.out.print(node.shortestDistanceToSource + " ");
        }
        System.out.println();
    }
}