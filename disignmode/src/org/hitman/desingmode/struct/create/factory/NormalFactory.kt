package org.hitman.desingmode.struct.create.factory

import org.hitman.desingmode.struct.create.factory.car.Baoma
import org.hitman.desingmode.struct.create.factory.car.Benchi
import org.hitman.desingmode.struct.create.factory.car.ICar

interface ICarFactory {
    fun getCar(): ICar
}

class BenchiFactory: ICarFactory {
    override fun getCar(): ICar {
        return Benchi()
    }
}
class BaomaFactory: ICarFactory {
    override fun getCar(): ICar {
        return Baoma()
    }
}

//new add audi - begin

class AudiFactory: ICarFactory {
    override fun getCar(): ICar {
        TODO("Not yet implemented")
    }
}
class Audi: ICar{
    override fun getName(): String {
        return "Audi"
    }
}
////new add audi - end


/**
 * normalFactory , 对扩展开放，对修改关闭，
 */
fun test(){
    val benchiFactory = BenchiFactory()
    val banmaFactory = BaomaFactory()
    val benchiCar = benchiFactory.getCar()
    val baoma = banmaFactory.getCar()

    //new add for audi
    val audiFactory = AudiFactory()
    val audiCar = audiFactory.getCar()
}