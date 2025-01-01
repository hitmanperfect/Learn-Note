package tree.zlevelorder;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZLevel {
    public List<List<Integer>> doTraversal(TreeNode root) {
	  List<List<Integer>> res = new ArrayList();
	  Deque<TreeNode> queue = new LinkedList();
	  if(root == null) return res;
	  queue.add(root);
	  boolean pollFromTail = false;
	  while(!queue.isEmpty()){

		List<Integer> list = new ArrayList();
		int size = queue.size();
		while(size > 0){
		    if(pollFromTail){
			  TreeNode node = queue.pollLast();
			  list.add(node.val);
			  size--;
			  if(node.right != null){
				queue.addFirst(node.right);
			  }
			  if(node.left != null){
				queue.addFirst(node.left);
			  }
		    }else{
			  size--;
			  TreeNode node = queue.pollFirst();
			  list.add(node.val);
			  if(node.left != null){
				queue.add(node.left);
			  }
			  if(node.right != null){
				queue.addLast(node.right);
			  }
		    }
		}
		res.add(list);
		pollFromTail = !pollFromTail;
	  }
	  return res;
    }
}
