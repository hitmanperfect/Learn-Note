package offer;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Offer_10_1 {

    /**
     * 注意事项
     * 1、累加之后可能会超出 Integer.MAX_VALUE, 此时将返回负数，负数累加将会导致结果不正确，
     * 	所以原题有个取模的逻辑
     * 2、
     * */
    public int fib(int n) {
	  if (n == 0) {
		return 0;
	  } else if (n == 1) {
		return 1;
	  }
	  int[] res = new int[n+1];
	  res[0] = 0;
	  res[1] = 1;
	  int index = 2;
	  while (index <= n) {
	      res[index] = (res[index-1] + res[index-2])%1000000007;
	      index++;
	  }
	  return res[n];
    }

    public static void main(String[] args) {
	  Offer_10_1 t = new Offer_10_1();
	  System.out.println(t.fib(50));
	  System.out.println(t.fib(45));
    }
}
