/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the given function
Node is as follows:
class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}*/

//http://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1

class GfG{
	public String serialize(Tree root,ArrayList<Integer> aa) {
		Queue<Tree> queue = new LinkedList<>();
		queue.add(root);
		StringBuilder sBuilder = new StringBuilder();
		while (!queue.isEmpty()) {
			Tree polled = queue.poll();
			sBuilder.append(polled.data + " ");	
			if (polled.data != 0)  {
				if (polled.left == null) {
				queue.add(new Tree(0));
				} else {
					queue.add(polled.left);
				}
				if (polled.right == null) {
					queue.add(new Tree(0));
				} else {
					queue.add(polled.right);
				}	
			}			
		}
		return sBuilder.toString();
	}
	
	public Tree deSerialize(String data) {
		String[] arr = data.split(" ");
		Tree root = new Tree(Integer.parseInt(arr[0]));
		int index = 0;
		int strLen = arr.length;
		Queue<Tree> queue = new LinkedList<>();
		queue.add(root);
		index++;
		while (!queue.isEmpty() && index < arr.length) {
			Tree polled = queue.poll();
			if (Integer.parseInt(arr[index]) != 0) {
				polled.left = new Tree(Integer.parseInt(arr[index]));
				index++;
				queue.add(polled.left);
			} else {
				polled.left = null;
				index++;
			}

			if (Integer.parseInt(arr[index]) != 0) {
				polled.right = new Tree(Integer.parseInt(arr[index]));
				index++;
				queue.add(polled.right);
			} else {
				polled.right = null;
				index++;
			}
		}
		return root;
	}

}