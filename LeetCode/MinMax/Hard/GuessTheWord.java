/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */

/**
 *  This solution may or may not work. (Got Accepted twice) First Leetcode Interactive Problem.
 *  One way to improve this is eliminate all the unique words for the search space. Then make a guess for each sets.
 *
 */

class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        //Arrays.sort(wordlist);
        List<String> wordList = new ArrayList<>();
        for (String word : wordlist) {
            wordList.add(word);
        }
        int size = wordList.size();
        Random random = new Random(); 
        int similar = 0;
        int tries = 0;
        while (similar < 6 && ++tries <= 10 && wordList.size() > 0) {
            //System.out.println(wordList);
            List<String> newWordList = new ArrayList<>();            
            int randomIndex = random.nextInt(size / 2 == 0 ? 1 : size / 2);
            String candidateWord = wordList.get(randomIndex);            
            // System.out.print(candidateWord + " at " + randomIndex + " "+ " => ");
            wordList.remove(candidateWord);
            similar = master.guess(candidateWord);
            // System.out.println(similar);
            
            for (int i = 0; i < wordList.size(); i++) {    
                if (similar == 0) {
                    if (similarity(wordList.get(i), candidateWord) == similar) {
                        newWordList.add(wordList.get(i));
                    }        
                } else  {
                    if (similarity(wordList.get(i), candidateWord) >= similar) {
                        newWordList.add(wordList.get(i));
                    }    
                }

            }        
            wordList = newWordList;
            
            
            size = wordList.size();
        }
        // System.out.println("----------------------------");
    }
    
    public int similarity(String a, String b) {
        int similar = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                similar += 1;
            }
        }
        return similar;
    }
}