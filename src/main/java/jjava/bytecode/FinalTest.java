package jjava.bytecode;

public class FinalTest {
    static transient final int a = 3;//此处禁止编译

    public static void main(String[] args) {
	  System.out.println(new FinalTest().getClass(String.class).getClass());

    }

    public static <T> T getType(T t){
        return null;
    }

    public static <T> T getClass(Class<T> c){
	  try {
		T t = c.newInstance();
		return t;
	  } catch (Exception e) {
	      e.printStackTrace();
	      return null;
	  }
    }
}
