package jjava.reflect;

import java.lang.reflect.Field;

public class TestString {
    final String s1 = "s1" + "before";
    final String s2 = TestString.class.getCanonicalName();
    final String s3 = null;
    public static void main(String[] args) {
	  try{
		TestString test = new TestString();
		Field fieldS1 = TestString.class.getDeclaredField("s1");
		fieldS1.setAccessible(true);
		fieldS1.set(test,"s1 after");
		System.out.println("fieldS1 reflect get : " + fieldS1.get(test));
		System.out.println("fieldS1 direct  get : " + test.s1);

		Field fieldS2 = TestString.class.getDeclaredField("s2");
		fieldS2.setAccessible(true);
		fieldS2.set(test,"s2 after");
		System.out.println("fieldS2 reflect get : " + fieldS2.get(test));
		System.out.println("fieldS2 direct  get : " + test.s2);

		Field fieldS3 = TestString.class.getDeclaredField("s3");
		fieldS3.setAccessible(true);
		fieldS3.set(test,"s3 after");
		System.out.println("fieldS1 reflect get : " + fieldS3.get(test));
		System.out.println("fieldS1 direct  get : " + test.s3);
	  }catch (Exception e){

	  }
    }
}
