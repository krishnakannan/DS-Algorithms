class Solution {
    
    //Using the same algo used for H-Index - there I sorted values and performed here the values are already sorted. But the Algo is Significantly slower than best soln
    
    public int hIndex(int[] citations) {  
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