package file;

import java.io.*;

public class FileTest {
    static final int i = 1;
    public static void main(String[] args) {
	  try {
	      File f = new File("..","../.");
		System.out.println(f.getPath());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getCanonicalPath());
		System.out.println(f.getName());
//		FileUtils.cleanDirectory(new File("/Users/lzq/Downloads/test"));
	  } catch (Exception e) {
	      e.printStackTrace();
	  }

    }
}
