package jjava;

public class try_catch {
    int a;
    {
        a = 3;
    }
    boolean get() {
	  try {
		return a == 1;
	  } catch (Exception e) {
		try {
		    return a == 4;
		} catch (Exception e1) {
		    return a==5;
		}finally {
		    return a==6;
		}
	  }finally {
	      return a==2;
	  }

    }
}
