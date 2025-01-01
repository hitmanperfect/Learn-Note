package offer;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 * <p>
 * 输入：s = ""
 * 输出：' '
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 */
public class Offer_50 {
    static float floatDefault;
    static double doubleDefault;
    static String strDefault;
    static byte byteDefault;
    static short shortDefault;
    static boolean booleanDefault;
    static int intDefault;
    static char charDefault;

    /**
     * 1、字符串，当成 char[] 即可。
     * 2、char 的默认值 如何确定 ？打印下即可，默认值为 ‘ ’
     */
    public char firstUniqChar(String s) {

	  char[] chars = s.toCharArray();
	  int[] a = new int[256];
	  for (char c : chars) {
		a[c]++;
	  }

	  for (char c : chars) {

		if (a[c] == 1) return c;

	  }
	  return ' ';
    }

    public static void main(String[] args) {
	  System.out.println("float default  : " + floatDefault);
	  System.out.println("double default  : " + doubleDefault);
	  System.out.println("byte default  : " + byteDefault);
	  System.out.println("string default  : " + strDefault);
	  System.out.println("int default  : " + intDefault);
	  System.out.println("char default : " + charDefault);
	  System.out.println("boolean default : " + booleanDefault);
	  System.out.println(1920f/1080f );
    }
}
