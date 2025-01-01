package jjava.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestFinal {
    static final Integer a = 9;
    public static void main(String[] args) {
	  Class cls = TestFinal.class;
	  try {
		Field field = cls.getDeclaredField("a");
		field.setAccessible(true);
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		field.set(null,8);
		System.out.println(TestFinal.a);

	  } catch (Exception e) {
		System.out.println(e);
	  }
    }

    static class Inner{
        String name;

	  public Inner(String name) {
		this.name = name;
	  }
    }

}
