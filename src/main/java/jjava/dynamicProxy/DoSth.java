package jjava.dynamicProxy;

public class DoSth implements IDoSth{
    @Override
    public void doSth(String s) {
	  System.out.println("doSth:" + s);
    }
}
