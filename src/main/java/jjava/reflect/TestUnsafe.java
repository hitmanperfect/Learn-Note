package jjava.reflect;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe {
    static final Integer a = 0;

    public static void main(String[] args) throws Exception {
	  Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
	  theUnsafe.setAccessible(true);
	  Unsafe unsafe = (Unsafe) theUnsafe.get(null);
	  Field field = TestUnsafe.class.getDeclaredField("a");
	  long l = unsafe.staticFieldOffset(field);
	  unsafe.getAndSetObject(TestUnsafe.class, l, 123);
	  System.out.println(TestUnsafe.a);
    }
}
