package test_this;

public class TestInc {
    public static void main(String[] args) {
	  new TestInc().get();
    }
    void get(){
	  int i = 1;
	  i = i++;
	  int j = i++;
	  int k = i + ++i * i++;
	  System.out.println("i = " + i);
	  System.out.println("j = " + j);
	  System.out.println("k = " + k);
    }
}
