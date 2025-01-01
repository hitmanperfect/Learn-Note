package jjava.bytecode;

public class IncTest {
    static int i = 0;
    static void i_plus() {
	  i = i++;
    }
    public static void main(String[] args) {
	  new Thread(new Runnable() {
		int count = 0;
		@Override
		public void run() {
		    while (true) {
			  if (i == 1) {
				System.out.println("i = " + i + ",final count = " + ++count);
				Runtime.getRuntime().exit(0);
			  } else {
				System.out.println("count = " + ++count);
			  }
		    }
		}
	  }).start();
	  while (true) {
		i_plus();
	  }
    }

    void plus_i() {
	  ++i;
    }

    static int xxx() {
	  int j = 0;
	  try {
		return 1;
	  } finally {
		return 2;
	  }
    }

    void local_i_plus() {
	  int i = 0;
	  i = i++;
    }

    void local_plus_i() {
	  int i = 0;
	  i = ++i;
    }

    int k = 0;

    void yyy() {
	  k++;
	  ++k;
    }
}
