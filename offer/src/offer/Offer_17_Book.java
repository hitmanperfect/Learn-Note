package offer;

/**
 * web 的要求返回 int[] ,即不用考虑大数越界的问题
 * 本地为书上的解法，将所有大数打印
 * */
public class Offer_17_Book {
    public void printNumbers(int n) {
        int[] arr = new int[n+1];
        while(arr[0]!=1){
            print(arr);
            increase(arr);
	  }
    }
    void increase(int[] a){
        int l = a.length;
        int index = l-1;
        while (a[index] == 9){
            a[index--]=0;
	  }
	  a[index]++;
    }
    void print(int[] a){
        boolean printZero = false;
        for(int i=0;i<a.length;i++){
		if (a[i] == 0 && !printZero) {
		    continue;
		} else {
		    printZero = true;
		    System.out.print(a[i]);
		}
	  }
	  if (!printZero) {
		System.out.print(0);
	  }
	  System.out.println();
    }

    public static void main(String[] args) {
	  Offer_17_Book test = new Offer_17_Book();
	  test.printNumbers(2);
    }
}
