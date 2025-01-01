package jjava.dynamicProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
	  IDoSth ins = new DoSth();
	  IDoSth proxy = (IDoSth) Proxy.newProxyInstance(Test.class.getClassLoader(), ins.getClass().getInterfaces(), new InvocationHandler() {
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		    System.out.println("proxyClass : "+proxy.getClass());
		    long start = System.currentTimeMillis();
		    Object res = method.invoke(ins, args);
		    System.out.println("method: " + method.getName() + " costTime : "
				+ (System.currentTimeMillis() - start));
		    return res;
		}
	  });
	  proxy.doSth("做饭");
	  System.out.println(proxy.getClass());
	  System.out.println(proxy.getClass().getSuperclass());
	  for (Class cls : proxy.getClass().getInterfaces()) {
		System.out.println(cls);
	  }

//	  byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", ins.getClass().getInterfaces());
//	  String path = "/Users/lzq/IdeaProjects/java_01/src/jjava/dynamicProxy/$Proxy0.class";
//	  try (FileOutputStream fos = new FileOutputStream(path)) {
//		fos.write(classFile);
//		fos.flush();
//		System.out.println("代理类class文件写入成功");
//	  } catch (Exception e) {
//		System.out.println("写文件错误");
//	  }
//	  System.out.println(cls1.getPackage());
//	  Object


//	  cls1.newInstance()
    }
}
