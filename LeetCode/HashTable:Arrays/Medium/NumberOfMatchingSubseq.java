class Solution {
    Map<Character, TreeSet<Integer>> map = new HashMap<>();
    public int numMatchingSubseq(String S, String[] words) {
        char[] string = S.toCharArray();
        for (int i = 0; i < string.length; i++) {
            if (!map.containsKey(string[i])) {
                map.put(string[i], new TreeSet<>());
            }
            map.get(string[i]).add(i);
        }
        
        //System.out.println(map);
        
        int subseq = 0;
        
        for (String word : words) {
            if (!map.containsKey(word.charAt(0))) {
                 continue;   
            }
            Integer index = map.get(word.charAt(0)).first();
            Integer nextIndex = 0;
            int wLen = word.length();            
            int i;
            for (i = 1; i < wLen; i++) {
                if (map.containsKey(word.charAt(i))) {
                    nextIndex = map.get(word.charAt(i)).higher(index);                                        
                    if (nextIndex == null) {
                        break;
                    } else {                        
                        index = nextIndex;
                    }    
                } else {
                    break;
                }                
            }
            if (i == wLen) {                
                subseq++;
            }
        }
        return subseq;
    }
}