package offer;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * <p>
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 */
public class Offer_17_Web {
    /**
     * 注意点：
     * 1、如何表示大整数，字符数组 or int 数组
     * 2、如何控制循环次数，数组大小 为 n +1，判断最高位即可
     * 3、注意，此题返回的是int 数组，数组的length 类型为 int, 且本身为int，即永远不会越界，
     * 不用考虑大数情况，用循环次数控制即可，
     * 4、从1打印，可以可以从1开始
     * */
    public int[] printNumbers(int n) {
	  int total = (int) Math.pow(10, n);
	  int[] res = new int[total-1];
	  for (int i = 0; i < total-1; i++) {
		res[n]=n+1;
	  }
	  return res;
    }

    public static void main(String[] args) {
        int[] res = new Offer_17_Web().printNumbers(2);
	  System.out.println(Arrays.toString(res));;
//	  System.out.println(Integer.MAX_VALUE);
//	  System.out.println(Math.pow(10,10) - Integer.MAX_VALUE);
    }
}
