package jjava.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader1 extends ClassLoader  {
    private static final String TAG = "MyClassLoader1";
    //指定路径
    private String path ;
    private final static String CLS_SUFFIX = ".class";


    public MyClassLoader1(String classPath){
	  path=classPath;
    }

    /**
     * 重写findClass方法
     * @param name 是我们这个类的全路径
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//	  System.out.println(TAG+ "load " + name);
	  Class log = null;
	  // 获取该class文件字节码数组
	  byte[] classData = getData(name);

	  if (classData != null) {
		// 将class的字节码数组转换成Class类的实例
		log = defineClass(name, classData, 0, classData.length);
	  }
	  return log;
    }

    /**
     * 将class文件转化为字节码数组
     * @return
     */
    private byte[] getData(String clsName) {

	  File file = new File(path,clsName+CLS_SUFFIX);
	  if (file.exists()){
		FileInputStream in = null;
		ByteArrayOutputStream out = null;
		try {
		    in = new FileInputStream(file);
		    out = new ByteArrayOutputStream();

		    byte[] buffer = new byte[1024];
		    int size = 0;
		    while ((size = in.read(buffer)) != -1) {
			  out.write(buffer, 0, size);
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
			  in.close();
		    } catch (IOException e) {

			  e.printStackTrace();
		    }
		}
		return out.toByteArray();
	  }else{
		return null;
	  }


    }
}
