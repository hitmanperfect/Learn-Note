package test_this;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class RegTest {
    static {
	  System.out.println("this is test_this.RegTest");
    }
    public static void main(String[] args) {
	  String dir = "/Users/lzq/Documents/test";
	  File file = new File(dir);

	  String internalPluginPrefix = "app_";
	  String[] pluginList = {"app_epg","app_albumlist","app_screensaver"};
	  StringBuilder builder = new StringBuilder();
	  builder.append("(");
	  for (String it :pluginList) {
		if (it.startsWith(internalPluginPrefix)) {
		    String str = it.substring(4);
		    System.out.println(str);
		    builder.append(str);
		    builder.append("|");
		}
	  }
	  builder.deleteCharAt(builder.length()-1);
	  builder.append(")");

	  String reg = "com\\.gala\\.video\\.plugin\\.((?!"+builder.toString()+").)*.*(json|apk)";
	  System.out.println("reg = "+reg);
	  File[] files = file.listFiles(new FilenameFilter() {
		@Override
		public boolean accept(File dir, String name) {
		    if (Pattern.matches(reg,name)) {
		        return true;
		    }
		    return false;
		}
	  });
	  System.out.println(Arrays.asList(files));
    }
}
