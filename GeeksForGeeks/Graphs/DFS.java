/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function below*/

//http://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class GfG
{   
    Stack<Integer> stack;
    public void DFS(int v,LinkedList<Integer> adj[],boolean visited[])
    {
        System.out.print(v + " ");
        stack = new Stack<>();
        visited[v] = true;
        populateStack(adj[v], visited);
        //printStack();
        while (!stack.empty()) {
            int nextElement = stack.pop();
            if (!visited[nextElement]) {
                System.out.print(nextElement + " ");    
            }
            visited[nextElement] = true;
            populateStack(adj[nextElement], visited);
            //printStack();
        }
    }
    
    public void populateStack(LinkedList<Integer> list, boolean visited[]) {
        int length = list.size();
        for (int i = length - 1; i >= 0; i--) {
            if (!visited[list.get(i)]) {
                stack.push(list.get(i));    
            }
        }
    }
    
    public void printStack() {
        System.out.println(Arrays.toString(stack.toArray()));
    }
}