package jjava.tmp;

/**
 * ****  思路  ***
 * 1、记录已经计算过的丑数，用数组保存，如何更新数组值
 * 2、记录当下 index2 * 2，index3 * 3，index5 * 5 后大于最后一个丑数的索引值，如何更新索引值？
 * */
public class Test {
    static int get(int index) {
	  if (index <=0) {
	      return 0;
	  }
        int[] arr = new int[index];
	  arr[0] = 1;
	  int next2Index = 0;
	  int next3Index = 0;
	  int next5Index = 0;
	  int nextIndex = 1;
	  while (nextIndex < index) {
	      int min = min(arr[next2Index]*2,arr[next3Index]*3,arr[next5Index]*5);
		System.out.println( " min = " + min + ", nextIndex = " + nextIndex);
	      arr[nextIndex] = min;
		while (arr[next2Index] * 2 <= min) {
		    next2Index++;
		}
		while (arr[next3Index] * 3 <= min) {
		    next3Index++;
		}
		while (arr[next5Index] * 5 <= min) {
		    next5Index++;
		}
		nextIndex++;
	  }
	  return arr[index-1];
    }

    static int min(int a,int b,int c) {
        return Math.min(Math.min(a,b),c);
    }

    public static void main(String[] args) {
	  System.out.println(get(5));
//	  int[] arr = new int[3];
//	  for (int i:arr) {
//		System.out.println(i);
//	  }
    }
}
