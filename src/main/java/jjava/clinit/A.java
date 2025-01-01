package jjava.clinit;

public class A {
    static Class<?> cls = B.class;
    static int i = C.i;
    static {
	  System.out.println("this is A class");
    }

    public static void main(String[] args) {

    }
}
