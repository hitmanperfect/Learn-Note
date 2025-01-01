package offer;
/**
 *字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出:"umghlrlose"
 * 
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 *
 * */
public class Offer_58_2 {
    public static void main(String[] args) {
	  String str = "abcd";
	  int n = 5;
	  System.out.println(new Offer_58_2().reverseLeftWords(str,n));
    }
    public  String reverseLeftWords(String s, int n) {
	  if (s== null) return s;
	  int len = s.length();
	  if (n >= len) {
		return reverse(s);
	  } else {
		return s.substring(2)+s.substring(0,2);
	  }
    }
    //将前n个字符反转
    public  String reverse(String s) {
	  char[] chars = s.toCharArray();
	  int left = 0;
	  int right = chars.length-1;
	  while (left<right) {
		swap(chars,left,right);
		left++;
		right--;
	  }
	  return new String(chars,0,chars.length);
    }
     void  swap(char[] chars,int i,int j) {
	  char tmp = chars[i];
	  chars[i] = chars[j];
	  chars[j] = tmp;
    }
}
