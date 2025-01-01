package operator;

import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUitl {
    private static final String CUSTOMER_PKGNAME_SPLIT = ";";

    /**
     * Returns true if the string is null or 0-length.
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    public static boolean isEmpty(CharSequence str) {
	  return str == null || str.length() == 0;
    }

    public static boolean isNullOrEmpty(CharSequence str) {
	  return isEmpty(str) || "null".equalsIgnoreCase(str.toString());
    }

    public static String defaultIfEmpty(String var, String def) {
	  return var == null ? def : var;
    }

    public static String append(String str1, String str2) {
	  boolean empty1 = isEmpty(str1);
	  boolean empty2 = isEmpty(str2);
	  if (empty1 && !empty2) {
		return str2;
	  }
	  if (!empty1 && !empty2) {
		return str1 + str2;
	  }
	  if (!empty1 && empty2) {
		return str1;
	  }
	  return null;
    }

    public static int getLength(CharSequence str) {
	  return isEmpty(str) ? 0: str.length();
    }

    public static boolean isTrimEmpty(String text) {
	  if (text == null || text.trim().equals("")) {
		return true;
	  }
	  return false;
    }

    /**
     * 判断字符串是否为空
     *
     * @param strs
     * @return true - 全为空， false - 有一个不为空
     */
    public static boolean isEmpty(String... strs) {
	  if (strs == null) {
		return true;
	  }

	  for (String str : strs) {
		if ((str != null) && !str.isEmpty()) {
		    return false;
		}
	  }

	  return true;
    }

    /**
     * 判断字符串是否为空
     *
     * @param strs
     * @return true - 有一个不为空， false - 全部不为空
     */
    public static boolean hasEmpty(String... strs) {
	  if (strs == null) {
		return true;
	  }

	  for (String str : strs) {
		if ((str == null) || str.isEmpty()) {
		    return true;
		}
	  }

	  return false;
    }

    public static int parse(String str, int defaultValue) {
	  int value = defaultValue;
	  try {
		value = Integer.parseInt(str);
	  } catch (NumberFormatException e) {
		System.out.println("parse exception input = " + str+e);
	  }
	  return value;
    }

    public static long parse(String str, long defaultValue) {
	  long value = defaultValue;
	  try {
		value = Long.parseLong(str);
	  } catch (NumberFormatException e) {
	  }
	  return value;
    }

    /**
     * 把字符串转化为int
     *
     * @return
     */
    public static int parseInt(String str) {
	  try {
		if (str != null) {
		    return Integer.parseInt(str.trim());
		}
	  } catch (Exception e) {
	  }

	  return 0;
    }

    /**
     * 把字符串转化为int
     *
     * @return
     */
    public static long parseLong(String str) {
	  try {
		if (!isTrimEmpty(str)) {
		    return Long.parseLong(str.trim());
		}
	  } catch (Exception e) {
	  }

	  return 0;
    }

    /**
     * 把字符串转化为float
     *
     * @return
     */
    public static float parseFloat(String str, float defaultValue) {
	  try {
		if (str != null) {
		    return Float.parseFloat(str.trim());
		}
	  } catch (Exception e) {
	  }
	  return defaultValue;
    }

    /**
     * base64编码
     *
     * @param str
     * @return


    /**
     * 获取md5加密
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
	  try {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.reset();
		messageDigest.update(str.getBytes("UTF-8"));
		byte[] bytes = messageDigest.digest();
		StringBuffer sbuffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
		    if (Integer.toHexString(0xFF & bytes[i]).length() == 1) {
			  sbuffer.append("0").append(Integer.toHexString(0xFF & bytes[i]));
		    } else {
			  sbuffer.append(Integer.toHexString(0xFF & bytes[i]));
		    }
		}

		return sbuffer.toString();
	  } catch (Exception e) {
	  }

	  return "";
    }

    public static String replaceBlank(String src) {
	  Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
	  Matcher matcher = pattern.matcher(src);
	  String result = matcher.replaceAll("");

	  return result;
    }

    /**
     * 获取md5加密
     *
     * @param str
     * @return
     */
    public static String md5MultScreen(String str) {
	  String md5str = md5(str);
	  if (md5str == null || md5str.length() == 0) {
		return "";
	  }

	  String result = "";
	  if (md5str.length() == 32) {
		StringBuffer sbuffer = new StringBuffer();
		String str1 = md5str.substring(0, 6);
		String str2 = md5str.substring(6, 16);
		String str3 = md5str.substring(16, 26);
		String str4 = md5str.substring(26, md5str.length());
		sbuffer.append(str1);
		sbuffer.append(str4);
		sbuffer.append(str3);
		sbuffer.append(str2);
		sbuffer = sbuffer.reverse();
		result = md5(sbuffer.substring(4, 15));
	  }

	  return result;
    }

    public static String formatLongToTimeStr(Long l) {
	  int minute = 0;
	  int second = l.intValue() / 1000;
	  if (second > 60) {
		minute = second / 60;
		second = second % 60;
	  }

	  return minute + "分";
    }

    private static StringBuilder mFormatBuilder;
    private static Formatter mFormatter;
    static {
	  mFormatBuilder = new StringBuilder();
	  mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
    }

    public static String stringForTime(int timeMs, boolean isFull) {
	  int totalSeconds = timeMs / 1000;

	  int seconds = totalSeconds % 60;
	  int minutes = (totalSeconds / 60) % 60;
	  int hours = totalSeconds / 3600;

	  mFormatBuilder.setLength(0);
	  if (isFull) {
		return mFormatter.format("%02d:%02d:%02d", hours, minutes, seconds).toString();
	  } else {
		if (hours > 0) {
		    return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
		} else {
		    return mFormatter.format("%02d:%02d", minutes, seconds).toString();
		}
	  }
    }

    public static String stringForTime(int timeMs) {
	  return stringForTime(timeMs, false);
    }

    public static String filterSuffix(String str) {
	  return str;
	  // int startIndex = str.indexOf("(");
	  // int endIndex = str.indexOf(")");
	  // if(startIndex == -1 || endIndex == -1) {
	  // startIndex = str.indexOf("（");
	  // endIndex = str.indexOf("）");
	  // }
	  // if(startIndex != -1 && endIndex != -1) {
	  // String childStr = str.substring(startIndex, endIndex + 1);
	  // str = str.replace(childStr, "");
	  // }
	  // return str;
    }


    public static List<String> parseStringtoList(String string) {
	  String[] StringArray = string.split(CUSTOMER_PKGNAME_SPLIT);
	  List<String> stringList = new ArrayList<String>();
	  if (StringArray != null) {
		for (int i = 0, size = StringArray.length; i < size; i++) {
		    if (StringArray[i] != null && !"".equals(StringArray[i].trim())) {
			  stringList.add(StringArray[i]);
		    }
		}
	  }
	  return stringList;
    }

    public static boolean isMailAddress(String mail) {
	  if (!isEmpty(mail)) {
		Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher m = p.matcher(mail);
		return m.matches();
	  }
	  return false;
    }

    public static boolean checkPassword(String input_password) {
	  int length = input_password.length();
	  if (length >= 4 && length <= 20) {
		Pattern pattern = Pattern.compile("[a-z0-9A-Z]+");
		Matcher matcher = pattern.matcher(input_password);
		return matcher.matches();
	  }

	  return false;
    }

    public static boolean isMobileNO(String mobiles) {
	  if (!isEmpty(mobiles)) {
		Pattern p = Pattern.compile("^\\d{11}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	  }
	  return false;
    }

    public static boolean equals(CharSequence cs1, CharSequence cs2) {
	  return cs1 == null ? cs2 == null : cs1.equals(cs2);
    }

    public static boolean isBlank(CharSequence cs) {
	  int strLen;
	  if (cs == null || (strLen = cs.length()) == 0) {
		return true;
	  }
	  for (int i = 0; i < strLen; i++) {
		if (Character.isWhitespace(cs.charAt(i)) == false) {
		    return false;
		}
	  }
	  return true;
    }

    public static String[] split(String str, String separatorChars) {
	  return splitWorker(str, separatorChars, -1, false);
    }

    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
	  if (str == null) {
		return null;
	  }
	  int len = str.length();
	  if (len == 0) {
		return EMPTY_STRING_ARRAY;
	  }
	  List<String> list = new ArrayList<String>();
	  int sizePlus1 = 1;
	  int i = 0, start = 0;
	  boolean match = false;
	  boolean lastMatch = false;
	  if (separatorChars == null) {
		// Null separator means use whitespace
		while (i < len) {
		    if (Character.isWhitespace(str.charAt(i))) {
			  if (match || preserveAllTokens) {
				lastMatch = true;
				if (sizePlus1++ == max) {
				    i = len;
				    lastMatch = false;
				}
				list.add(str.substring(start, i));
				match = false;
			  }
			  start = ++i;
			  continue;
		    }
		    lastMatch = false;
		    match = true;
		    i++;
		}
	  } else if (separatorChars.length() == 1) {
		// Optimise 1 character case
		char sep = separatorChars.charAt(0);
		while (i < len) {
		    if (str.charAt(i) == sep) {
			  if (match || preserveAllTokens) {
				lastMatch = true;
				if (sizePlus1++ == max) {
				    i = len;
				    lastMatch = false;
				}
				list.add(str.substring(start, i));
				match = false;
			  }
			  start = ++i;
			  continue;
		    }
		    lastMatch = false;
		    match = true;
		    i++;
		}
	  } else {
		// standard case
		while (i < len) {
		    if (separatorChars.indexOf(str.charAt(i)) >= 0) {
			  if (match || preserveAllTokens) {
				lastMatch = true;
				if (sizePlus1++ == max) {
				    i = len;
				    lastMatch = false;
				}
				list.add(str.substring(start, i));
				match = false;
			  }
			  start = ++i;
			  continue;
		    }
		    lastMatch = false;
		    match = true;
		    i++;
		}
	  }
	  if (match || preserveAllTokens && lastMatch) {
		list.add(str.substring(start, i));
	  }
	  return list.toArray(new String[list.size()]);
    }

    public static boolean isAllChar(String str) {
	  Pattern p = Pattern.compile("^[A-Za-z]+$");
	  Matcher m = p.matcher(str);
	  return m.matches();
    }

    public static String filter(String value, String filterValue) {
	  try {
		String[] splitChars = filterValue.split(",");

		for(int i = 0; i < splitChars.length; ++i) {
		    value = value.replace(splitChars[i].toLowerCase(), "");
		}
	  } catch (Exception var4) {
	  }

	  return value;
    }

    public static String getBeforeAString(String str, String splitStr) {
	  try {
		String[] splitChars = splitStr.split(",");

		for(int i = 0; i < splitChars.length; ++i) {
		    Pattern pattern = Pattern.compile(splitChars[i]);
		    Matcher matcher = pattern.matcher(str);
		    if (matcher.find()) {
			  return getBeforeA(str, splitChars[i]);
		    }
		}
	  } catch (Exception var6) {
		;
	  }

	  return str;
    }

    private static String getBeforeA(String value, String a) {
	  try {
		value = "#" + value;
		return getBetweenAandB(value, "#", a.toLowerCase());
	  } catch (Exception var3) {
		return value;
	  }
    }

    public static String getBetweenAandB(String value, String a, String b) {
	  try {
		Pattern p = Pattern.compile(a + "(.*?)" + b);
		Matcher m = p.matcher(value);
		if (m.find()) {
		    String result = m.group(0);
		    result = filter(result, a + "," + b);
		    return result;
		}
	  } catch (Exception var6) {
		;
	  }

	  return value;
    }



    /**
     * 过滤掉包含<></>的内容，提取真正的中文字符内容
     * @param toast
     * @return
     */
    private static String getRealString(String toast){
	  Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
	  Matcher matcher = pattern.matcher(toast);
	  String string = matcher.replaceAll("");
	  return string;
    }

    // OpenApk运营商项目OpenID位数必须为32或64位
    public static boolean checkOpenID(String input) {
	  int length = input.length();
	  if (length >= 32 || length == 64) {
		return true;
	  }
	  return false;
    }


    /**
     * 判断形如a,b,c这种形式中是否包含a
     */
    public static boolean isContainEnum(String allEnum, String oneEnum){
	  if(isEmpty(allEnum)){
		return false;
	  }
	  String[] enumArray=allEnum.split(",");
	  for (int i=0; i<enumArray.length; i++){
		if(oneEnum!=null&&oneEnum.equals(enumArray[i])){
		    return true;
		}
	  }
	  return false;
    }


    public static boolean isGif(String url){
	  if(url.endsWith(".gif")||url.endsWith(".GIF")){
		return true;
	  }
	  return false;
    }

}
