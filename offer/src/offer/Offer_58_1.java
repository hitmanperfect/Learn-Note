package offer;

/**
 * ## 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 * 示例 2：
 *
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Offer_58_1 {
    public static void main(String[] args) {
	  String s = "the sky is blue";
	  System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
	  if (s == null) return null;
	  if (s.trim().length() == 0) return s.trim();//由于反转后的字符串不能含有空格，所以此处需要调用 trim()
	  s =s.trim().replaceAll(" +"," ");// 此处也可替换，最后合并String 时，再处理空格
	  String[] strs = s.split(" ");
	  StringBuilder sb = new StringBuilder();
	  for (int i = strs.length-1;i>=0; i--) {
	      sb.append(strs[i]).append(" ");
	  }
	  sb.deleteCharAt(sb.length()-1); // 此处也可去掉，返回 toString().trim();
	  return sb.toString();
    }
}
