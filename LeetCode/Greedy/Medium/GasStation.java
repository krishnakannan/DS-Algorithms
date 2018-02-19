class Solution {

	/*
		Based on the fact that if a car cannot reach from A -> Z
		It cannot reach Z from any starting point between A and Z;
	*/

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        
        for (int start = 0; start < gas.length; start++) {
            int tank = 0;
            int count = 0;
            int trav = start;
            int nextSuitable = start;
            while (count <= length) {
                tank += gas[trav];
                //System.out.println("I am at " + trav + " I currnetly have " + tank + " I need to spend " + cost[trav]);
                if (tank >= cost[trav]) {
                    tank -= cost[trav];
                    trav++;
                    trav = trav % length;
                    count++;                    
                } else {                    
                    break;
                }                
            }            
            if (count - 1 == length) {             
                return start;
            }
            start = trav > start ? trav - 1 : start;
        }
        return -1;
        
    }
}