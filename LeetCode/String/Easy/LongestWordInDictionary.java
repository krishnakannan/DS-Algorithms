class Solution {
    public String longestWord(String[] words) {
        if (words.length == 0) {
            return "";
        }
        Set<String> set = new HashSet<>();
        Arrays.sort(words);
        String candidate = words[0];
        for (String word : words) {
            if (word.length() == 1) {
                set.add(word);
            } else {
                String subStr = word.substring(0, word.length() - 1);                
                
                if (set.contains(subStr)) {                    
                    set.add(word);
                    if (candidate.length() < word.length()) {
                        candidate = word;
                    }
                }                
            }
        }
        return candidate;
    }
}