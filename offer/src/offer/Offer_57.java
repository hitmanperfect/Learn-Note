package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i]<= 10^6
 */
public class Offer_57 {
    public static void main(String[] args) {
	  int[] nums = {2,7,11,15};
	  int  target = 9;
	  int[] res = new Offer_57().twoSum(nums,target);
	  System.out.println(Arrays.toString(res));
    }
    public int[] twoSum(int[] nums, int target) {
	  int[] res = new int[2];
	  res[0] = res[1] = -1;
	  if (nums == null || nums.length < 2) {
		return res;
	  }
	  Map<Integer,Integer> map = new HashMap<>();
	  for (int i =0;i<nums.length;i++) {
		if (map.containsKey(nums[i])) {
		    res[0] = nums[i];
		    res[1] = nums[map.get(nums[i])];
		    return res;
		} else {
		    map.put(target-nums[i],i);
		}
	  }
	  return res;
    }
}
