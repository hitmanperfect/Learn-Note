package dp;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 *
 * 示例 1：
 *
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 *
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 示例 3：
 *
 * 输入：amount = 10, coins = [10] 
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leet_518 {
    public static void main(String[] args) {
	  int amount = 5;
	  int[]coins = {1, 2, 5};
	  int res = new Leet_518().change(amount, coins);
	  System.out.println(res);
    }
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
	  for (int i:dp) {
	      dp[i] = -1;
	  }
	  return change(amount,coins,dp);


    }
    public int change(int amount, int[] coins,int[] dp) {
//	dp[amount] = 1+
	  return 0;

    }
//    public int getDp(int index,int[] dp) {
//	  if (dp[index] == -1) {
//	      return c
//	  }
//    }

}
