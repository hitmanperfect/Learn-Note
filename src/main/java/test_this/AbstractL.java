package test_this;

public abstract class AbstractL {
    private  final String TAG = "AbstractL";

    @Override
    public String toString(){
        return this.TAG;
    }

    class Inner {
        String TAG = "Inner";
        public String toString(){
            return this.TAG;
	  }
    }

}
