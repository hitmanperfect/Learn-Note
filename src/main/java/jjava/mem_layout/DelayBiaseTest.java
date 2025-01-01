package jjava.mem_layout;

import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

public class DelayBiaseTest {
    private static Instrumentation inst;
//    private final static Unsafe UNSAFE;
//
//    // 只能通过反射获取Unsafe对象的实例
//    static {
//	  try {
//		Field f = Unsafe.class.getDeclaredField("theUnsafe");
//		f.setAccessible(true);
//		UNSAFE = (Unsafe) f.get(null);
//	  } catch (Exception e) {
//		e.printStackTrace();
//		throw new Error();
//	  }
//    }
//
//    public static void premain(String agentArgs, Instrumentation instP) {
//	  inst = instP;
//    }
//
//    public static long sizeOf(Object obj) {
//	  return inst.getObjectSize(obj);
//    }

    public static void main(String[] args) {
//	  Field[] fields = B.class.getDeclaredFields();
//	  for (Field field : fields) {
//		System.out.println(field.getName() + "---offSet:" + UNSAFE.objectFieldOffset(field));
//	  }
	  System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
	  try {
		TimeUnit.SECONDS.sleep(5);
	  } catch (Exception e) {

	  }
	  Object o = new Object();
	  System.out.println(ClassLayout.parseInstance(o).toPrintable());
	  int has = o.hashCode();
	  System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}

class A {
   boolean b1;
   boolean b2;
}

class B extends A {
    byte b;
}

class C extends B {
    byte c;
}