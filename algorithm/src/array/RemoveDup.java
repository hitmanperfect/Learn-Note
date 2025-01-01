package array;

/**
 * <b> 有序数组 </b>移除 重复元素
 */
public class RemoveDup {

    public static void main(String[] args) {
//	  int[] a1 = {1, 1, 2, 2, 3};
	  int[] a2 = {0,0,1,1,1,2,2,3,3,4};
//	  System.out.println(removeDuplicates(a1));
	  System.out.println(removeDuplicates(a2));
    }

    public static int removeDuplicates(int[] nums) {
	  if (nums == null || nums.length == 0) return 0;
	  int slow, fast;
	  slow = fast = 0;
	  while (fast < nums.length) {
		if (nums[fast] != nums[slow]) {
		    nums[++slow] = nums[fast];

		}
		fast++;
	  }
	  return slow+1;
    }
}
