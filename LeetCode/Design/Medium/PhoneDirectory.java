class PhoneDirectory {

    /*
        A Stack of Numbers using Single LinkedList

        Insert and remove at Head;

    */
    class Node {
        int val;        
        Node next;
        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    Node head;

    public void insert(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public Node remove() {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            Node nodeToBeRemoved = head;
            head = null;
            return nodeToBeRemoved;
        } else {
            Node nodeToBeRemoved = head;
            head = head.next;
            return nodeToBeRemoved; 
        }
    }

    Set<Integer> availablePool;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        availablePool = new HashSet<>();
        for (int i = maxNumbers - 1; i >= 0; i--) {
            availablePool.add(i);
            Node newNode = new Node(i);
            insert(newNode);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Node removedNode = remove();        
        if (removedNode != null) {
            availablePool.remove(removedNode.val);    
        }        
        return removedNode == null ? -1 : removedNode.val;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return availablePool.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (!availablePool.contains(number)) {
            availablePool.add(number);
            Node newNode = new Node(number);
            insert(newNode);    
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */