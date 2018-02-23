class Solution {
    public int lastRemaining(int n) {
        int currentStart = 1;
        int level = -1;
        int remaining = n;
        
        while (remaining > 1) {
            level++;
            //System.out.println("Start " + currentStart + " Remaining " + remaining + " Level " + level);
            if (level % 2 == 0 || remaining % 2 != 0) {
                currentStart = currentStart + (int) Math.pow(2, level);
            } 
            
            remaining /= 2;
        }
        
        
        return currentStart;
        //return currentStart;
    }
}