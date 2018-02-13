class Solution {
    
    //O(n + k logk) Alg
    
    class KeyVal {
        int key;
        int val;
        public KeyVal(int k, int v) {
            this.key = k;
            this.val = v;
        }        
        public void increment() {
            this.val++;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, KeyVal> map = new HashMap<>();
        List<Integer> topKElements = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).increment();
            } else {
                map.put(nums[i], new KeyVal(nums[i], 1));
            }            
        }
        
        Queue<KeyVal> pQueue = new PriorityQueue<KeyVal>(new Comparator<KeyVal>(){
            public int compare(KeyVal a, KeyVal b) {
                return b.val - a.val;
            }
        });
        
        for (Map.Entry<Integer, KeyVal> entry : map.entrySet()) {
            pQueue.add(entry.getValue());
        }
        
        while (--k >= 0 && !pQueue.isEmpty()) {
            topKElements.add(pQueue.poll().key);
        }
        
        return topKElements;
    }
}