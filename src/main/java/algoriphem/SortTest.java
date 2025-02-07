package algoriphem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

class A{}
class B extends A{}
public class SortTest {

//	static void addB()
    public static void main(String[] args) {
	  int[] arr = {1,2,3,4,5,6,7,8};
	  int[] arr1 = {2, 3, 4, 1, 2};
	  int[] arr2 = {8, 7, 6, 5, 4, 3, 2, 1};
	  int[] arr3 = {3,2,1,5,6,4};
	  List<A> la= new ArrayList<A>();
	  la.add(new B());

//	  bubbleSort(arr);
//	  bubbleSort(arr2);
//	  selectSort(arr);
//	  selectSort(arr2);
//	  insertSort(arr);
//	  insertSort(arr2);
//	  shellSort(arr);
//	  shellSort(arr2);
	  quickSort(arr);
//	  quickSort(arr1);
//	  quickSort(arr2);
//	  quickSort(arr3);
//	  mergeSort(arr);
//	  mergeSort(arr2);
//	  heapSort(arr);
//	  heapSort(arr2);
	  System.out.println(Arrays.toString(arr));
	  System.out.println(Arrays.toString(arr1));
	  System.out.println(Arrays.toString(arr2));
	  System.out.println(Arrays.toString(arr3));
//	  System.out.println(Integer.MAX_VALUE);
    }

    static void bubbleSort(int[] arr) {
	  int len = arr.length;
	  for (int i = 0; i < len; i++) {
		for (int j = 0; j < len - 1 - i; j++) {
		    if (arr[j] > arr[j + 1]) {
			  swap(arr, j, j + 1);
		    }
		}
	  }
    }

    static void selectSort(int[] arr) {
	  int len = arr.length;
	  for (int i = 0; i < len; i++) {
		int min = i;
		for (int j = i + 1; j < len; j++) {
		    if (arr[min] > arr[j]) {
			  min = j;
		    }
		}
		swap(arr, i, min);
	  }
    }

    /**
     * index为 i 内的元素都是有序的，i递增，
     * 从i开始倒序比较，只要发现a[i] < a[i+1] ,可停止此次循环，后面的a[i-1] 一定小于a[i]
     * */
    static void insertSort(int[] arr) {
	  int len = arr.length;
	  // 整体后移
//	  for (int i = 1; i < len; i++) {
//		int preIndex = i - 1;
//		int cur = arr[i];
//		while (preIndex >= 0 && arr[preIndex] > cur) {
//		    arr[preIndex + 1] = arr[preIndex];
//		    preIndex--;
//		}
//		arr[preIndex + 1] = cur;
//	  }
	  // 逐个交换
	  for (int i = 1; i < len; i++) {
		int preIndex = i - 1;
		while (preIndex >= 0 && arr[preIndex + 1] < arr[preIndex]) {
		    swap(arr, preIndex + 1, preIndex);
		    preIndex--;
		}
	  }
    }

