package offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * 
 *
 * 提示：
 *
 * 1 <=arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Offer_42 {

    /**
     *
     * 笨方法：[start,end] 2层循环遍历取最大值，
     * 思路：
     * 1、
     * 2、1层循环，从第二个节点开始，做end，由于是连续数组，可以根据前面的累计值，确定是否用之前的结果。
     * >0 则用，小于则放弃
     *
     * */
    public int maxSubArray(int[] nums) {
	  if (nums == null || nums.length == 0) {
	      return 0;
	  }
	  int res = nums[0];
	  for (int i = 1;i<nums.length;i++) {
	      nums[i] += Math.max(nums[i-1],0);
	      res = Math.max(res,nums[i]);
	  }
	  return res;
    }

    public static void main(String[] args) {
	  Offer_42 tset = new Offer_42();
	  int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
	  int res = tset.maxSubArray(arr);
	  System.out.println(res);
    }
}
