package test_this;

public class InternTest {
    public static void main(String[] args) {
	  String bb = new String("AABB");//此种方式创建String时,所以虽然 bb在堆中，但初始化阶段，会通过 ldc 指令加载 “AABB” 到常量池中，常量池中包含“AABB”
        String aa = new String("AA") + new String("BB");//此种方式创建的aa 在堆中, 常量池中包含了 “AA” 和 “BB”,
        String cIntern = aa.intern(); // 因为常量池中已经有了 “AABB”，所以这个cIntern 是指向常量池的
	  System.out.println(aa == cIntern);// aa 是堆中的，cIntern 是常量池中的，所以不相等



	  String ee = new String("EE") + new String("FF");
	  String ff = "EEFF";
	  System.out.println(ee == ff);//一个在堆中，一个在常量池中，所以输出是 false ，


	  // xx 在堆中，yy 通过xx.intern 在常量池中备份了一个xx 的引用，通过“xxyy” 声明的zz 应该在常量池中，但此时常量池已经有了引用
	  // （此处并不会创建实例，仍然保留xx引用的形式），所以按引用指向了xx,
	  String xx = new String("xx") + new String("yy");
	  String yy = xx.intern();
	  String zz = "xxyy";
	  System.out.println(xx == zz);//true

    }
    //先在常量池找，常量池中有，肯定用常量池的，常量池没有，则记录 首次出现的实例的引用。
    //通过new String(“AABB”)创建的对象 ，都是在堆中创建的，但此时new String("AABB“”)时，常量池中已经初始化好了这个“AABB”，
}
