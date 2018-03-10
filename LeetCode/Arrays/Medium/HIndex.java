class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int maxHIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            int numOfPapers = citations.length - i;
            int currentCitations = citations[i];
            int min = min(numOfPapers, currentCitations);                
            //System.out.println("Num of papers equal or greater = " + numOfPapers + " Current Citations " + currentCitations);
            maxHIndex =  maxHIndex > min ? maxHIndex : min;
        }
        
        return maxHIndex;
    }
    
    public int min(int a, int b) {
        return a < b ? a : b;
    }
 }