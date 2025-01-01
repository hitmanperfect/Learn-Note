package jjava.inner_class;

public class Out {
    private  int alpha = 2;
    public Out(int initialValue) {
	  alpha = initialValue;
    }

    public class Beta {
	  public int doubleAlpha() {
		return 2 * alpha;
	  }
    }
}
