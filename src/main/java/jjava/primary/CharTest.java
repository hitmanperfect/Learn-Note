package jjava.primary;

import java.util.Arrays;

/**
 * char 强转int 的话会按照 ascII 码转换，如4会转成52，
 * 如何 由 char ‘4’ 得到 int 类型的 4 呢？？？
 * 减去字符 ‘0’  即可 ,用 {@link Character#digit(int,int)} 也可
 * */
public class CharTest {
    public static void main(String[] args) {
	  System.out.println('4' * '4'); //输出  2704,且是编译期间干的事，非运行期
        //如何由 char ‘4’ 得到 int 类型的 4 呢？？？
	  char c = '4';
	  System.out.println(c);
	  System.out.println(Character.digit('4',10)); //该方法不符合要求时，会返回 -1
	  // char 转 int ，会按照 ascii 码转换，char 做 加减法时，会先转成 int 值，再进行运算
	  char c1 = '4';
	  System.out.println((int )c);
	  // int 转 char，会按照ascii 码同 char 对应，52 对应的char 是 '4'
	  int a = 1024;
	  char b = (char) a;
	  System.out.println(b);

	  char[] cs = new char[3];
	  cs[0]='0';
	  cs[1]='1';
	  cs[2]='2';
	  char[] cs1 = new char[3];
	  System.arraycopy(cs,0,cs1,0,2);
	  System.out.println(Arrays.toString(cs1));
    }
}
