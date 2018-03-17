class ValidWordAbbr {

    Map<String, Set<String>> abbreviations;
    
    public ValidWordAbbr(String[] dictionary) {
        abbreviations = new HashMap<>();
        for (String word : dictionary) {
            String aWord = abbreviate(word);
            if (!abbreviations.containsKey(aWord)) {
                abbreviations.put(aWord, new HashSet<>());
            }
            abbreviations.get(aWord).add(word);
        }
        //System.out.println(abbreviations);
    }   
    
    public boolean isUnique(String word) {
        String aWord = abbreviate(word);
        Set<String> availableWords = abbreviations.get(aWord);   
        
        if (availableWords == null) {
            return true;
        } else if (availableWords.contains(word)) {
            return availableWords.size() == 1;
        } else {
            return false;
        }
        
        //return availableWords == null ? false : availableWords.contains(word) && availableWords.size() == 1;
    }
    
    public String abbreviate(String word) {
        int wordLength = word.length();        
        return wordLength > 2 ? ("" + word.charAt(0) + (wordLength - 2) + word.charAt(wordLength - 1)) : word;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */