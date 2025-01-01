package test_this;

public class Safgafdg {
    public static void main(String[] args) {
//        AbstractL.Inner inner = new AbstractL.Inner();
//	  System.out.println(inner);
//        String s11 = "abcasafdfs";
        String s1 = new String("java");
        String s2 = new String("java");

        String s3 = s1.intern();
        String s4 = s2.intern();
        String s5 = s1.intern();

        System.out.println("s3 == s4"+ (s4==s3));
        System.out.println("s4 == s5"+ (s5==s4));
//        System.out.println("s11 == s5"+ (s11==s5));
//        System.out.println("s11 == s3"+ (s11==s3));
        System.out.println("s1 == s3"+ (s1==s3));
    }

}
