class Solution {
    
    List<String> permutations;
    
    public List<String> letterCasePermutation(String S) {
        permutations = new ArrayList<>();
        if (S.length() == 0) {
            permutations.add("");
            return permutations;
        }        
        permute(S, 0);
        return permutations;
    }
    
    public void permute(String string, int index) {
        //System.out.println(string + " " + index);
        permutations.add(string);
        if (index >= string.length()) {
            return;
        }        
        for (int i = index; i < string.length(); i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                continue;
            } else {
                char[] str = string.toCharArray();
                char old = str[i];
                if (Character.isLowerCase(old)) {
                    str[i] = Character.toUpperCase(str[i]);    
                } else {
                    str[i] = Character.toLowerCase(str[i]);
                }
                
                permute(new String(str), i + 1);
                str[i] = old;
            }
        }
    }
}