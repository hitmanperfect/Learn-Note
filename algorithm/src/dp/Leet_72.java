package dp;

/**
 * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 链接：https://leetcode-cn.com/problems/edit-distance
 */
public class Leet_72 {
    public static void main(String[] args) {
	  String s1 = "horse";
	  String s2 = "ros";
	  int res = new Leet_72().minDistance(s1, s2);
	  System.out.println(res);

    }

    public int minDistance(String word1, String word2) {

	  if (word1 == null && word2 == null) {

		return 0; // or throw new Exception("invalid input");
	  }
	  if (word1 == null) {
		return word2.length();
	  }
	  if (word2 == null) {
		return word1.length();
	  }
	  int m = word1.length();
	  int n = word2.length();
	  int[][] dp = new int[m + 1][n + 1];
	  for (int i = 0; i <= m; i++) {
		dp[i][0] = i;
	  }
	  for (int j = 0; j <= n; j++) {
		dp[0][j] = j;
	  }
	  for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
		    //为什么是i-1,而不是i，当i为m时，字符串会溢出，
		    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
			  dp[i][j] = dp[i - 1][j - 1];
		    } else {
			  dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
		    }
		}
	  }
//	  for (int i=0;i<=m;i++) {
//		System.out.println(Arrays.toString(dp[i]));
//	  }
	  return dp[m][n];
    }

    int min(int x, int y, int z) {
	  return Math.min(x, Math.min(y, z));
    }
}
