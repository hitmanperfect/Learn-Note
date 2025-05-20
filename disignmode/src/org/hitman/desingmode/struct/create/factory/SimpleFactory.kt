package org.hitman.desingmode.struct.create.factory

import org.hitman.desingmode.struct.create.factory.car.Baoma
import org.hitman.desingmode.struct.create.factory.car.Benchi
import org.hitman.desingmode.struct.create.factory.car.ICar

/**
 * 特征：只有一个静态函数，根据不同的输入，返回不同的对象实例
 * 缺点：违反开闭原则，新增一个 Audi Car ,需要修改 getCar 方法。
 *

 */
class SimpleFactory {
    fun getCar(name:String): ICar?{
        return if (name == "baoma") {
            Baoma()
        }else if (name == "benchi") {
            Benchi()
        }else {
            null
        }
    }
}