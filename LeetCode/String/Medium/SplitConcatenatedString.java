class Solution {
    public String splitLoopedString(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        Set<Integer> strIndex = new HashSet<>();        
        int finalStrLength = 0;
        strIndex.add(finalStrLength);
        String[] revstrs = new String[strs.length];        
        for (String str : strs) {
            finalStrLength += str.length();
            strIndex.add(finalStrLength);
        }        
        //System.out.println(strIndex);        
        char[] finalString = new char[finalStrLength];
        String maxString = " ";
        //Populate the charArray;
        int cIndex = 0;
        int sIndex = 0;
        while (cIndex < finalString.length && sIndex < strs.length) {
            String str = strs[sIndex];
            String revStr = reverse(str);
            revstrs[sIndex] = revStr;
            int index = 0;
            if (isFirstBigger(str, revStr)) {
                while (index < str.length()) {
                    finalString[cIndex++] = str.charAt(index++);   
                }                
            } else {
                while (index < revStr.length()) {
                    finalString[cIndex++] = revStr.charAt(index++);   
                }                
            }
            sIndex++;            
        } 
        
        cIndex = 0;
        sIndex = 0;
        int innerSIndex = 0;
        char[] tempFinal = Arrays.copyOf(finalString, finalString.length);
        while (revstrs[0] != null && innerSIndex < revstrs[0].length()) {
            if (revstrs[0].equals(new String(finalString, 0, revstrs[0].length()))) {
                revstrs[0] = reverse(revstrs[0]);
            }
            tempFinal[innerSIndex] = revstrs[0].charAt(innerSIndex);
            innerSIndex++;
        }
        while (cIndex < finalString.length) {
            
            String candidateString1 = new String(finalString, cIndex, finalString.length - cIndex) + new String(finalString, 0, cIndex - 0);
            String candidateString2 = new String(tempFinal, cIndex, finalString.length - cIndex) + new String(tempFinal, 0, cIndex - 0);
            
            String candidateString;
            //System.out.println(candidateString1 + " " + candidateString2);
            
            if (isFirstBigger(candidateString1, candidateString2)) {
                candidateString = candidateString1;
            } else {
                candidateString = candidateString2;
            }
            
            if (isFirstBigger(candidateString, maxString)) {
                maxString = candidateString;
            }
                        
            cIndex ++;
            if (strIndex.contains(cIndex)){
                sIndex++;
                tempFinal = Arrays.copyOf(finalString, finalString.length);
                innerSIndex = 0;
                while (sIndex < revstrs.length && innerSIndex < revstrs[sIndex].length()) {
                    if (revstrs[sIndex].equals(new String(finalString, cIndex, revstrs[sIndex].length()))) {
                        revstrs[sIndex] = reverse(revstrs[sIndex]);
                    }
                    tempFinal[innerSIndex + cIndex] = revstrs[sIndex].charAt(innerSIndex);
                    innerSIndex++;
                }              
            }
        } 
        
        return maxString.equals(" ") ? "" : maxString;
    }
    
    public boolean isFirstBigger(String a, String b) {
        return a.compareTo(b) > 0;
    }
    
    public String reverse(String originalString) {        
        char[] original = originalString.toCharArray();
        int left = 0;
        int right = original.length - 1;
        while (left < right) {
            char t = original[left];
            original[left] = original[right];
            original[right] = t;
            left++;
            right--;
        }
        return new String(original);
    }
}