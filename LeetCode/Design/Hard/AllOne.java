package personal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Krish on 12/19/17.
 */
class AllOne {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		AllOne ao = new AllOne();
		Integer inp = in.nextInt();
		while (inp != 0) {
			switch (inp) {
				case 1:
					String key = in.next();
					ao.inc(key);
					inp = in.nextInt();
					break;
				case 2:
					String dkey = in.next();
					ao.dec(dkey);
					inp = in.nextInt();
					break;
				case 3:
					System.out.println(ao.getMaxKey());
					inp = in.nextInt();
					break;
				case 4:
					System.out.println(ao.getMinKey());
					inp = in.nextInt();
					break;
				default:
					System.out.println("Enter Correct choice");
					inp = in.nextInt();
					break;
			}
		}


	}


	
	/*  Designing Structure like

		VL	<->	VL	<->	VL	<->	VL
		|		|		|		|
		v		v		v		v
		DL		DL		DL		DL
		^		^		^		^
		|		|		|		|
		v		v		v		v
		DL		DL		DL		DL

		A HashMap for ValueListNode(VL) and ListNode(DL)
	*/

	class ValueListNode {
		int val;
		ValueListNode next;
		ValueListNode prev;
		ListNode down;
		public ValueListNode(int val) {
			this.val = val;
		}
	}

	class ListNode {
		String key;
		int val;
		ListNode next;
		ListNode prev;

		public ListNode(String key) {
			this.key = key;
			this.val = 0;
		}

		public void increment() {
			this.val += 1;
		}

		public void decrement() {
			this.val -= 1;
		}
	}

	ValueListNode vHead;
	ValueListNode minValue;
	ValueListNode vTail;
	ValueListNode maxValue;
	Map<Integer, ValueListNode> valueMap;
	Map<String, ListNode> kvMap;



	//ValNode Operations
	//Sending newNode and oldNode which is left of newNode;
	public void insertValueNode(ValueListNode oldNode, ValueListNode newNode, boolean isIncrement) {

		//If Increment add the new node next;
		//If Decrement add the new node prev;

		if (isIncrement) {

			if (oldNode != null) {
				newNode.next = oldNode.next;
			} else {
				newNode.next = vHead;
				if (vHead != null) {
					vHead.prev = newNode;
				}
			}
			newNode.prev = oldNode;
			if (oldNode != null && oldNode.next != null) {
				oldNode.next.prev = newNode;
			}
			if (oldNode != null) {
				oldNode.next = newNode;
			}

			if (oldNode == null) {
				vHead = newNode;
				if (vHead.next == null) {
					vTail = vHead;
				}
			}
			if (oldNode == vTail) {
				vTail = newNode;
			}

		} else {
			if (oldNode != null) {
				newNode.prev = oldNode.prev;
			}
			newNode.next = oldNode;
			if (oldNode != null && oldNode.prev != null) {
				oldNode.prev.next = newNode;
			}
			if (oldNode != null) {
				oldNode.prev = newNode;
			}

			if (oldNode == null) {
				vTail = newNode;
				if (vTail.prev == null) {
					vHead = vTail;
				}
			} else if (oldNode == vHead) {
				if (vHead.prev != null && vHead.prev.val != 0) {
					vHead = vHead.prev;
				}
			}
			if (oldNode == vTail) {
				if (vTail.down == null) {
					vTail = newNode;
				}
			} else if (oldNode == vTail) {
				if (vTail.next != null && vTail.next.val != 0) {
					vTail = vTail.next;
				}

			}
		}

		minValue = vHead;
		maxValue = vTail;
		valueMap.put(newNode.val, newNode);
	}


	public void removeValueNode(ValueListNode node) {
		if (node == null) {
			return;
		}

		if (vHead != null) {
			if (vHead.down == null) {
				vHead = vHead.next;
			}
		}

		if (vTail != null) {
			if (vTail.down == null) {
				vTail = vTail.prev;
			}
		}

		if (node.prev != null ) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}

		node.next = null;
		node.prev = null;

		minValue = vHead;
		maxValue= vTail;
		valueMap.remove(node.val);
	}


	//Double LinkedList Operations
	public void insert(ValueListNode valNode, ListNode node) {
		if (valNode.down == null) {
			valNode.down = node;
		} else {
			node.next = valNode.down;
			valNode.down.prev = node;
			node.prev = null;
			valNode.down = node;
		}
	}


	//Remove current node from List
	public ListNode remove(ValueListNode valNode, ListNode node) {
		//Means Node is head
		if (node.prev == null) {
			valNode.down = node.next;
			if (node.next != null) {
				node.next.prev = null;
			}
			node.next = null;
		} else if (node.next == null) {
			//Means Node is tail
			node.prev.next = null;
			node.prev = null;
		} else {
			//Node is somewhere in the middle
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
		}
		return node;
	}






	/** Initialize your data structure here. */
	public AllOne() {
		vHead = null;
		vTail = null;
		maxValue = vTail;
		minValue = vHead;
		valueMap = new HashMap<>();
		kvMap = new HashMap<>();
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		if (!kvMap.containsKey(key)) {
			ListNode node = new ListNode(key);
			kvMap.put(key, node);
		}
		ListNode nodeToIncrement = kvMap.get(key);
		if (valueMap.containsKey(nodeToIncrement.val)) {
			remove(valueMap.get(nodeToIncrement.val), nodeToIncrement);
		}
		nodeToIncrement.increment();
		if (valueMap.containsKey(nodeToIncrement.val)) {
			insert(valueMap.get(nodeToIncrement.val), nodeToIncrement);
			if (valueMap.get(nodeToIncrement.val).prev != null && valueMap.get(nodeToIncrement.val).prev.down == null) {
				removeValueNode(valueMap.get(nodeToIncrement.val).prev);
			}
		} else {
			ValueListNode prevNode = null;
			if (valueMap.containsKey(nodeToIncrement.val - 1)) {
				prevNode = valueMap.get(nodeToIncrement.val - 1);
			}
			insertValueNode(prevNode, new ValueListNode(nodeToIncrement.val), true);
			insert(valueMap.get(nodeToIncrement.val), nodeToIncrement);
			if (valueMap.get(nodeToIncrement.val).prev != null && valueMap.get(nodeToIncrement.val).prev.down == null) {
				removeValueNode(valueMap.get(nodeToIncrement.val).prev);
			}
		}
		removeValueNode(valueMap.get(0));
		valueMap.remove(0);
	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) {
		if (kvMap.containsKey(key)) {
			ListNode nodeToDecrement = kvMap.get(key);
			if (valueMap.containsKey(nodeToDecrement.val)) {
				remove(valueMap.get(nodeToDecrement.val), nodeToDecrement);
			}
			nodeToDecrement.decrement();
			if (valueMap.containsKey(nodeToDecrement.val)) {
				insert(valueMap.get(nodeToDecrement.val), nodeToDecrement);
				if (valueMap.get(nodeToDecrement.val).next != null && valueMap.get(nodeToDecrement.val).next.down == null) {
					removeValueNode(valueMap.get(nodeToDecrement.val).next);
				}
			} else {
				ValueListNode prevNode = null;
				if (valueMap.containsKey(nodeToDecrement.val + 1)) {
					prevNode = valueMap.get(nodeToDecrement.val + 1);
				}

				insertValueNode(prevNode, new ValueListNode(nodeToDecrement.val), false);
				insert(valueMap.get(nodeToDecrement.val), nodeToDecrement);
				if (valueMap.get(nodeToDecrement.val).next != null && valueMap.get(nodeToDecrement.val).next.down == null) {
					removeValueNode(valueMap.get(nodeToDecrement.val).next);
				}

				if (nodeToDecrement.val == 0) {
					kvMap.remove(nodeToDecrement.key);
				}
			}
			removeValueNode(valueMap.get(0));
			valueMap.remove(0);
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		//System.out.println(valueMap);
		if (maxValue != null && maxValue.down != null)  {
			return maxValue.down.key;
		} else {
			return "";
		}
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		//System.out.println(valueMap);
		if (minValue != null && minValue.down != null)  {
			return minValue.down.key;
		} else {
			return "";
		}
	}
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */