package tree.postorder;

import tree.ITraversal;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Post2 implements ITraversal {
    @Override
    public List<Integer> doTraversal(TreeNode root) {
	  Stack<TreeNode> stack = new Stack();
	  LinkedList<Integer> out = new LinkedList();
	  if (root == null) {
		return out;
	  }
	  stack.push(root);
	  while (!stack.isEmpty()) {
		root = stack.pop();
		out.addFirst(root.val);
		if (root.left != null) {
		    stack.push(root.left);
		}
		if (root.right != null) {
		    stack.push(root.right);
		}
	  }
	  return out;
    }
}
