/**
 * Created by Krish on 1/7/18.
 */
import java.util.*;
import java.lang.*;

//LFU Cache O(1) implementation

class LFUCache {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter capacity");
        int capacity = in.nextInt();
        LFUCache obj = new LFUCache(capacity);
        String command = in.next();
        while (!command.equals("exit")) {
            int key;
            switch (command) {
                case "get" :
                    key = in.nextInt();
                    System.out.println(obj.get(key));
                    command = in.next();
                    break;
                case "put" :
                    key = in.nextInt();
                    int value = in.nextInt();
                    obj.put(key, value);
                    command = in.next();
                    break;
                default :
                    System.out.println("Enter proper command");
                    command = in.next();
                    break;
            }
        }
    }


    class ListNode {
        int key;
        int val;
        int freq;
        ListNode next;
        ListNode prev;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class FListNode {
        int freq;
        FListNode next;
        FListNode prev;
        ListNode head;
        ListNode tail;
        public FListNode(int key) {
            this.freq = key;
        }
    }


    Map<Integer, ListNode> cacheMap;
    Map<Integer, FListNode> frequencyMap;
    FListNode fHead;
    FListNode fTail;
    int capacity;



    public LFUCache (int capacity) {
        cacheMap = new HashMap<>();
        frequencyMap = new HashMap<>();
        this.capacity = capacity;
        fHead = null;
        fTail = null;
    }

    public int get(int key) {
        ListNode node = processGet(key);
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        ListNode node = processPut(key, value);
    }


    //Idea is to maintain the highest frequency at head and lowest frequency at tail;
    //Each List will have its least recently used at its head and node to be evicted at tail;


    public ListNode processGet(int key) {
        if (isAlreadyPresent(key)) {
            ListNode node = removeCurrentListNode(cacheMap.get(key), cacheMap.get(key).freq);
            node.freq += 1;
            insertCurrentListNode(node, node.freq);
            updateFList(frequencyMap.get(node.freq - 1));
            return node;
        } else {
            return null;
        }
    }

    public ListNode processPut(int key, int val) {
        ListNode node = null;
        if (isAlreadyPresent(key)) {
            cacheMap.get(key).freq += 1;
            cacheMap.get(key).val = val;
            node = removeCurrentListNode(cacheMap.get(key), cacheMap.get(key).freq - 1);
        } else {
            node = new ListNode(key, val);
            if (!isValidToInsert()) {
                evict();
            }
            cacheMap.put(key, node);
        }
        insertCurrentListNode(node, node.freq);
        updateFList(frequencyMap.get(node.freq - 1));
        if (!isValidSize()) {
            evict();
        }
        return node;
    }

    public ListNode removeCurrentListNode(ListNode node, int freq) {
        FListNode fListNode = frequencyMap.get(freq);
        if (fListNode != null && fListNode.head == node && fListNode.tail == node) {
            fListNode.head = null;
            fListNode.tail = null;
        } else if (fListNode != null && fListNode.head == node) {
            fListNode.head =  fListNode.head.prev;
        } else if (fListNode != null && fListNode.tail == node) {
            fListNode.tail =  fListNode.tail.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        node.next = null;
        node.prev = null;
        return node;
    }

    public void insertCurrentListNode(ListNode node, int freq) {
        FListNode fListNode = null;
        FListNode prev = frequencyMap.get(freq - 1);
        if (isFrequencyPresent(freq)) {
            fListNode = frequencyMap.get(freq);
            if (fListNode.head != null) {
                fListNode.head.next = node;
            }
            node.prev = fListNode.head;
            fListNode.head = node;
        } else {
            fListNode = new FListNode(freq);
            frequencyMap.put(freq, fListNode);
            fListNode.head = node;
            fListNode.tail = node;
            if (fHead == null && fTail == null && prev == null) {
                fHead = fListNode;
                fTail = fListNode;
            } else if (prev == fHead) {
                prev.next = fListNode;
                fListNode.prev = prev;
                fHead = fListNode;
            } else if (prev == null) {
                fListNode.next = fTail;
                fTail.prev = fListNode;
                fTail = fListNode;
            } else {
                fListNode.next = prev.next;
                fListNode.prev = prev;
                if (fListNode.next != null) {
                    fListNode.next.prev = fListNode;
                }
                prev.next = fListNode;
            }
        }
    }

    public void updateFList(FListNode fListNode) {
        //Remove FListNode
        if (fListNode != null && fListNode.tail == null) {

            if (fListNode == fTail) {
                fTail = fTail.next;
            }

            if (fListNode == fHead) {
                fHead = fHead.prev;
            }

            if (fListNode != null && fListNode.next != null) {
                fListNode.next.prev = fListNode.prev;
            }
            if (fListNode != null && fListNode.prev != null) {
                fListNode.prev.next = fListNode.next;
            }
            fListNode.next = null;
            fListNode.prev = null;
            frequencyMap.remove(fListNode.freq);
        }
    }



    public void evict() {
        if (fTail != null) {
            ListNode nodeToEvict = fTail.tail;
            if (nodeToEvict != null) {
                cacheMap.remove(nodeToEvict.key);
                if (fTail.tail == fTail.head) {
                    fTail.head = null;
                }
                fTail.tail = nodeToEvict.next;
                if (fTail.tail != null && fTail.tail.prev != null) {
                    fTail.tail.prev = null;
                }
                updateFList(fTail);
            }
        }
    }

    public boolean isAlreadyPresent(int key) {
        return cacheMap.containsKey(key);
    }

    public boolean isFrequencyPresent(int frequency) {
        return frequencyMap.containsKey(frequency);
    }

    public boolean isValidToInsert() {
        return cacheMap.size() < capacity;
    }

    public boolean isValidSize() {
        return cacheMap.size() <= capacity;
    }

}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */