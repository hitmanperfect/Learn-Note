package offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * <p>
 * 给定target=20，返回false。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 **/

// 思路：左上和右下斜对角的方式，复杂度太高，单一节点需要处理临近的3个点（右1，下一，又下一），
// 所以从左上，右下处理该问题思路是错的，根据题目提点，右边的肯定大于左边的，
// 下边的肯定大于上边的，可以考虑从右上或者左下角突进
// 教训:善于抓住题目特点，利用矩形的四个角，

public class Offer_04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
	  if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return false;
	  }
	  int left = 0, top = 0;
	  int right = matrix[0].length - 1;
	  int bottom = matrix.length - 1;
	  while (left<=right && top<=bottom) {
		if (matrix[top][right] == target) {
		    return true;
		} else if (matrix[top][right] > target) {
		    right--;
		} else {
		    top++;
		}
	  }
	  return false;
    }

    public static void main(String[] args) {
	  int[][] matrix = {
		    {1,  4,  7,  11, 15},
		    {2,  5,  8,  12, 19},
		    {3,  6,  9,  16, 22},
		    {10, 13, 14, 17, 24},
		    {18, 21, 23, 26, 30}

	  };
	  int target = 20;
	  boolean res = new Offer_04().findNumberIn2DArray(matrix,target);
	  System.out.println(res);
    }
}