    /**
     * 选择步长。可任意选择，通过一定的缩小规则直到最后为1，
     * 一直交换，没问题 ； 当然也可以像 插入排序那样，先整体后移，再最后赋值。
     */
    static void shellSort(int[] arr) {
	  int len = arr.length;
	  int h = 1;
	  while (h < len / 3) {
		h = h * 3 + 1;
	  }
	  while (h >= 1) {
		for (int i = h; i < len; i++) {
		    for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
			  swap(arr, j, j - h);
		    }
		}
		h = h / 3;
	  }
    }

    static int[] tmp;

    static void mergeSort(int[] arr) {
	  tmp = new int[arr.length];
	  mergeSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr) {
	  quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 堆的特点：
     * 1、以最大堆为例，堆顶元素大于下面所有元素
     * 2、千万不要和二叉树搞混，left < cur < right
     * <p>
     * 边界条件：
     * 1、由于临时数组的大小比 原数组要大1，第一个元素留空，所以用数组的长度 n ，
     * 即n是可达的，代表 tmp 中的最后一个元素，以此类推
     * 2、构建最大堆时，从一半网上开始sink，一半取值为 n/2
     * 3、sink 时，tmp数组不能出界，当2K<n 时，2k+1 <=n,不会出界
     * 4、删除堆最大元素时，首尾交换，首永远为1，尾为 n
     */
    static void heapSort(int[] arr) {
	  int[] tmp = new int[arr.length + 1];
	  int n = arr.length;
	  for (int i = 0; i < arr.length; i++) {
		tmp[i + 1] = arr[i];
	  }
	  //构造最大堆
	  for (int i = n / 2; i >= 1; i--) {
		sink(tmp, i, arr.length);
	  }
	  //逐个删除最大元素，用队尾元素补充，同时缩减堆的大小
	  while (n > 1) {
		swap(tmp, 1, n--);
		sink(tmp, 1, n);
	  }
	  System.arraycopy(tmp, 1, arr, 0, arr.length);
    }

    private static void sink(int[] arr, int k, int n) {
	  while (k * 2 <= n) {
		int max = 2 * k;
		if (max < n && arr[max] < arr[max + 1]) {
		    max++;
		}
		if (arr[k] < arr[max]) {
		    swap(arr, k, max);
		}
		k = max;
	  }
    }

    private boolean flag = true; // 控制线程 A 先执行

    public synchronized void printA() throws InterruptedException {
	  while (!flag) {
		wait(); // 如果线程 A 应该等待，则 wait()
	  }
	  System.out.println("A");
	  flag = false; // 切换标志
	  notifyAll(); // 唤醒等待的线程
    }

    public synchronized void printB() throws InterruptedException {
	  while (flag) {
		wait(); // 如果线程 B 应该等待，则 wait()
	  }
	  System.out.println("B");
	  flag = true; // 切换标志
	  notifyAll(); // 唤醒等待的线程
    }


    /**
     * 使用场景：
     * 1、堆可以用来表示优先队列，队列的api 是 FIFO，队尾插入 队头出
     * 2、队尾插入时，需要找到自己的合适位置。
     * {@link java.util.PriorityQueue}
     * 注意：
     * 这个函数堆排序时，不会用到
     */
    private static void swim(int[] arr, int k) {
	  while (k > 1 && arr[k] > arr[k / 2]) {
		swap(arr, k, k / 2);
		k = k / 2;
	  }
    }

    private static void quickSort(int[] arr, int left, int right) {
	  if (left >= right) {
		return;
	  }
	  int index = partion1(arr, left, right);
	  quickSort(arr, left, index - 1);
	  quickSort(arr, index + 1, right);
    }

    /**
     * 1、以左侧节点，作为切分节点
     * 2、左侧找桩，则从右侧开始找；右侧找桩，则从左侧开始找
     * 3、右侧
     * */
    private static int partion1(int[] arr, int left, int right) {
        //stubIndex的值已取出，索引处的值可以理解为是空的，需要右侧找到比stub小的值来填充
	  int stub = arr[left];

	  while (left < right) {
		while (left < right && arr[right] >= stub) {
		    right--;
		}
		//从右侧找值，填充到left 索引 ,if条件其实是多余的，加上可以减少一次交换，但会多一次比较
		if(left < right) arr[left] = arr[right];
		while (left < right && arr[left] <= stub) {
		    left++;
		}
		//从左侧找值填充到 right 索引处
		if(left < right) arr[right] = arr[left];
	  }
	  arr[left] = stub;
	  return left;
    }

    private static int partion2(int[] a, int start, int end) {
	  int key = a[start];
	  while (end > start) {
		while (end > start && a[end] >= key){
		    end--;
		}

		if (a[end] < key) {
		    swap(a,start,end);
		}
//		System.out.println(Arrays.toString(a) + " , start = " + start + " , end = " + end);
		while (end > start && a[start] <= key)
//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
		    start++;
		if (a[start] > key) {
		    swap(a,start,end);
		}
//		System.out.println(Arrays.toString(a) + " , start = " + start + " , end = " + end);
//此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
	  }
	  return start;
    }

    private static void mergeSort(int[] arr, int left, int right) {
//	  System.out.println("left = " + left + " , right = " + right);
	  if (left >= right) {
//		System.out.println("return");
		return;
	  }
	  int mid = left + (right - left) / 2;
	  mergeSort(arr, left, mid);
	  mergeSort(arr, mid + 1, right);
	  merge(arr, left, mid, right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {
	  for (int i = left; i <= right; i++) {
		tmp[i] = arr[i];
	  }
	  int index = left;
	  int i = left, j = mid + 1;
	  // 注意循环退出的条件：i > m 且 j>right 的条件，
	  while (i <= mid || j <= right) {
		if (i > mid) {
		    arr[index++] = tmp[j++];
		} else if (j > right) {
		    arr[index++] = tmp[i++];
		} else {
		    if (tmp[i] < tmp[j]) {
			  arr[index++] = tmp[i++];
		    } else {
			  arr[index++] = tmp[j++];
		    }
		}
	  }
    }

    private static void swap(int[] arr, int i, int j) {
	  int tmp = arr[i];
	  arr[i] = arr[j];
	  arr[j] = tmp;
    }

}
