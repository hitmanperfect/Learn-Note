package jjava.inner_class;

public class AccessDemo {
    public static void main(String[] args) {
	  AccessDemo demo = new AccessDemo();
	  AccessDemo.Inner inner = demo.new Inner();
	  inner.test();
    }
    private int a;
    private int getA() {
        return a;
    }
    class Inner{
        private void test() {
		System.out.println(a);
		System.out.println(getA());
		System.out.println(this);
//		System.out.println(this.this$0);
	  }
    }
}
