package jjava.bytecode;

public class DCL {
    private static volatile DCL INSTANCE;
    private DCL(){

    }
    public static DCL getInstance(){
	  if (INSTANCE == null) {
	      synchronized (DCL.class){
		    if (INSTANCE == null) {
			  INSTANCE = new DCL();
		    }

		}
	  }
	  return INSTANCE;
    }
}
