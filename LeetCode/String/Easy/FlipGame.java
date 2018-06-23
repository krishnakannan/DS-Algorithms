class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> generated = new ArrayList<>();
        
        char[] string = s.toCharArray();
        for (int i = 0; i < string.length - 1; i++) {
            if (string[i] == '+' && string[i + 1] == '+') {
                string[i] = '-';
                string[i + 1] = '-';
                generated.add(new String(string));
                string[i] = '+';
                string[i + 1] = '+';
            }
        }
        
        return generated;
    }
}