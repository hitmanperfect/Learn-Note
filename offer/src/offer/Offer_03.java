package offer;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *  */
public class Offer_03 {
    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {

	  int index = 0;
	  while (index < nums.length) {
		while (index != nums[index]) {
		    if (nums[index] == nums[nums[index]]) {
			  return nums[index];
		    } else {
			  swap(nums, index, nums[index]);
		    }
		}
		index++;
	  }
	  return -1; //未找到则返回-1
    }

    void swap(int[] nums, int i, int j) {
	  int tmp = nums[i];
	  nums[i] = nums[j];
	  nums[j] = tmp;
    }
}
