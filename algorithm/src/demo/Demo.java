package demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        int[] res = new Demo().twoSum(new int[]{2,7,11,15},9);
        for (int i :res){
		System.out.println(i);
	  }
//	  System.out.println(Arrays.asList());

    }
    public int[] twoSum(int[] nums, int target) {

	  int[] res = new int[2];
	  HashMap<Integer,Integer> map = new HashMap();
	  for(int i = 0;i< nums.length;i++){
		if (map.containsKey(nums[i])) {

		    res[0] = map.get(nums[i]);
		    res[1] = i;
		    break;
		} else {
		    map.put(target-nums[i],i);
		}
	  }
	  return res;
    }
    public int[] twoSum1(int[] nums, int target) {
	  int[] res = new int[2];     //1.创建一个存放结果的数组res
	  HashMap<Integer,Integer> map = new HashMap<>();     //2.创建一个辅助的哈希表
	  for(int i = 0; i < nums.length; i ++){      //3.遍历
		int tmp = target - nums[i];     //作差
		if(map.containsKey(tmp)){       //判断
		    res[0] = map.get(tmp);
		    res[1] = i;
		    break;
		}
		map.put(nums[i],i);
	  }
	  return res;     //返回
    }

}
