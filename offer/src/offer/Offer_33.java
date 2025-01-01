package offer;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Offer_33 {

    /**
     * 1、不合理输入，如 空数组，返回true
     * 2、递归终止条件： l>=r 时，说明子节点数量 <= 1, 返回true 即可
     * */
    public boolean verifyPostorder(int[] postorder) {
	  if (postorder == null || postorder.length == 0) { return false;
	  }
	  int l = 0,r = postorder.length-1;
	  return verifyPostorder(postorder,l,r);

    }
    public boolean verifyPostorder(int[] postorder,int l,int r) {
	  if (l>=r) { return false;
	  }
	  int last = postorder[r];
	  int index = l;
	  while (postorder[index]<last && index <=r){
	      index++;
	  }
	  int mid = index;
	  while (postorder[index] >=last && index<=r){
	      index++;
	  }
	  if (index<r) {
	      return false;
	  }
	  return verifyPostorder(postorder,l,mid-1) && verifyPostorder(postorder,mid,r-1);

    }
}
