package file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileFilterTest {
    public static void main(String[] args) {
		String path = "/Users/lzq/Desktop";
//		File[] files = new File(path).listFiles(new FilenameFilter() {
//		    @Override
//		    public boolean accept(File dir, String name) {
//			  System.out.println( dir.getName() + "/" + name);
//			  return false;
//		    }
//		});
	   new File(path).listFiles(new FileFilter() {
		 @Override
		 public boolean accept(File pathname) {
		     System.out.println(pathname.getName());
		     return false;
		 }
	   });
    }
}
