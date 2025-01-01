package unsafe;

public class Test {
    public static void main(String[] args) {
	  try {
//		Student student = UnSafeAllocate.create().newInstance(Student.class);//只是分派了内存，并没有做任何初始化的操作
//		System.out.println(student.name);
//		student.name = "落花滿天蔽月光，借一杯附薦鳳臺上";
//		System.out.println(student.name);
//		System.out.println("08-00-27-B0-47-60".replace("-",":"));
		String str = "4";
		for(int i = 0;i<str.length();i++){
		    char charc = str.charAt(i);
		    int intc = charc;
		    Character c = charc;
//		    Integer integerc = charc;
		    System.out.println("charc = " + charc);
		    System.out.println("intc = " + intc);
		    System.out.println("Characterc = " + c);
		}
		char c = '4';
		byte b = '4';
		int ic = c;
		int ib = b;
		System.out.println( c == b);
//		System.out.println(ib);
	  } catch (Throwable e) {
	      e.printStackTrace();
	  }

    }
}
