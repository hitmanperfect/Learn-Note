# Question
val list1: List<? extends Animal> = new ArrayList<Dog>()

上面这行语句，是有 “List<? extends Animal>” 就可以认为其是协变，还是必须存在 赋值行为才可以这么认为
Avatar

# Answer
在 Java 和 Kotlin 中，协变（Covariance）的定义和使用方式是通过上下文来决定的，而不仅仅是通过声明本身。具体来说，List<? extends Animal> 本身表示一个协变的类型，但是否真正体现协变的特性，取决于它是否被赋值以及如何使用。
1. 协变的定义
   协变（Covariance）允许将一个泛型类型的子类型赋值给父类型。在 Java 中，协变通过 ? extends T 表示。例如：
   List<? extends Animal> 表示这个列表可以存储 Animal 或其子类的对象。
2. 是否必须存在赋值行为？
   答案是：不一定。 List<? extends Animal> 本身就是一个协变的类型声明，即使没有赋值行为，它也表示一种协变的类型。不过，赋值行为是体现协变特性的一个重要场景。
   没有赋值行为的情况
   即使没有赋值行为，List<? extends Animal> 仍然表示一个协变的类型。例如：

   List<? extends Animal> list1 = new ArrayList<>();
   这里，list1 被声明为一个协变的列表，可以存储 Animal 或其子类的对象。即使没有赋值行为，这个声明本身已经体现了协变的特性。
   有赋值行为的情况
   当存在赋值行为时，协变的特性更加明显。例如：

   List<? extends Animal> list1 = new ArrayList<Dog>();
   这里，list1 被声明为一个协变的列表，并且被赋值为一个 ArrayList<Dog>。由于 Dog 是 Animal 的子类，根据协变的规则，ArrayList<Dog> 可以赋值给 List<? extends Animal>。
3. 使用场景
   协变的特性在以下两种情况下体现得更明显：
   赋值行为：将子类型的实例赋值给父类型的变量。
   读取操作：从协变的列表中读取对象。

   赋值行为
   List<? extends Animal> list1 = new ArrayList<Dog>(); // 协变：子类型赋值给父类型
   读取操作
   List<? extends Animal> list1 = new ArrayList<>();
   list1.add(new Dog()); // 不合法：协变的列表只能用于读取操作
   Animal animal = list1.get(0); // 合法：读取操作
4. 总结
   List<? extends Animal> 本身就是一个协变的类型声明，表示这个列表可以存储 Animal 或其子类的对象。
   赋值行为是体现协变特性的一个重要场景，但即使没有赋值行为，List<? extends Animal> 仍然表示一个协变的类型。
   协变的主要用途：允许子类型的实例赋值给父类型的变量，并且支持从列表中读取对象。
   因此，List<? extends Animal> 本身就可以认为是协变的，而赋值行为只是体现协变特性的一个具体场景。