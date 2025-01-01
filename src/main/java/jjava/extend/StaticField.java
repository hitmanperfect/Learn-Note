package jjava.extend;

public class StaticField {
    public static void main(String[] args) {
        System.out.println(" A   B ".trim().length());
	  System.out.println(isEmpty(" A "));
    }
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
    static class A{
        static int A = 1;
    }
    static class B extends  A{

    }
}

