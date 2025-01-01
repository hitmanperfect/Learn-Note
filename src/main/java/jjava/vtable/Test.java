package jjava.vtable;

/**
 *  被 final 修饰的类，没有子类可以继承，所以不会参与 方法的动态绑定
 * */
public final class Test {

    void test(){
    }

    private void test1(){
    }

    public final void test2(){
    }
    public static void test3(){
    }
    public static final void test4(){
    }



    public  void main(String[] args) {

	  test();
	  test1();
	  test2();
	  test3();
	  test4();
    }
}
