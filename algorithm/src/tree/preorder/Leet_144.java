package tree.preorder;

import tree.ITraversal;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 二叉树前序遍历
 * */
public class Leet_144 implements ITraversal {
    @Override
    public List<Integer> doTraversal(TreeNode root) {
	  Stack<TreeNode> stack = new Stack();
	  List<Integer> out = new ArrayList();
	  if(root == null) return out;

	  while(root != null || !stack.isEmpty()){
		if(root!= null){
		    stack.push(root);
		    out.add(root.val);
		    root = root.left;
		}else{
		    root =  stack.pop().right;
		}
	  }
	  return out;
    }
}
