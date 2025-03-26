package generic;


open class Animal
open class Dog :Animal()
class Cat :Animal()
class Puppy:Dog()

class Template<T>
val tem:Template< out Animal> = Template<Dog>()
val tep2:Template<in Dog> = Template<Animal>()
fun main(){
    val list = mutableListOf<Dog>()
    addAnimals(list)
    printAnimals(list)
}

fun addAnimals(list:MutableList<in Dog>){
    list.add(Dog())
    list.add(Puppy())
}
fun printAnimals(list:MutableList<out Animal>){
    for (item in list) {
        println(item)
    }
}

fun testNibian(){

    //错误case1，List 是不可写的，所以此处有编译提示
    //val list2:List<in Dog> = mutableListOf<Animal>()

    //正确case1
    val list3:MutableList<in Dog> = mutableListOf<Animal>()
    list3.add(Dog())
    list3.add(Puppy())
//    list3.add(Animal())         //  编译报错，集合类型是Dog的父类型，但可add的元素类型必须是Dog及Dog的子类？
    //为什么不报错？ 编译器的行为
    //在 Kotlin 中，MutableList<in Dog> 的声明是合法的，但它的行为可能会让人误解。实际上，
    // Kotlin 编译器允许你从 MutableList<in Dog> 中读取元素，但读取的元素类型会被推断为 Any?，
    // 而不是具体的 Dog 类型。这是因为编译器无法确定列表中存储的具体类型，只能将其视为最通用的类型。
    val dog3 = list3[0]
//    val dog31 :Animal = list[0]     //此处报错 ，而不是Animal 或者 dog
//    val dog32 :Dog = list[0]     //此处报错 ，而不是Animal 或者 dog
    val l1: MutableList<in Dog?> = java.util.ArrayList<Animal?>()

}

fun testXiebian(){

    val list1: MutableList<out Animal> = ArrayList()
//    list1.add(Dog()) // 不合法：协变的列表只能用于读取操作
//    list1.add(Cat()) // 不合法：协变的列表只能用于读取操作

    val animal = list1[0] // 合法：读取操作

}

fun testbubian(){
    //错误case1 ，可变的集合，需要保证不变性
    val cats: MutableList<Cat> = mutableListOf()
//    val animals: MutableList<Animal> = cats // 编译错误 ,此时集合是可变的，需保证不变性

    //错误case2 ，不可变的集合，虽在kotlin中未提示编译报错，但不推荐这么写
    val cats2: List<Cat> = arrayListOf()
    val animals2: List<Animal> = cats // 编译ok,  但不推荐这么写，java中编译报错


    //编译报错，Animal类型不能转换为Dog类型
    var list:List<Animal> = arrayListOf(Animal())
    var list2 : List<Dog> = arrayListOf(Dog())

    list = list2

//    var list3:ArrayList<Animal> = arrayListOf(Animal())
//    var list4 : ArrayList<Dog> = arrayListOf(Dog())
//
//    list3 = list4
//    list2 = list
    println("testbubian suc：$list")
}
