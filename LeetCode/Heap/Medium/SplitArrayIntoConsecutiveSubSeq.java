class Solution {
    
    class Sequence {
        int last;
        int count;
        public Sequence(int last, int count) {
            this.last = last;
            this.count = count;
        }
    }
    
    public boolean isPossible(int[] nums) {            
        
        Queue<Sequence> pQueue = new PriorityQueue<>(new Comparator<Sequence>(){
            public int compare(Sequence a, Sequence b) {
                if (a.last == b.last) {
                    return a.count - b.count;
                }
                return a.last - b.last;
                
            }
        });
        
        
        
        for (int i : nums) {
            if (pQueue.isEmpty() || pQueue.peek().last == i) {
                pQueue.add(new Sequence(i, 1));
            } else {
                while(!pQueue.isEmpty() && i > pQueue.peek().last + 1) {
                    if (pQueue.poll().count < 3) {
                        return false;  
                    } 
                }
                if (pQueue.isEmpty()) {
                    pQueue.add(new Sequence(i, 1));
                }
                else{
                    Sequence top = pQueue.poll();
                    top.last = i;
                    top.count++;
                    pQueue.add(top);
                }
            }
        }

        while (!pQueue.isEmpty()) {            
            if (pQueue.poll().count < 3) {
                return false;
            }
        }

        return true;
    }
}