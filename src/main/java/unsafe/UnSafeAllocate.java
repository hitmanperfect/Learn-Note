package unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class UnSafeAllocate {
    public abstract <T> T newInstance(Class<T> c) throws Exception;

    public static UnSafeAllocate create() {
	  // try JVM
	  // public class Unsafe {
	  //   public Object allocateInstance(Class<?> type);
	  // }
	  try {
		Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
		Field f = unsafeClass.getDeclaredField("theUnsafe");
		f.setAccessible(true);
		final Object unsafe = f.get(null);
		final Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
		return new UnSafeAllocate() {
		    @Override
		    @SuppressWarnings("unchecked")
		    public <T> T newInstance(Class<T> c) throws Exception {
			  assertInstantiable(c);
			  return (T) allocateInstance.invoke(unsafe, c);
		    }
		};
	  } catch (Exception ignored) {
	  }
	  return null;
    }

    static void assertInstantiable(Class<?> c) {
	  int modifiers = c.getModifiers();
	  if (Modifier.isInterface(modifiers)) {
		throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + c.getName());
	  }
	  if (Modifier.isAbstract(modifiers)) {
		throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + c.getName());
	  }
    }
}
