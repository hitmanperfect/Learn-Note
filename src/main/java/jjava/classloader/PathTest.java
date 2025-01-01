package jjava.classloader;

import util.Reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;

public class PathTest {
    public static void main(String[] args) {
	  try {
		System.out.println(File.pathSeparator);
		System.out.println(System.getProperty("java.library.path"));
		System.out.println(System.getProperty("sun.boot.library.path"));
		ClassLoader loader = PathTest.class.getClassLoader();
//		System.out.println(loader.getClass().getName());
//		System.out.println(loader.getClass().getSuperclass());
//		System.out.println(loader.getClass().getSuperclass().getSuperclass());
//		System.out.println(loader.getClass().getSuperclass().getSuperclass().getSuperclass());
		Class finalCLs = loader.getClass().getSuperclass().getSuperclass().getSuperclass();
//		Field usr_paths = finalCLs.getDeclaredField("usr_paths");
//		Field usr_paths = Reflect.on(loader).field("usr_paths").get();
//		usr_paths.setAccessible(true);
		System.out.println(Arrays.toString((String[])Reflect.on(loader).field("usr_paths").get()));
		Field sys_paths = finalCLs.getDeclaredField("sys_paths");
		sys_paths.setAccessible(true);
		System.out.println(Arrays.toString((String[]) sys_paths.get(loader)));
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
    }
}
