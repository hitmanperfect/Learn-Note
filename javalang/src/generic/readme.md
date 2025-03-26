# 知识点速查
- 逆变定义，语法，特点，特点分析（只能写，写什么？不能读，读是否会报错？是编译报错还是运行报错）
- 协变定义，语法，特点，特点分析（只能读，按什么读？不能写，写是否会报错？是编译报错还是运行报错）
- 不变定义，


# demo
- 协变： val list1: List<? extends Animal> = new ArrayList< Dog>()  //此时只能读，不能写
  - 记忆特征： List<? extends T>
- 逆变： val list2: List<? super Dog> = new ArrayList< Animal>()  // 此时只能写，不能读
  - 记忆特征： List<? super T>
- 不变： val list3:List< Animal> = new ArrayList< Dog>()      //编译报错

# 概念拆解
不变，是指泛型类型必须严格匹配。这是默认的泛型行为。 比如Dog是Animal的子类，
但 List< Dog> 不是 List< Animal> 的子类

逆变，允许将一个泛型类型的父类型赋值给子类型，主要用于“写入”操作。

协变（Covariance）允许将一个**泛型类型**的子类型赋值给父类型。

List<? extends Animal> 本身表示一个协变的类型，但是否真正体现协变的特性，取决于它是否被赋值以及如何使用。
体现协变特性方式有2：赋值行为 + 读取操作


#  理解&记忆
是先有的限制（只能写不能读，或者只能读不能写），才有的逆变和协变的概念。
List<? extends Animal> l1 = new ArrayList<Dog>(), 只知道里面是Animal的子类型（不会包含多种类型），但不知道是哪个子类型，所以不能往里面
写元素，只能按Animal读

List<? super Dog> l2 = new ArrayList<Animal>(), 只知道里面存的是Dog的父类型，但不知道是哪个父类型（Object or Animal 或者其他），
因为不知道类型，所以不能读，只能按Dog写

简称PECS， 这里面一共有3个角色，生产者、消费者、容器 
- Producer ， extends ，它作为生产者、user 只能作为消费者， 只能读取其中的内容，按什么读？按父类读
- Consumer ， super， 它作为消费者，user 只能作为生产者，往里写。能写什么类型？写子类的对象或者衍生对象
# 限制 & 编译器提供的能力
对于协变，加入元素，能提示报错
对于逆变，读取元素，不提示报错，但类型是any，需要强转
## Q: List< ? super Dog> 能否加入Animal 实例对象
A: 不可以。逆变（? super T）：表示这个泛型类型可以存储 T 或其父类的对象。
类型安全规则：你只能向这个列表中添加 T 或其子类的对象，而不能添加 T 的父类对象。
原因：为了避免类型安全问题，确保在运行时不会出现类型转换错误。


# 应用场景

方法入参，方法返回值，泛型类，泛型方法

List< Dog > 和 List< out Dog> 、List< in Dog> 是能够相互赋值的



