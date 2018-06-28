class Solution {
    public String boldWords(String[] words, String S) {
        int[] boldIndex = new int[S.length()];
        for (int i = 0; i < words.length; i++) {
            int fromIndex = 0;
            int startIndex = 0;
            while (startIndex != -1) {
                startIndex = S.indexOf(words[i], fromIndex);
                if (startIndex >= 0) {
                    bold(boldIndex, startIndex, words[i].length());
                    fromIndex += 1 ; // startIndex + words[i].length();
                }
            }
        }
        StringBuilder bsBuilder = new StringBuilder();
        for (int i = 0; i < boldIndex.length; i++) {
            if (i == 0 && boldIndex[i] == 1) {
                bsBuilder.append("<b>" + S.charAt(i));                
                continue;
            } else if (i == 0) {
                bsBuilder.append(S.charAt(i));
                continue;
            }
            
            if (boldIndex[i] == 1 && boldIndex[i - 1] == 0) {
                bsBuilder.append("<b>");
            } else if (boldIndex[i] == 0 && boldIndex[i - 1] == 1) {
                bsBuilder.append("</b>");
            }
            bsBuilder.append(S.charAt(i));
        }
        if (boldIndex[boldIndex.length - 1] == 1) {
            bsBuilder.append("</b>");
        }
        return bsBuilder.toString();
        
    }
    
    public void bold(int[] bIndex, int startIndex, int length) {
        for (int i = startIndex; i < startIndex + length; i++) {
            bIndex[i] = 1;
        }
    }
}