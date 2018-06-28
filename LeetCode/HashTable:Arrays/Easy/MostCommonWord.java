class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String bannedString : banned) {
            bannedSet.add(bannedString);
        }
        
        //!?',;.
        paragraph = paragraph.replace("!", "");
        paragraph = paragraph.replace("?", "");        
        paragraph = paragraph.replace("'", "");
        paragraph = paragraph.replace(",", "");
        paragraph = paragraph.replace(";", "");
        paragraph = paragraph.replace(".", "");
        
        
        
        Map<String, Integer> wordMap = new HashMap<>();
        
        String[] words = paragraph.split(" ");
        for (String singleWord : words) {
            String word = singleWord.toLowerCase();
            if (!bannedSet.contains(word)) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);    
            }
        }
        //System.out.println(wordMap);
        int max = Integer.MIN_VALUE;
        String mostCommon = "";
        
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostCommon = entry.getKey();
            }
        }
        return mostCommon;        
    }
}