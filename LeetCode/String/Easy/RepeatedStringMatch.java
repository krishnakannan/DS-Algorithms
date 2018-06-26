class Solution {
    public int repeatedStringMatch(String A, String B) {
        //Re Implement is with KMP or Robin-Karp
        StringBuilder builder = new StringBuilder();
        builder.append(A);
        int size = 1;
        while (builder.length() < B.length()) {
            builder.append(A);
            size += 1;
        }
        
        if (builder.toString().contains(B)) {
            return size;
        }
        builder.append(A);
        if (builder.toString().contains(B)) {
            return size + 1;
        }
        return -1;
    }
}