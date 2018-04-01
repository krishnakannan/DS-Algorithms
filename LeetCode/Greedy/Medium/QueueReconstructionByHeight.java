class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        if (people.length == 0 || people[0].length == 0) {
            return people;
        }
        
        int[][] newOrder = new int[people.length][people[0].length];
        
        for (int i = 0; i < newOrder.length; i++) {
            Arrays.fill(newOrder[i], -1);
        }
        
        Arrays.sort(people, new Comparator<int[]>(){
        	public int compare(int[] a, int[] b) {
        		return a[0] - b[0];
        	}
        });

//         for (int i = 0; i < people.length; i++) {
//             System.out.print("[" + people[i][0] + ","+ people[i][1] + "] ");    
//         }
        
        
        for (int i = 0; i < people.length; i++) {
            int h = people[i][0];
            int k = people[i][1];
            int newIndex = 0;
            int kSlotsBefore = k;
            
            while (kSlotsBefore > 0 && newIndex < newOrder.length) {
                if (newOrder[newIndex][0] >= h || newOrder[newIndex][0] == -1) {
                    kSlotsBefore--;
                }
                newIndex++;
            }
            
                        
            while (newOrder[newIndex][0] != -1) {
                newIndex++;
            }
            
            newOrder[newIndex][0] = h;
            newOrder[newIndex][1] = k;
        }
        
        return newOrder;
    }
}