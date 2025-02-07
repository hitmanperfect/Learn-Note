package generic;

import java.util.ArrayList;
import java.util.List;

public class TestGenericJava {
    public static void main(String[] args) {
        TestGenericJava demo = new TestGenericJava();
        demo.testAssign();
    }

    void testBubian(){
        List<Dog> l1 = new ArrayList<>();
//        List<Animal> l2 = l1;   //编译报错
    }
     void testNibian(){
        List<? super Dog> l1 = new ArrayList<Animal>();

        l1.add(new Dog());
        l1.add(new Puppy());
        //是否可以加入Animal对象？ 不可以
//         l1.add(new Animal());    // 假设可以加入，然后将l1 赋值给l2，l2参数类型是Dog，按Dog取出来实际上是Animal ，可能会发生类型转换错误。
         List<Dog> l2 = (List<Dog>)l1;
        Dog d1 = l2.get(0);    //类型错误 ，实际上取出来的是animal对象。
//        Object  d1 = l1.get(0);
//        Dog d2 = l1.get(0); //类型是Dog的父类型，但你不知道是什么类型， 所以取出来是object类型，不能转为 Dog类型
     }


    void testXieian(){
        List<? extends Animal> l1 = new ArrayList<Dog>();
//        l1.add(new Dog());  //只知道是 Animal的子类型，但你不知道是什么具体类型，所以不能随便添加，只能读取
//        l1.add(new Puppy());//只知道是 Animal的子类型，但你不知道是什么具体类型，所以不能随便添加，只能读取
        Animal  d1 = l1.get(0);     //按什么读，类型是Animal的子类型，但只能按Animal 读
//        Dog d2 = l1.get(0);         //编译报错，按Dog读，万一有可能是cat呢？
    }

    /**
     * 同一类型的不变、协变、和逆变能够互相赋值
     * */
    void testAssign(){
        List< Dog > l1 = new ArrayList<>();
        l1.add(new Dog());
        List< ? extends Dog>  l2 = l1;
        List<? super Dog>  l3 = l1;

//        、List< in Dog>
        System.out.println("suc1 ");
        List< ? extends Animal>  l21 = new ArrayList<Dog>();
//        l21.add(new Dog());

        List< Animal > l22 = (List< Animal >)l21;
        List< ? super Animal > l23 = (List< ? super Animal >)l21;
        System.out.println("suc2 ");


        List< ? super Dog>  l31 = new ArrayList<Animal>();
        l31.add(new Dog());
        List< Dog > l32 = (List< Dog >)l31;
        List< ? extends Dog > l33 = (List< ? extends Dog >)l31;
        System.out.println("suc3 ");

    }
}
