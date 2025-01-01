package algoriphem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Sort1 {
    public void quickSort(int[] source, int low, int high) {
	  if (low < high) {
		int pos = Partition(source, low, high);
		quickSort(source, low, pos - 1);
		quickSort(source, pos + 1, high);
	  }
    }

    private int Partition(int[] source, int low, int high) {
	  int temp = source[low];
	  while (low < high) {
		while (low < high && source[high] >= temp) high--; //一定要是大于等于，否则死循环！！！
		source[low] = source[high];
		while (low < high && source[low] <= temp) low++;
		source[high] = source[low];
	  }
	  source[low] = temp;
	  return low;
    }

    public static void main(String[] args) {
	  // TODO Auto-generated method stub
	  int[] a = {2, 3, 1, 4, 2};
	  Sort1 qsort = new Sort1();
//	  qsort.quickSort(a, 0, a.length - 1);
//	  for (int i = 0; i < a.length; i++) {
//		System.out.print(a[i] + " ");
//	  }

	  int[] nums = new int[]{2, 3, 1, 5, 6, 4};
	  int res = qsort.findKthLargest(nums, 4);
	  System.out.println("res is " + res);

    }

    public int findKthLargest1(int[] nums, int k) {
	  int l = 0, r = nums.length - 1;
	  int index = partion(nums, l, r);
	  while (index != k - 1) {
		if (index > k - 1) {
		    r = index - 1;
		} else {
		    l = index + 1;
		}
		index = partion(nums, l, r);
	  }
	  return nums[index];
    }

    public int findKthLargest(int[] nums, int k) {
	  int left = 0, right = nums.length - 1;
	  int index = partion(nums, left, right);
	  while (index != k - 1) {
		if (index > k - 1) {
		    right = index - 1;
		} else {
		    left = index + 1;
		}
		index = partion(nums, left, right);
	  }
	  return nums[index];
    }
    public int partion(int[] a, int left, int right) {
	  int stub = a[left];
	  while (left < right) {
		while (left < right && a[right] <= stub) {
		    right--;
		}
		a[left] = a[right];
		while (left < right && a[left] >= stub) {
		    left++;
		}
		a[right] = a[left];
	  }
	  a[left] = stub;
	  return left;
    }

    public int subarraySum(int[] nums, int k) {
	  int preSum = 0;
	  int count = 0;
	  HashMap<Integer, Integer> map = new HashMap();
	  map.put(0, 1);
	  for (int i = 0; i < nums.length; i++) {
		preSum += nums[i];
		if (map.containsKey(preSum - k)) {
		    count += map.get(preSum - k);
		}
		map.put(preSum, map.getOrDefault(preSum, 0) + 1);
	  }
	  return count;
    }

    public int partion1(int[] a, int l, int r) {
	  int stub = a[l];
	  while (l < r) {
		while (l < r && a[r] >= stub) {
		    r--;
		}
		a[l] = a[r];
		while (l < r && a[l] <= stub) {
		    l++;
		}
		a[r] = a[l];
	  }
	  a[l] = stub;
	  return l;
    }
}
