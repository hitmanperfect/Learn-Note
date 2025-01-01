package jjava.reg;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SplitTest {
    public static void main(String[] args) {
//	  String str1 = "abc";
//	  String str2 = "abc#";
//	  String str3 = "#abc";
//	  String str4 = " #abc";
//	  String str5 = "abc# ";
//	  System.out.println(str1.split("#").length);
//	  System.out.println(str2.split("#").length);
//	  System.out.println(str3.split("#").length);
//	  System.out.println(str4.split("#").length);
//	  System.out.println(str5.split("#").length);
//
//	  System.out.println(Arrays.asList(str3.split("#")));
//	  System.out.println("".split("#").length);
//
//	  boolean res = Pattern.compile("/a.*").matcher("/ac").matches();
//	  System.out.println(res);

//	  System.out.println("  \t\n".replaceAll("\\s","#"));
	  analysisDecimal("1.00");
    }
    public static int[] analysisDecimal(String decStr) {
	  int[] res = {0, 100};
	  try {
		double dec = Double.parseDouble(decStr);
		if (dec > 1.0) {
		    dec = 1.0;
		} else if (dec < 0) {
		    dec = 0;
		}
		System.out.println(1.0e-7);
		if (Math.abs(dec - 1.0) < 1.0e-7) {
		    res[0] = 100;
		    res[1] = 100;
		} else if (Math.abs(dec) < 1.0e-7) {
		    res[0] = 0;
		    res[1] = 100;
		} else {
		    int integerPlaces = decStr.indexOf(".");
		    int decimalPlaces = decStr.length() - integerPlaces - 1;
		    if (decimalPlaces <= 0) {
			  res[0] = 0;
			  res[1] = 100;
		    } else {
			  res[1] = (int) Math.pow(10.0, (double) decimalPlaces);
			  res[0] = (int) (res[1] * dec);
		    }
		}
	  } catch (Exception ex) {
		res[0] = 0;
		res[1] = 100;
	  }
	  System.out.println(res[0]);
	  System.out.println(res[1]);
	  return res;
    }
}
