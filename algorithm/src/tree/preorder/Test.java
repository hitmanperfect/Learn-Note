package tree.preorder;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
	  if (root == null ) {
	      return list;
	  }
	  while(root != null || !stack.isEmpty()){
		if (root != null) {
		    stack.push(root);
		    list.add(root.val);
		    root = root.left;
		} else {
		    root = stack.pop().right;
		}
	  }
	  return list;
    }
}
