class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int bull = 0;
        int cow = 0;
        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();
        for (int i = 0; i < secretArray.length; i++) {
            map.put(secretArray[i], map.containsKey(secretArray[i]) ? map.get(secretArray[i]) + 1 : 1);
        }
        
        for (int i = 0; i < guessArray.length; i++) {
            //System.out.println(map);
            if (secretArray[i] == guessArray[i]) {
                bull++;
                map.put(guessArray[i], map.get(guessArray[i]) - 1);
                guessArray[i] = '-';
            }
        }
        
        for (int i = 0; i < guessArray.length; i++) {
            //System.out.println(map);
            if (guessArray[i] != '-' && map.containsKey(guessArray[i]) && map.get(guessArray[i]) >= 1) {
                cow++;
                map.put(guessArray[i], map.get(guessArray[i]) - 1);
            }
        }
        
        return bull + "A" + cow + "B";
    }
}