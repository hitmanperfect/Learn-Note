package tree.postorder;

import tree.ITraversal;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Post1 implements ITraversal {

    @Override
    public List<Integer> doTraversal(TreeNode root) {
	  Stack<TreeNode> stack = new Stack();
	  LinkedList<Integer> out = new LinkedList();
	  if(root == null){
		return out;
	  }
	  while(root != null || !stack.isEmpty()){
		if(root != null){
		    stack.push(root);
		    out.addFirst(root.val);
		    root = root.right;
		}else{
		    TreeNode node = stack.pop();
		    root = node.left;
		}
	  }
	  return out;
    }
}


