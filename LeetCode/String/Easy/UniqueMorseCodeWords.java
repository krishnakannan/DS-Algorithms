class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String morse = ".-,-...,-.-.,-..,.,..-.,--.,....,..,.---,-.-,.-..,--,-.,---,.--.,--.-,.-.,...,-,..-,...-,.--,-..-,-.--,--..";
        String[] morseCode = morse.split(",");
        StringBuilder builder = new StringBuilder();
        Set<String> morseSet = new HashSet<>();
        for (String word : words) {
            builder.setLength(0);
            for (int i = 0; i < word.length(); i++) {
                builder.append(morseCode[word.charAt(i) - 'a']);
            }
            morseSet.add(builder.toString());
        }
        return morseSet.size();
    }
}