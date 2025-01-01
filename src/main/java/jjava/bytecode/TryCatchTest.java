package jjava.bytecode;

public class TryCatchTest {
    public static int  testException() throws Exception{
	  try{
		throw new Exception("exception in try");
	  }
	  catch(Exception e){
		throw new Exception("exception in catch");
	  }
	  finally{
		throw new Exception("exception in finally");
	  }
    }

    int get1() {
	  return 1;
    }
    int get2() {
	  try {
		return 1;
	  }finally {
		return 2;
	  }
    }

    public static void main(String[] args) {
	  try {
		testException();
	  } catch (Exception e) {
	      e.printStackTrace();
	  }

    }
    //分别为try块、catch块和finally块中被调用的函数
    public void inside_try(){   }
    public void inside_catch(Exception e){  }
    public void inside_finally(){}
}
