package jjava.vtable;

public class MyA implements IA {

    void get(){
        String s = "a" + "b" + "c";
        String s1 = "a1";
        String s2 = "a2";
        String s3 = s1+s2;
        IA t = new MyA();
        t.test();
    }
    @Override
    public void test() {

    }


}
