package math;

/**
 * 对于一个正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * <p>
 * 给定一个整数n，如果是完美数，返回 true，否则返回 false
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 示例 2：
 * <p>
 * 输入：num = 6
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：num = 496
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：num = 8128
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：num = 2
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 108
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet_507 {

    public static boolean checkPerfectNumber(int num) {
	  if (num == 1) {
		return false;
	  }
	  int sum = 1;
	  int i;
	  for (i = 2; i * i < num; ++i) {
		if (num % i == 0) {
		    sum += i;
		    sum += num / i;
		}
	  }
	  if (i * i == num) {
		sum += i;
	  }
	  return sum == num;
    }

    public static void main(String[] args) {
	  System.out.println(checkPerfectNumber(2));
	  System.out.println(checkPerfectNumber(6));
	  System.out.println(checkPerfectNumber(28));
	  System.out.println(checkPerfectNumber(100));
	  System.out.println(checkPerfectNumber(496));

    }
}
