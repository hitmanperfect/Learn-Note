package offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * **/
// StringBuilder 的本质和String 一样，都是字节数组，
    // 唯一需要注意的就是：避免数组扩容带来的性能损耗，可以直接建立3倍数组空间

public class Offer_05 {

    public String replaceSpace(String s) {
	  if (s == null || s.length() == 0) {
	      return s;
	  }
	  //FIXME 避免数组扩容带来的性能损耗，可以直接建立3倍数组空间
	  StringBuilder sb = new StringBuilder(s.length()*3);
	  for (char c:s.toCharArray()) {
		if (c == ' ') {
		    sb.append("%20");
		} else {
		    sb.append(c);
		}
	  }
	  return sb.toString();
    }
}
