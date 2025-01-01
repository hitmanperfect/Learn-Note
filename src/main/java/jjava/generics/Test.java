package jjava.generics;

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.ArrayList;
import java.util.List;

/**
 * 不变性，List<Object> 和 List<String> 没有关系
 * 协变，List<String> 是 List<? extends Object> 子类型
 * 逆变，List<Object> 是 List<? super String> 子类型
 * 在类型安全的基础上，提高其灵活性
 *
 * Type variance refers to the techniques by which we can allow,
 * or not allow, subtyping in our parameterized types.
 *
 * */
public class Test {

    public static void main(String[] args) {

	  List<String> strings = new ArrayList<>();
	  List<? extends Object> objects = strings;
	  objects.add(null);
	  objects.get(0);


	  List<Object> objects1 = new ArrayList<>();
	  List<? super String>  one = objects1;
//	  methodB(strings);
//	  methodA(strings);

	  List<? extends Fruit> fruits = new ArrayList<Orange>();
//编译错误:不能添加任何类型的对象
//fruits.add(new Orange());
//fruits.add(new Fruit());
//fruits.add(new Object());
	  fruits.add(null);//可以这么做，但是没有意义
//我们知道，返回值肯定是Fruit
	  Fruit f = fruits.get(0);

	  List<? super Fruit> oranges = new ArrayList<Object>();
//	  Orange orange = oranges.get(0);
//	  Fruit fruit = oranges.get(0);
	  oranges.add(new Fruit());
	  oranges.add(new Orange());
//	  oranges.add(new Object());
    }




    static void methodA (List<Object> objects){

    }

    static void methodB (List<? extends Object> strings){

    }

    static class Fruit extends  Object{}
    static class Orange extends Fruit{}
}
