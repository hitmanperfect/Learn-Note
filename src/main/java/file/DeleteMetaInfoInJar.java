package file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class DeleteMetaInfoInJar {

    public static void main(String[] args) {
	  try {
	      String jarName = "/Users/lzq/tmp/kotlin.jar";
	      List list = new ArrayList();
	      list.add("META-INF/versions/9/module-info.class");
		delete(jarName,list);

	  } catch (Exception e) {
	      e.printStackTrace();
	  }

    }

    private static void delete(String jarName, List<String> deletes) throws Exception {
	  //先备份
	  File oriFile = new File(jarName);
	  if (!oriFile.exists()) {
		System.out.println("######Not Find File:" + jarName);
		return;
	  }
	  //将文件名命名成备份文件
	  String bakJarName = jarName.substring(0, jarName.length() - 4) + "_tmp.jar";
	  File bakFile = new File(bakJarName);
	  boolean isOK = oriFile.renameTo(bakFile);
	  if (!isOK) {
		System.out.println("######Remame ERR..........");
		return;
	  }


	  //创建文件（根据备份文件并删除部分）
	  JarFile bakJarFile = new JarFile(bakJarName);
	  JarOutputStream jos = new JarOutputStream(new FileOutputStream(jarName));
	  Enumeration<JarEntry> entries = bakJarFile.entries();
	  while (entries.hasMoreElements()) {
		JarEntry entry = entries.nextElement();
		System.out.println(entry.getName());
		if (!entry.getName().startsWith("META")) {

//		    InputStream inputStream = bakJarFile.getInputStream(entry);
//		    jos.putNextEntry(entry);
//		    byte[] bytes = readStream(inputStream);
//		    jos.write(bytes, 0, bytes.length);
		}
		else {
		    System.out.println("Delete:-------" + entry.getName());
		}
	  }

	  jos.flush();
	  jos.finish();
	  jos.close();
	  bakJarFile.close();

    }
    private static byte[] readStream(InputStream inStream) throws Exception {
	  ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
	  byte[] buffer = new byte[1024];
	  int len = -1;
	  while ((len = inStream.read(buffer)) != -1) {
		outSteam.write(buffer, 0, len);
	  }
	  outSteam.close();
	  inStream.close();
	  return outSteam.toByteArray();
    }


}
