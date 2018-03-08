// A Simple DFS Implementation

class Solution {

    Map<String, List<String>> map = new HashMap<>();
    Set<String> visited = new HashSet<>();

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {

        if (words1.length != words2.length) {
            return false;
        }

        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new ArrayList<>());
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new ArrayList<>());
            }
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }   
    
        //System.out.println(map);
        
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])) {
                visited.clear();
                if (!dfs(words1[i], words2[i])) {                             
                    return false;
                }    
            }
        }
        
        return true;
    }

    public boolean dfs(String source, String destination) {        
        //System.out.println(source + " -> " + destination);
        if (source.equals(destination)) {            
            return true;
        }

        boolean pathExists = false;
        visited.add(source);
        List<String> nextList = map.get(source);
        if (nextList == null || nextList.isEmpty()) {
            return false;
        }
        for (String next : nextList) {
            if (!visited.contains(next)) {
                pathExists = dfs(next, destination);
                if (pathExists) {
                    break;
                }
            }
        }

        return false || pathExists;
    }
}