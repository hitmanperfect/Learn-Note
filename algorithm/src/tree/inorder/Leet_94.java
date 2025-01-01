package tree.inorder;

import tree.ITraversal;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 二叉树中序遍历
 * */
public class Leet_94 implements ITraversal {
    public List<Integer> doTraversal(TreeNode root) {
	  List<Integer> list = new ArrayList();
	  Stack<TreeNode> stack = new Stack();
	  while(root !=null || !stack.isEmpty()){
		if(root != null){
		    stack.push(root);
		    root = root.left;
		}else{
		    root = stack.pop();
		    list.add(root.val);
		    root = root.right;
		}
	  }
	  return list;
    }
}
