package offer;

import offer.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 */
public class Offer_35 {
    /**
     * 1、从 根节点 到 叶子节点，必须是叶子节点,即递归的终止条件是， 某个 root 值符合target ，且left 、right 都为 null
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
	  List<List<Integer>> list = new ArrayList<>();
	  Stack<Integer> stack = new Stack<>();
	  if (root == null) return list;
	  pathSum(root, target, stack, list);
	  return list;
    }

    public void pathSum(TreeNode root, int target, Stack stack, List<List<Integer>> res) {
	  if (root == null) {
		return;
	  }
	  stack.push(root.val);
	  if (target == root.val && root.left == null && root.right == null) {
		res.add(new ArrayList<>(stack));
	  }
	  pathSum(root.left, target - root.val, stack, res);
	  pathSum(root.right, target - root.val, stack, res);
	  stack.pop();
    }
}
