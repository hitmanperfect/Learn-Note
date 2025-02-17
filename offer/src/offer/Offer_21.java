package offer;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Offer_21 {

    /**
     * 双指针， 左边找第一个偶数，右边找第一个奇数
     * */
    public int[] exchange(int[] nums) {
	  if (nums == null || nums.length == 0) { return nums;
	  }
	  int l = 0,r = nums.length-1;
	  while(l<r){
	      while (l<r && (nums[l] & 1 )==1){
			l++;
		}
	      while (l<r && (nums[r] &1) ==0){
	          r--;
		}
	      swap(nums,l,r);
	  }
	return nums;
    }
    void swap(int[] a,int i,int j) {
        int tmp = a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    public static void main(String[] args) {
	  Offer_21 test = new Offer_21();
	  int[] a = {1,2,3,4};
	  System.out.println(Arrays.toString(test.exchange(a)));
    }
}
