package jjava.string;

import java.util.Arrays;

public class SplitTest {
    public static void main(String[] args) {
	  String str = "#aa#bb#cc#d#e";
	  String[] strs = str.split("#",2);
	  System.out.println(Arrays.asList(strs));
    }
    protected  void  test(){};
}
