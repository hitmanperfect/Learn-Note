package jjava.extend;

public class TestField {


    public static void main(String[] args) {
	  Father son = new Son();
	  int a1 = son.money;
	  int a2 = ((Son)son).money;
	  System.out.println(a1);
	  System.out.println(a2);
    }
}
class Father{
    int money = 1;
    public Father(){
	  money = 2;
	  System.out.println("father money : "+ money);
    }
}
class Son extends Father{
    public int money = 3;
    public Son(){
	  money = 4;
	  System.out.println("son money : "+ money);
    }
}
