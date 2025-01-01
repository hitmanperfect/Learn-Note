package offer;

import offer.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 
 *
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 * 
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Offer_32_1 {

    /**
     * 普通的 层次打印
     *
     * */
    public int[] levelOrder(TreeNode root) {
	  if (root == null) {
	      return new int[0];
	  }
	  LinkedList<TreeNode> queue = new LinkedList();
	  List<Integer> list = new ArrayList();
	  queue.add(root);
	  while (!queue.isEmpty()){
	      int size = queue.size();
		TreeNode node;
	      while(size-->0){
	          node = queue.poll();
	          list.add(node.val);
		    if (node.left != null) {
		        queue.add(node.left);
		    }
		    if (node.right != null) {
			  queue.add(node.right);
		    }
		}
	  }
	  int size = list.size();
	  int[] res = new int[size];
	  for (int i=0;i<size;i++) {
	      res[i] = list.get(i);
	  }
	  return res;
    }
}
