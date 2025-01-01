package jjava.reflect;

import java.lang.reflect.Field;

public class TestInt {
    static final int a = 9;

    public static void main(String[] args) {
	  try{
		TestInt test = new TestInt();
		Field field = TestInt.class.getDeclaredField("a");
		field.setAccessible(true);
		field.setInt(null,8);
		System.out.println("field get" + field.get(test));
		System.out.println(test.a);
	  }catch (Exception e){
		e.printStackTrace();
	  }
    }
}
