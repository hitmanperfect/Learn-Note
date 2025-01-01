package jjava.dynamicProxy;

public class ProxyDoSth implements IDoSth{
    private IDoSth instance;
    public ProxyDoSth(IDoSth ins) {
        this.instance = ins;
    }
    @Override
    public void doSth(String s) {
	  long start = System.currentTimeMillis();
	  instance.doSth(s);
	  System.out.println(System.currentTimeMillis()-start);
    }
}
