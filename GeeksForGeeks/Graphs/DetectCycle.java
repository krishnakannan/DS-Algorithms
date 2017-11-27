/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function below*/

//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

class GfG
{   
    public boolean hasCycle(int v,LinkedList<Integer>[] alist,boolean[] visited, boolean[] explored) {
        for (int i = 0; i < v; i++) {
            boolean hasCycle = tracePathForCycle(i, alist[i], alist, visited, explored);
            if (hasCycle) {
                return hasCycle;
            } else {
                visited[i] = true;
            }
        }
        return false;
     }
     
    public boolean tracePathForCycle(int vertex, LinkedList<Integer> connectedNodes, LinkedList<Integer>[] graph, boolean[] visited, boolean[] explored) {


        if (visited[vertex]) {
            return false;
        }

        if (explored[vertex]) {
            return true;
        }

        if (connectedNodes.size() <= 0) {            
            explored[vertex] = false;
            return false;
        }
        explored[vertex] = true;
        for (Integer neighbour : connectedNodes) {
            //System.out.println("Here Vertex- " + vertex + " Neighbour = "+ neighbour);
            boolean hasCycle = tracePathForCycle(neighbour, graph[neighbour], graph, visited, explored);
            if (hasCycle){
                return hasCycle;
            }
        }
        explored[vertex] = false;
        return false;
    }
}