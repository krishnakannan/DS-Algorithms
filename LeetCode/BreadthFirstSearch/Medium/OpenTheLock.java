class Solution {

    boolean reachedDestination = false;
    boolean[] visited = new boolean[10000];

    public int openLock(String[] deadends, String target) {
        return bfs(deadends, "0000", target);
    }
    
    public int bfs(String[] deadends, String source, String destination) {
        Queue<List<String>> bfsQ = new LinkedList<>();
        List<String> levelOne = new ArrayList<>();
        levelOne.add(source);
        bfsQ.add(levelOne);
        int level = 1;

        while (!bfsQ.isEmpty()) {
            List<String> currentLevel = bfsQ.poll();
            List<String> nextLevel = new ArrayList<>();
            for (String currentNode : currentLevel) {
                nextLevel.addAll(getNeighbors(deadends, currentNode, destination));
            }
            level++;
            if (reachedDestination) {
                return level;
            }
        }

        return -1;
    }
    

    public List<String> getNeighbors(String[] deadends, String currentNode, String destination) {
        char[] current = currentNode.toCharArray();
        List<String> neighbors;
        for (int i = 0; i < current.length; i++) {
            char orig = current[i];
            char oneUp = (char)(orig + 1) > '9' ? '0' : (char)(orig + 1);
            char oneDown = (char)(orig - 1) < '0' ? '9' : (char)(orig - 1);        
            current[i] = oneUp;
            int val = getInt(current);
            String sVal = new String(current);
            if (!visited[val] && !isDeadend(deadends, sVal)) {
                if (sVal.equals(destination)) {
                    reachedDestination = true;
                }
                neighbors.add(sVal);
            }
            current[i] = orig;
        }
        return neighbors;
    }

    public int getInt(char[] s) {
        int value = 0;
        int index = 0;
        while (index < s.length) {
            value *= 10;
            value += s[index] - '0';
        }
        return val;
    }

    public boolean isDeadend(String[] deadends, String str) {
        for (int i = 0; i < deadends.length; i++) {
            if (deadends[i].equals(str)){
                return true;
            }
        }
        return false;
    }
}