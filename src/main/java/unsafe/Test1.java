package unsafe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) {
	  String s = "2\t1469M\t25110357";
	  System.out.println(pattern1.matcher("25111").matches());
//	  System.out.println(isValid(s));
    }
    static Pattern pattern1 = Pattern.compile("\\d{1,}");
    static Pattern pattern2 = Pattern.compile("\\d{1,}\\*{0,1}\\d{1,}[mMgG]{0,1}");
    static  boolean isValid(String str) {
	  if (str == null || str.length() == 0) {
		return false;
	  }
	  String[] strs = str.split("\t");
//		    System.out.println(i++ + " "+ strs.length);
	  if (strs.length !=3 ){
		return false;
	  }
	  if (!pattern1.matcher(strs[0]).matches() || !pattern2.matcher(strs[1]).matches() || !pattern1.matcher(strs[2]).matches()) {
		return false;
	  }
	  return true;
    }

}

