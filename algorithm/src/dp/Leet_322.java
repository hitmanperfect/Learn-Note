package dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 * */
public class Leet_322 {
    public static void main(String[] args) {
	  int amount = 18;
	  int[]coins = {1, 2, 5};
	  int res = new Leet_322().coinChange( coins,amount);
	  System.out.println(res);
    }
    public int coinChange(int[] coins, int amount) {
	int[] dp = new int[amount+1];
	  for (int i=1;i<=amount;i++) {
	      dp[i] = amount+1;
	  }
	  dp[0] = 0;
//	  System.out.println(Arrays.toString(dp));
	return coinChange(coins,amount,dp);
    }
    public int coinChange(int[] coins, int amount,int[] dp) {
	  for (int i=1;i<=amount;i++) {
		for (int coin:coins) {
		    if (i>=coin) {
			  dp[i] = Math.min(dp[i],dp[i-coin] + 1);
		    }

		}
	  }
	  return dp[amount]  == amount +1 ?-1:dp[amount];
    }
}
