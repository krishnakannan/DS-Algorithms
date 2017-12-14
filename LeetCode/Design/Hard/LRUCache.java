class LRUCache {


	//Create a Doubly LinkedList and a Queue over it.
	class ListNode {
        int key;
		int val;
		ListNode prev;
		ListNode next;
		public ListNode(int key, int val) { 
            this.key = key;
			this.val = val;
		}
        
        public void setVal(int val) {
            this.val = val;
        }
	}

	//Necessary DS
	ListNode head;
	ListNode tail;
	Map<Integer, ListNode> cacheMap;
    int capacity;

	//LinkedList Operations - Insert at head, Remove at last, Remove at middle. Print List
	//Q Operation - Insert at Head
	public ListNode add(int key, int val) {
		ListNode newNode = new ListNode(key, val);
		newNode.next = null;
		newNode.prev = null;
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
        cacheMap.put(key, newNode);
		return newNode;
	}

    //Remove CurrentNode from Queue
	public void remove(ListNode node) {
		//Remove at head
		if (node.prev == null) {
			head = head.next;
            if (node.next != null) {
                node.next.prev = null;    
            }			
			node.next = null;
		} else if (node.next == null) {
			//Remove at tail
			tail = tail.prev;
            if (node.prev != null) {
                node.prev.next = null;    
            }			
			node.prev = null;
		} else {            
            // Remove at middle
			node.prev.next = node.next;
			node.next.prev = node.prev;	
            node.next = null;
            node.prev = null;
		}        
	}

	//Q Operation - Remove at Last
	public ListNode poll() {
		ListNode removed = tail;        
		if (removed != null) {
			tail = tail.prev;
			if (removed.prev != null) {
				removed.prev.next = null;
				removed.prev = null;	
			}			
            cacheMap.remove(removed.key);
		}        
        
		return removed;	
	}


    public LRUCache(int capacity) {
        head = null;
        tail = null;
        cacheMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
        if (cacheMap.containsKey(key)) {
            //Get Node remove it and insert it to maintain the LRU order
        	ListNode node = cacheMap.get(key);
        	remove(node);
        	add(node.key, node.val);            
        	return node.val;
        } else {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
    	//There is already value in Queue - change it remove it and insert it. to maintain LRU Order         
        if (cacheMap.containsKey(key)) {        	  
            ListNode node = cacheMap.get(key);
            node.val = value;
        	remove(node);            
        	add(node.key, node.val);            
        } else {
            if (cacheMap.size() < capacity) {
                //Add or Modify value in map/queue
                add(key, value);                                  
            } else {                
                //Add or Modify value in map/queue and poll last element
                add(key, value);                    
                poll();                                          	                                    
            }        	
        }        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */