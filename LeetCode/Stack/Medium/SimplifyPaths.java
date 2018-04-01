public class Solution {
    Stack<String> stack = new Stack<>();
    public String simplifyPath(String path) {
        String[] pathArr = path.split("/");
		for (int i = 0; i < pathArr.length; i++) {
			if (pathArr[i].equals(".") || pathArr[i].equals("")) {
				continue;
			} else if (pathArr[i].equals("..")) {
				if (!stack.empty()) {
					stack.pop();
				}
				continue;
			} else {
				stack.push(pathArr[i]);
			}
		}
		String absPath = "";
		while (!stack.empty()) {
			absPath = "/" + stack.pop() + absPath;
		}
		if (absPath == "") {
			absPath = "/";
		}
		return absPath;
    }
}