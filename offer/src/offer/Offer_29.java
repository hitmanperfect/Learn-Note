package offer;

import java.util.Arrays;

public class Offer_29 {
    public int[] spiralOrder(int[][] matrix) {
	  if (matrix == null || matrix.length==0 || matrix[0].length == 0) { return new int[0];
	  }
        int row = matrix.length,colum = matrix[0].length;
        int[] res = new int[row*colum];
        int index = 0;
        int t = 0,l=0,b=row-1,r=colum-1;
	  while (true){
		// 上侧，左到右
		for (int i=l;i<=r;i++) {
		    res[index++]=matrix[t][i];
		}
		if (++t>b) {
		    break;
		}
		// 右侧，上到下
		for (int i=t;i<=b;i++) {
		    res[index++]=matrix[i][r];
		}
		if (--r<l) {
		    break;
		}
		// 底侧，右到左
		for (int i=r;i>=l;i--) {
		    res[index++]=matrix[b][i];
		}
		if (--b<t) {
		    break;
		}
		//  左侧，下到上
		for (int i=b;i>=t;i--) {
		    res[index++]=matrix[i][l];
		}
		if (++l>r) {
		    break;
		}
	  }
	  return res;
    }

    public static void main(String[] args) {
	  Offer_29 test = new Offer_29();
	  int[][] s1 = {
		    {1,2,3,4},
		    {5,6,7,8},{9,10,11,12},

	  };
	  int[][] s2 = {
		    {1,11},
		    {2,12},
		    {3,13},
		    {4,14},
		    {5,15},
		    {6,16},
		    {7,17},
		    {8,18},
		    {9,19},
		    {10,20},
	  };

	  int[] res = test.spiralOrder(s2);
	  System.out.println(Arrays.toString(res));
    }
}
