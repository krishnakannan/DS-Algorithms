class Solution {
    
    //Referred Solution

    //https://www.youtube.com/watch?v=iPLQgXUiU14&t=314s

    Set<String> visited;
    StringBuilder builder;
    public String crackSafe(int n, int k) {
        visited = new HashSet<>();
        builder = new StringBuilder();
        String str = "";
        for (int i = 0; i < n - 1; i++) {
            str += "0";
        }
        generate(str, k);
        builder.append(str);
        return builder.toString();
    }
    
    public void generate(String str, int k) {
        for (int i = 0; i < k; i++) {
            String whole = str + "" + i;
            if (!visited.contains(whole)) {
                visited.add(whole);
                generate(whole.substring(1), k);
                builder.append(i);
            }
        }
    }
}