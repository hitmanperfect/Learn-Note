package jjava.classloader;

import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 自定义 clsLoader 加载 从class 最有效方式就是换个路径存放 class 文件
 */
public class LoadClassTest {
    /**
     * 运行结果和 当前目录有没有 A.java 有关系
     * 当前默认类加载器是 AppClassLoader,其 usr_paths 包含了当前路径，“.”,
     * 也就是“/Users/lzq/IdeaProjects/java_01”，
     * ，能找到 jjava.classloader.A 这个类，所以即使把A 的class文件放到其他部位，也不会加载class文件
     * 把A.java 删除即可用 自定义类加载器加载，原因见 PathTest
     * <p>
     * --------include A-----------
     * /Users/lzq/IdeaProjects/java_01
     * classLoader :sun.misc.Launcher$AppClassLoader@135fbaa4
     * classLoader :sun.misc.Launcher$AppClassLoader@135fbaa4
     * class jjava.classloader.A
     * sun.misc.Launcher$AppClassLoader@135fbaa4
     * <p>
     * <p>
     * -------not include A----------
     * MyClassLoader1load jjava.classloader.A
     * classLoader :jjava.classloader.MyClassLoader1@355da254
     * MyClassLoader1load jjava.classloader.B
     * classLoader :jjava.classloader.MyClassLoader1@355da254
     * class jjava.classloader.A
     * jjava.classloader.MyClassLoader1@355da254
     */
    public static void main(String[] args) {
	  try {
		ReferenceQueue queue = new ReferenceQueue();
		ReferenceQueue queueClass = new ReferenceQueue();
		WeakReference<ClassLoader> weakCL = new WeakReference<ClassLoader>(
			  new MyClassLoader1("/Users/lzq/Desktop"),queue);
		System.out.println("WR : " + weakCL);
		System.out.println("CL: "+weakCL.get());
		WeakReference<Class> weakACls = new WeakReference<Class>(
			  weakCL.get().loadClass("jjava.classloader.A"),queueClass);
//		WeakReference<Class> weakACls = new WeakReference<Class>(
//			  A.class,queueClass);

		weakACls.get().newInstance();
		System.gc();
		TimeUnit.SECONDS.sleep(5);
		System.out.println(queue.poll());
		System.out.println(queueClass.poll());
	  } catch (Exception e) {
		e.printStackTrace();
	  }
    }
}
