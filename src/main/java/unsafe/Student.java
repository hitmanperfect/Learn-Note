package unsafe;

public class Student {
    private Student() {
	  throw new IllegalArgumentException("can not create.");
    }
    public String name;
}
