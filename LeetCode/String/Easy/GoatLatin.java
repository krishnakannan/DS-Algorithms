class Solution {
    
    int aCount = 1;
    
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sbuilder = new StringBuilder();
        for (String word : words) {
            aCount += 1;
            if (startsWithVowels(word)) {
                sbuilder.append(word + "" + getA() + " ");
            } else {
                sbuilder.append(word.substring(1) + "" + word.charAt(0) + getA() + " ");
            }
        }
        sbuilder.setLength(sbuilder.length() - 1);
        return sbuilder.toString();
    }
    
    public boolean startsWithVowels(String s) {
        char c = s.charAt(0);
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    public String getA() {
        StringBuilder sb = new StringBuilder();
        sb.append("m");
        for (int i = 0; i < aCount; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
}