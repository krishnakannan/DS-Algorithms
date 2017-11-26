/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/

//http://practice.geeksforgeeks.org/problems/lru-cache/1

/*You are required to complete below class */
class LRUCache {
    
    Queue<KeyValue> LRUQueue = null;
    Integer size;
    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        LRUQueue = new LinkedList<>();
        this.size = N;
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {        
        KeyValue temp = null;
        for (KeyValue kv : LRUQueue) {
            if (kv.k == x) {                
                temp = kv;
                break;
            }
        }        
        if (temp != null) {
            LRUQueue.remove(temp);
            LRUQueue.add(temp);
            return temp.v;
        } else {
            return - 1;
        }
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {                 
        if (get(x) == -1) {
            KeyValue kv = new KeyValue(x, y);
            if (LRUQueue.size() < size) {
                LRUQueue.add(kv);
            } else {
                LRUQueue.poll();
                LRUQueue.add(kv);
            }     
        } else {
            for (KeyValue kv : LRUQueue) {
                if (kv.k == x) {                
                    kv.v = y;
                    break;
                }
            }
        }
    }

    public void printLRUCache() {
        for (KeyValue kv : LRUQueue) {
          System.out.println(kv.k + "->" + kv.v);
        }
        System.out.println();
    }

    class KeyValue {
        public int k;
        public int v;
        public KeyValue(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
}
