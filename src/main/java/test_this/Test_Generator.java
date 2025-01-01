package test_this;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test_Generator {
    static class A{}
    static class B extends A{}

    static class C extends B{}
    static class D extends C{}

    public static void main(String[] args) {
	  List<A> listA= new ArrayList<A>();
	  List<B> listB= new ArrayList<B>();
	  List<C> listC= new ArrayList<C>();
	  List<D> listD= new ArrayList<D>();

	  listA.add(new A());
	  listB.add(new B());
	  listC.add(new C());
	  listD.add(new D());

	  List<C> listT = new ArrayList<>();
	  Collections.copy(listT,listD);
    }
}
